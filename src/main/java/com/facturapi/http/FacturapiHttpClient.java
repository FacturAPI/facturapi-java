package com.facturapi.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.facturapi.FacturapiException;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class FacturapiHttpClient {
  private final HttpClient httpClient;
  private final ObjectMapper objectMapper;
  private final Duration timeout;
  private final String baseUrl;
  private final String apiKey;
  private final String userAgent;

  public FacturapiHttpClient(FacturapiConfig config) {
    this.httpClient = config.getHttpClient();
    this.objectMapper = config.getObjectMapper();
    this.timeout = config.getTimeout();
    this.baseUrl = config.getBaseUrl();
    this.apiKey = config.getApiKey();
    this.userAgent = config.getUserAgent();
  }

  public JsonNode getJson(String path, Map<String, ?> queryParams) {
    return requestJson("GET", path, queryParams, null, null);
  }

  public JsonNode postJson(String path, Object body, Map<String, ?> queryParams) {
    return requestJson("POST", path, queryParams, body, null);
  }

  public JsonNode putJson(String path, Object body, Map<String, ?> queryParams) {
    return requestJson("PUT", path, queryParams, body, null);
  }

  public JsonNode deleteJson(String path, Map<String, ?> queryParams) {
    return requestJson("DELETE", path, queryParams, null, null);
  }

  public JsonNode putMultipart(String path, MultipartBody multipartBody) {
    return requestJson("PUT", path, null, null, multipartBody);
  }

  public JsonNode postMultipart(String path, MultipartBody multipartBody) {
    return requestJson("POST", path, null, null, multipartBody);
  }

  public byte[] getBytes(String path) {
    return requestBytes("GET", path, null);
  }

  public byte[] postBytes(String path, Object body) {
    return requestBytes("POST", path, body);
  }

  private JsonNode requestJson(
    String method,
    String path,
    Map<String, ?> queryParams,
    Object body,
    MultipartBody multipartBody
  ) {
    try {
      HttpRequest request = buildRequest(method, path, queryParams, body, multipartBody);
      HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
      validateResponse(response);
      byte[] responseBytes = response.body();
      if (responseBytes == null || responseBytes.length == 0) {
        return objectMapper.createObjectNode();
      }
      String contentType = response.headers().firstValue("Content-Type").orElse("");
      if (!contentType.contains("application/json")) {
        return objectMapper.createObjectNode().put("value", new String(responseBytes, StandardCharsets.UTF_8));
      }
      return objectMapper.readTree(responseBytes);
    } catch (IOException e) {
      throw new FacturapiException("I/O error when calling Facturapi API", e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new FacturapiException("Request interrupted", e);
    }
  }

  private byte[] requestBytes(String method, String path, Object body) {
    try {
      HttpRequest request = buildRequest(method, path, null, body, null);
      HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
      validateResponse(response);
      return response.body();
    } catch (IOException e) {
      throw new FacturapiException("I/O error when calling Facturapi API", e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new FacturapiException("Request interrupted", e);
    }
  }

  private HttpRequest buildRequest(
    String method,
    String path,
    Map<String, ?> queryParams,
    Object body,
    MultipartBody multipartBody
  ) throws IOException {
    URI uri = URI.create(baseUrl + normalizePath(path) + buildQuery(queryParams));
    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
      .uri(uri)
      .timeout(timeout)
      .header("Authorization", "Bearer " + apiKey)
      .header("Accept", "application/json")
      .header("User-Agent", userAgent);

    HttpRequest.BodyPublisher publisher = HttpRequest.BodyPublishers.noBody();
    if (multipartBody != null) {
      publisher = multipartBody.getPublisher();
      requestBuilder.header("Content-Type", multipartBody.getContentType());
    } else if (body != null) {
      byte[] json = objectMapper.writeValueAsBytes(body);
      publisher = HttpRequest.BodyPublishers.ofByteArray(json);
      requestBuilder.header("Content-Type", "application/json");
    }

    requestBuilder.method(method, publisher);
    return requestBuilder.build();
  }

  private void validateResponse(HttpResponse<byte[]> response) {
    int statusCode = response.statusCode();
    if (statusCode < 200 || statusCode >= 300) {
      String bodyText = response.body() == null ? "" : new String(response.body(), StandardCharsets.UTF_8);
      String message = statusCode + " " + response.headers().firstValue(":status").orElse("Request failed");
      try {
        JsonNode error = objectMapper.readTree(bodyText);
        if (error.has("message") && error.get("message").isTextual()) {
          message = error.get("message").asText();
        } else if (!bodyText.isEmpty()) {
          message = bodyText;
        }
      } catch (Exception ignored) {
        if (!bodyText.isEmpty()) {
          message = bodyText;
        }
      }
      throw new FacturapiException(message, statusCode, bodyText);
    }
  }

  private static String normalizePath(String path) {
    if (path == null || path.isEmpty()) {
      return "";
    }
    return path.startsWith("/") ? path : "/" + path;
  }

  private static String buildQuery(Map<String, ?> queryParams) {
    if (queryParams == null || queryParams.isEmpty()) {
      return "";
    }

    List<String> parts = new ArrayList<>();
    for (Map.Entry<String, ?> entry : queryParams.entrySet()) {
      String key = entry.getKey();
      Object value = entry.getValue();
      if (value == null) {
        continue;
      }
      if (value instanceof Iterable<?>) {
        for (Object v : (Iterable<?>) value) {
          appendQueryPart(parts, key, v);
        }
      } else if (value.getClass().isArray()) {
        int length = java.lang.reflect.Array.getLength(value);
        for (int i = 0; i < length; i++) {
          appendQueryPart(parts, key, java.lang.reflect.Array.get(value, i));
        }
      } else {
        appendQueryPart(parts, key, value);
      }
    }

    return parts.isEmpty() ? "" : "?" + String.join("&", parts);
  }

  private static void appendQueryPart(List<String> parts, String key, Object value) {
    if (value == null) {
      return;
    }
    String encodedKey = URLEncoder.encode(Objects.toString(key), StandardCharsets.UTF_8);
    String encodedValue = URLEncoder.encode(Objects.toString(value), StandardCharsets.UTF_8);
    parts.add(encodedKey + "=" + encodedValue);
  }
}
