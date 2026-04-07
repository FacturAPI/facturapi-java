package io.facturapi.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.facturapi.FacturapiException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class FacturapiHttpClient {
  private static final MediaType JSON_MEDIA_TYPE = MediaType.get("application/json; charset=utf-8");

  private final OkHttpClient httpClient;
  private final ObjectMapper objectMapper;
  private final String baseUrl;
  private final String apiKey;
  private final String userAgent;

  public FacturapiHttpClient(FacturapiConfig config) {
    this.httpClient = config.getHttpClient();
    this.objectMapper = config.getObjectMapper();
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
    Request request = buildRequest(method, path, queryParams, body, multipartBody);
    try (Response response = httpClient.newCall(request).execute()) {
      if (!response.isSuccessful()) {
        throw buildApiException(readBodyText(response), response.code());
      }

      ResponseBody responseBody = response.body();
      if (responseBody == null) {
        return objectMapper.nullNode();
      }

      byte[] responseBytes = responseBody.bytes();
      if (responseBytes.length == 0) {
        return objectMapper.nullNode();
      }

      String contentType = responseBody.contentType() == null ? "" : responseBody.contentType().toString();
      if (!contentType.contains("application/json")) {
        return objectMapper.valueToTree(new String(responseBytes, StandardCharsets.UTF_8));
      }
      return objectMapper.readTree(responseBytes);
    } catch (IOException e) {
      throw new FacturapiException("I/O error when calling Facturapi API", e);
    }
  }

  private byte[] requestBytes(String method, String path, Object body) {
    Request request = buildRequest(method, path, null, body, null);
    try (Response response = httpClient.newCall(request).execute()) {
      if (!response.isSuccessful()) {
        throw buildApiException(readBodyText(response), response.code());
      }
      ResponseBody responseBody = response.body();
      return responseBody == null ? new byte[0] : responseBody.bytes();
    } catch (IOException e) {
      throw new FacturapiException("I/O error when calling Facturapi API", e);
    }
  }

  private InputStream requestStream(String method, String path, Object body) {
    Request request = buildRequest(method, path, null, body, null);
    try {
      Response response = httpClient.newCall(request).execute();
      if (!response.isSuccessful()) {
        try {
          throw buildApiException(readBodyText(response), response.code());
        } finally {
          response.close();
        }
      }

      ResponseBody responseBody = response.body();
      if (responseBody == null) {
        response.close();
        return new ByteArrayInputStream(new byte[0]);
      }
      return new ResponseInputStream(response, responseBody);
    } catch (IOException e) {
      throw new FacturapiException("I/O error when calling Facturapi API", e);
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

          if (firstDefined(root, "message", "error", "detail") == null) {
            message = bodyText;
          }
        }
      } catch (Exception ignored) {
        message = bodyText.isBlank() ? message : bodyText;
      }
    }

    return new FacturapiException(message, resolvedStatus, errorCode, errorPath);
  }

  private static String readBodyText(Response response) throws IOException {
    ResponseBody responseBody = response.body();
    if (responseBody == null) {
      return "";
    }
    return responseBody.string();
  }

  private Request buildRequest(
    String method,
    String path,
    Map<String, ?> queryParams,
    Object body,
    MultipartBody multipartBody
  ) {
    String url = baseUrl + normalizePath(path) + buildQuery(queryParams);
    Request.Builder builder = new Request.Builder()
      .url(url)
      .header("Authorization", "Bearer " + apiKey)
      .header("Accept", "application/json")
      .header("User-Agent", userAgent);

    RequestBody requestBody = null;
    if (multipartBody != null) {
      requestBody = multipartBody.getBody();
    } else if (body != null) {
      try {
        byte[] json = objectMapper.writeValueAsBytes(body);
        requestBody = RequestBody.create(json, JSON_MEDIA_TYPE);
      } catch (IOException e) {
        throw new UncheckedIOException("Could not serialize request body", e);
      }
    }

    if (requestBody == null) {
      if ("GET".equals(method) || "HEAD".equals(method)) {
        builder.method(method, null);
      } else {
        builder.method(method, RequestBody.create(new byte[0], null));
      }
    } else {
      builder.method(method, requestBody);
    }
    return builder.build();
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

  private static final class ResponseInputStream extends InputStream {
    private final Response response;
    private final ResponseBody responseBody;
    private final InputStream delegate;

    private ResponseInputStream(Response response, ResponseBody responseBody) {
      this.response = response;
      this.responseBody = responseBody;
      this.delegate = responseBody.byteStream();
    }

    @Override
    public int read() throws IOException {
      return delegate.read();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
      return delegate.read(b, off, len);
    }

    @Override
    public void close() throws IOException {
      try {
        delegate.close();
      } finally {
        responseBody.close();
        response.close();
      }
    }
  }
}
