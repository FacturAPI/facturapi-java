package io.facturapi;

import io.facturapi.models.ApiError;

public class FacturapiException extends RuntimeException {
  private final ApiError apiError;
  private final int statusCode;
  private final String responseBody;

  public FacturapiException(String message) {
    super(message);
    this.apiError = null;
    this.statusCode = -1;
    this.responseBody = null;
  }

  public FacturapiException(String message, Throwable cause) {
    super(message, cause);
    this.apiError = null;
    this.statusCode = -1;
    this.responseBody = null;
  }

  public FacturapiException(String message, int statusCode, String responseBody) {
    super(message);
    this.apiError = null;
    this.statusCode = statusCode;
    this.responseBody = responseBody;
  }

  public FacturapiException(ApiError apiError, String responseBody) {
    super(apiError != null && apiError.getMessage() != null && !apiError.getMessage().isBlank()
      ? apiError.getMessage()
      : "An error occurred");
    this.apiError = apiError;
    this.statusCode = apiError != null && apiError.getStatus() != null ? apiError.getStatus() : -1;
    this.responseBody = responseBody;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getResponseBody() {
    return responseBody;
  }

  public ApiError getApiError() {
    return apiError;
  }

  public ApiError getError() {
    return apiError;
  }
}
