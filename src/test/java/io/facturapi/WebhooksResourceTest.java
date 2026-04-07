package io.facturapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.facturapi.http.FacturapiConfig;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.resources.WebhooksResource;
import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.junit.jupiter.api.Test;

class WebhooksResourceTest {
  @Test
  void validatesWebhookSignature() throws Exception {
    WebhooksResource webhooks = new WebhooksResource(
      new FacturapiHttpClient(FacturapiConfig.builder("sk_test").build())
    );

    String payload = "{\"type\":\"invoice.created\"}";
    String secret = "whsec_123";
    String signature = hmacHex(secret, payload);

    var event = webhooks.validateSignature(secret, signature, payload);
    assertEquals("invoice.created", event.getType());
  }

  @Test
  void rejectsInvalidWebhookSignature() {
    WebhooksResource webhooks = new WebhooksResource(
      new FacturapiHttpClient(FacturapiConfig.builder("sk_test").build())
    );

    assertThrows(
      FacturapiException.class,
      () -> webhooks.validateSignature("whsec_123", "00", "{}")
    );
  }

  private static String hmacHex(String secret, String payload) throws Exception {
    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
    byte[] digest = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));

    StringBuilder sb = new StringBuilder();
    for (byte b : digest) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }
}
