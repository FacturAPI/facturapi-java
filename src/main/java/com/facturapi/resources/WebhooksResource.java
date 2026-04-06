package com.facturapi.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.facturapi.FacturapiException;
import com.facturapi.http.FacturapiHttpClient;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class WebhooksResource extends BaseResource {
  private final ObjectMapper objectMapper = new ObjectMapper();

  public WebhooksResource(FacturapiHttpClient client) {
    super(client);
  }

  public JsonNode create(Object data) {
    return post("/webhooks", data, null);
  }

  public JsonNode list(Map<String, ?> params) {
    return get("/webhooks", params);
  }

  public JsonNode all(Map<String, ?> params) {
    return list(params);
  }

  public JsonNode retrieve(String id) {
    return get("/webhooks/" + id, null);
  }

  public JsonNode update(String id, Object data) {
    return put("/webhooks/" + id, data, null);
  }

  public JsonNode delete(String id) {
    return delete("/webhooks/" + id, null);
  }

  public JsonNode del(String id) {
    return delete(id);
  }

  public JsonNode validateSignature(String secret, String signatureHex, String payload) {
    try {
      byte[] expected = hmacSha256(secret, payload);
      byte[] provided = hexToBytes(signatureHex);
      if (!MessageDigest.isEqual(expected, provided)) {
        throw new FacturapiException("Invalid signature");
      }
      return objectMapper.readTree(payload);
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

  public JsonNode validateSignature(String secret, String signatureHex, JsonNode payload) {
    return validateSignature(secret, signatureHex, payload.toString());
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
