package io.facturapi.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.FacturapiException;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.ApiEvent;
import io.facturapi.models.SearchResult;
import io.facturapi.models.Webhook;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class WebhooksResource extends BaseResource {
  /**
   * Webhook endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Webhooks">API reference</a>
   */
  public WebhooksResource(FacturapiHttpClient client) {
    super(client);
  }

  /**
   * Creates a new webhook in your organization.
   *
   * @param data Webhook payload.
   * @return Created webhook.
   * @see <a href="https://docs.facturapi.io/api#operation/createWebhook">API reference</a>
   */
  public Webhook create(Map<String, Object> data) {
    return post("/webhooks", data, null, Webhook.class);
  }

  /**
   * Gets a paginated list of webhooks.
   *
   * @param params Search and pagination parameters.
   * @return Paginated webhook result.
   * @see <a href="https://docs.facturapi.io/api#operation/listWebhooks">API reference</a>
   */
  public SearchResult<Webhook> list(Map<String, ?> params) {
    return get("/webhooks", params, new TypeReference<SearchResult<Webhook>>() {});
  }

  /**
   * Gets a single webhook by id.
   *
   * @param id Webhook id.
   * @return Webhook object.
   * @see <a href="https://docs.facturapi.io/api#operation/getWebhook">API reference</a>
   */
  public Webhook retrieve(String id) {
    return get("/webhooks/" + id, null, Webhook.class);
  }

  /**
   * Updates a webhook.
   *
   * @param id Webhook id.
   * @param data Webhook payload updates.
   * @return Updated webhook.
   * @see <a href="https://docs.facturapi.io/api#operation/editWebhook">API reference</a>
   */
  public Webhook update(String id, Map<String, Object> data) {
    return put("/webhooks/" + id, data, null, Webhook.class);
  }

  /**
   * Permanently removes a webhook.
   *
   * @param id Webhook id.
   * @return Deleted webhook.
   * @see <a href="https://docs.facturapi.io/api#operation/deleteWebhook">API reference</a>
   */
  public Webhook delete(String id) {
    return delete("/webhooks/" + id, null, Webhook.class);
  }

  /**
   * Validates webhook signature and returns parsed event when valid.
   *
   * @param secret Webhook secret.
   * @param signatureHex Value from `facturapi-signature` header.
   * @param payload Raw request payload.
   * @return Parsed API event.
   * @see <a href="https://docs.facturapi.io/api#operation/validateWebhookSignature">API reference</a>
   */
  public ApiEvent validateSignature(String secret, String signatureHex, String payload) {
    try {
      byte[] expected = hmacSha256(secret, payload);
      byte[] provided = hexToBytes(signatureHex);
      if (!MessageDigest.isEqual(expected, provided)) {
        throw new FacturapiException("Invalid signature");
      }
      return client.getObjectMapper().readValue(payload, ApiEvent.class);
    } catch (IllegalArgumentException e) {
      throw new FacturapiException("Invalid signature", e);
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new FacturapiException("Signature validation failure", e);
    } catch (Exception e) {
      if (e instanceof FacturapiException) {
        throw (FacturapiException) e;
      }
      throw new FacturapiException("Invalid payload", e);
    }
  }

  private static byte[] hmacSha256(String secret, String payload)
    throws NoSuchAlgorithmException, InvalidKeyException {
    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
    return mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
  }

  private static byte[] hexToBytes(String hex) {
    if (hex == null || hex.length() % 2 != 0) {
      throw new IllegalArgumentException("Invalid signature");
    }
    int length = hex.length();
    byte[] bytes = new byte[length / 2];
    for (int i = 0; i < length; i += 2) {
      int high = Character.digit(hex.charAt(i), 16);
      int low = Character.digit(hex.charAt(i + 1), 16);
      if (high < 0 || low < 0) {
        throw new IllegalArgumentException("Invalid signature");
      }
      bytes[i / 2] = (byte) ((high << 4) + low);
    }
    return bytes;
  }
}
