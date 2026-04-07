package io.facturapi.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.facturapi.FacturapiException;
import java.io.IOException;
import java.io.InputStream;
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

  public ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  public <T> T get(String path, Map<String, ?> queryParams, Class<T> responseType) {
    return convert(requestJsonNode("GET", path, queryParams, null, null), responseType);
  }

  public <T> T get(String path, Map<String, ?> queryParams, TypeReference<T> typeReference) {
    return convert(requestJsonNode("GET", path, queryParams, null, null), typeReference);
  }

  public <T> T post(String path, Object body, Map<String, ?> queryParams, Class<T> responseType) {
    return convert(requestJsonNode("POST", path, queryParams, body, null), responseType);
  }

  public <T> T post(String path, Object body, Map<String, ?> queryParams, TypeReference<T> typeReference) {
    return convert(requestJsonNode("POST", path, queryParams, body, null), typeReference);
  }

  public <T> T put(String path, Object body, Map<String, ?> queryParams, Class<T> responseType) {
    return convert(requestJsonNode("PUT", path, queryParams, body, null), responseType);
  }

  public <T> T put(String path, Object body, Map<String, ?> queryParams, TypeReference<T> typeReference) {
    return convert(requestJsonNode("PUT", path, queryParams, body, null), typeReference);
  }

  public <T> T delete(String path, Map<String, ?> queryParams, Class<T> responseType) {
    return convert(requestJsonNode("DELETE", path, queryParams, null, null), responseType);
  }

  public <T> T delete(String path, Map<String, ?> queryParams, TypeReference<T> typeReference) {
    return convert(requestJsonNode("DELETE", path, queryParams, null, null), typeReference);
  }

  public <T> T putMultipart(String path, MultipartBody multipartBody, Class<T> responseType) {
    return convert(requestJsonNode("PUT", path, null, null, multipartBody), responseType);
  }

  public byte[] getBytes(String path) {
    return requestBytes("GET", path, null);
  }

  public byte[] postBytes(String path, Object body) {
    return requestBytes("POST", path, body);
  }

  public InputStream getStream(String path) {
    return requestStream("GET", path, null);
  }

  public InputStream postStream(String path, Object body) {
    return requestStream("POST", path, body);
  }

  private JsonNode requestJsonNode(
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
        return objectMapper.nullNode();
      }

      String contentType = response.headers().firstValue("Content-Type").orElse("");
      if (!contentType.contains("application/json")) {
        return objectMapper.valueToTree(new String(responseBytes, StandardCharsets.UTF_8));
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

  private InputStream requestStream(String method, String path, Object body) {
    try {
      HttpRequest request = buildRequest(method, path, null, body, null);
      HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
      int statusCode = response.statusCode();
      if (statusCode < 200 || statusCode >= 300) {
        byte[] responseBytes;
        try (InputStream errorStream = response.body()) {
          responseBytes = errorStream == null ? new byte[0] : errorStream.readAllBytes();
        }
        String bodyText = responseBytes.length == 0 ? "" : new String(responseBytes, StandardCharsets.UTF_8);
        throw buildApiException(bodyText, statusCode);
      }
      return response.body();
    } catch (IOException e) {
      throw new FacturapiException("I/O error when calling Facturapi API", e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new FacturapiException("Request interrupted", e);
    }
  }

  private <T> T convert(JsonNode node, Class<T> type) {
    if (type == Void.class) {
      return null;
    }
    if (type == String.class) {
      if (node == null || node.isNull()) {
        return type.cast("");
      }
      if (node.isTextual()) {
        return type.cast(node.asText());
      }
      if (node.isObject()) {
        JsonNode value = firstDefined(node, "api_key", "key", "token", "value");
        if (value != null && value.isTextual()) {
          return type.cast(value.asText());
        }
      }
      return type.cast(node.toString());
    }
    try {
      return objectMapper.convertValue(node, type);
    } catch (IllegalArgumentException e) {
      throw new FacturapiException("Could not deserialize response to " + type.getSimpleName(), e);
    }
  }

  private <T> T convert(JsonNode node, TypeReference<T> typeReference) {
    try {
      return objectMapper.convertValue(node, typeReference);
    } catch (IllegalArgumentException e) {
      throw new FacturapiException("Could not deserialize response", e);
    }
  }

  private static JsonNode firstDefined(JsonNode node, String... keys) {
    for (String key : keys) {
      JsonNode value = node.get(key);
      if (value != null && !value.isNull()) {
        return value;
      }
    }
    return null;
  }

  private FacturapiException buildApiException(String bodyText, int statusCode) {
    int resolvedStatus = statusCode;
    Object errorCode = null;
    String errorPath = null;
    String message = "Request failed with status " + statusCode;

    if (bodyText != null && !bodyText.isBlank()) {
      try {
        JsonNode root = objectMapper.readTree(bodyText);
        if (root != null) {
          JsonNode messageNode = firstDefined(root, "message", "error", "detail");
          if (messageNode != null && messageNode.isTextual()) {
            message = messageNode.asText();
          } else if (root.isTextual()) {
            message = root.asText();
          } else {
            message = bodyText;
          }

          JsonNode statusNode = firstDefined(root, "status");
          if (statusNode != null) {
            if (statusNode.isIntegralNumber()) {
              resolvedStatus = statusNode.intValue();
            } else if (statusNode.isNumber()) {
              resolvedStatus = (int) Math.round(statusNode.asDouble());
            } else if (statusNode.isTextual()) {
              try {
                resolvedStatus = Integer.parseInt(statusNode.asText());
              } catch (NumberFormatException ignored) {
                resolvedStatus = statusCode;
              }
            }
          }

          JsonNode codeNode = firstDefined(root, "code");
          if (codeNode != null && !codeNode.isNull()) {
            if (codeNode.isTextual()) {
              errorCode = codeNode.asText();
            } else if (codeNode.isIntegralNumber()) {
              errorCode = codeNode.intValue();
            } else if (codeNode.isNumber()) {
              errorCode = codeNode.numberValue();
            } else if (codeNode.isBoolean()) {
              errorCode = codeNode.asBoolean();
            } else {
              errorCode = codeNode.toString();
            }
          }

          JsonNode pathNode = firstDefined(root, "path");
          if (pathNode != null && pathNode.isTextual()) {
            errorPath = pathNode.asText();
          }

        }
      } catch (Exception ignored) {
        message = bodyText.isBlank() ? message : bodyText;
      }
    }

    return new FacturapiException(message, resolvedStatus, errorCode, errorPath);
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
      throw buildApiException(bodyText, statusCode);
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
