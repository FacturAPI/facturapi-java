package io.facturapi.http;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.facturapi.ApiVersion;
import io.facturapi.constants.FacturapiConstants;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.Objects;

public final class FacturapiConfig {
  private final String apiKey;
  private final ApiVersion apiVersion;
  private final String baseUrl;
  private final Duration timeout;
  private final String userAgent;
  private final HttpClient httpClient;
  private final ObjectMapper objectMapper;

  private FacturapiConfig(Builder builder) {
    this.apiKey = builder.apiKey;
    this.apiVersion = builder.apiVersion;
    this.baseUrl = builder.baseUrl;
    this.timeout = builder.timeout;
    this.userAgent = builder.userAgent;
    this.httpClient = builder.httpClient;
    this.objectMapper = builder.objectMapper;
  }

  public String getApiKey() {
    return apiKey;
  }

  public ApiVersion getApiVersion() {
    return apiVersion;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public Duration getTimeout() {
    return timeout;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public HttpClient getHttpClient() {
    return httpClient;
  }

  public ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  public static Builder builder(String apiKey) {
    return new Builder(apiKey);
  }

  public static final class Builder {
    private final String apiKey;
    private ApiVersion apiVersion = ApiVersion.V2;
    private String baseUrl;
    private Duration timeout = Duration.ofSeconds(30);
    private final String userAgent = "facturapi-java/0.1.x";
    private HttpClient httpClient;
    private ObjectMapper objectMapper;

    private Builder(String apiKey) {
      this.apiKey = Objects.requireNonNull(apiKey, "apiKey is required");
      if (apiKey.trim().isEmpty()) {
        throw new IllegalArgumentException("apiKey is required");
      }
    }

    public Builder apiVersion(ApiVersion apiVersion) {
      this.apiVersion = Objects.requireNonNull(apiVersion, "apiVersion is required");
      return this;
    }

    public Builder apiVersion(String apiVersion) {
      this.apiVersion = ApiVersion.fromString(apiVersion);
      return this;
    }

    public Builder timeout(Duration timeout) {
      this.timeout = Objects.requireNonNull(timeout, "timeout is required");
      return this;
    }

    public Builder httpClient(HttpClient httpClient) {
      this.httpClient = Objects.requireNonNull(httpClient, "httpClient is required");
      return this;
    }

    public FacturapiConfig build() {
      String resolvedBaseUrl = apiVersion == ApiVersion.V1
        ? FacturapiConstants.BASE_URL_V1
        : FacturapiConstants.BASE_URL_V2;

      HttpClient resolvedClient = this.httpClient == null
        ? HttpClient.newBuilder().connectTimeout(timeout).build()
        : this.httpClient;

      ObjectMapper resolvedMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

      this.baseUrl = resolvedBaseUrl;
      this.httpClient = resolvedClient;
      this.objectMapper = resolvedMapper;
      return new FacturapiConfig(this);
    }
  }
}
