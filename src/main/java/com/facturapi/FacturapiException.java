package com.facturapi;

public class FacturapiException extends RuntimeException {
  private final int statusCode;
  private final String responseBody;

  public FacturapiException(String message) {
    super(message);
    this.statusCode = -1;
    this.responseBody = null;
  }

  public FacturapiException(String message, Throwable cause) {
    super(message, cause);
    this.statusCode = -1;
    this.responseBody = null;
  }

  public FacturapiException(String message, int statusCode, String responseBody) {
    super(message);
    this.statusCode = statusCode;
    this.responseBody = responseBody;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getResponseBody() {
    return responseBody;
  }
}
