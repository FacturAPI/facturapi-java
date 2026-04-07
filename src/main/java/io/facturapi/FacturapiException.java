package io.facturapi;

public class FacturapiException extends RuntimeException {
  private final int statusCode;
  private final Object errorCode;
  private final String errorPath;

  public FacturapiException(String message) {
    this(message, -1, null, null);
  }

  public FacturapiException(String message, Throwable cause) {
    super(message, cause);
    this.statusCode = -1;
    this.errorCode = null;
    this.errorPath = null;
  }

  public FacturapiException(String message, int statusCode, Object errorCode, String errorPath) {
    super(message);
    this.statusCode = statusCode;
    this.errorCode = errorCode;
    this.errorPath = errorPath;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public Object getErrorCode() {
    return errorCode;
  }

  public String getErrorPath() {
    return errorPath;
  }
}
