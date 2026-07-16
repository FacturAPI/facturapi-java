package io.facturapi;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FacturapiException extends RuntimeException {
  private final int statusCode;
  private final String errorCode;
  private final String errorPath;
  private final String errorLocation;
  private final JsonNode errors;
  private final String logId;
  private final Map<String, List<String>> headers;

  public FacturapiException(String message) {
    this(message, -1, null, null, null, null, null, Collections.emptyMap());
  }

  public FacturapiException(String message, Throwable cause) {
    super(message, cause);
    this.statusCode = -1;
    this.errorCode = null;
    this.errorPath = null;
    this.errorLocation = null;
    this.errors = null;
    this.logId = null;
    this.headers = Collections.emptyMap();
  }

  public FacturapiException(String message, int statusCode, String errorCode, String errorPath) {
    this(message, statusCode, errorCode, errorPath, null, null, null, Collections.emptyMap());
  }

  public FacturapiException(
    String message,
    int statusCode,
    String errorCode,
    String errorPath,
    String errorLocation,
    JsonNode errors,
    String logId,
    Map<String, List<String>> headers
  ) {
    super(message);
    this.statusCode = statusCode;
    this.errorCode = errorCode;
    this.errorPath = errorPath;
    this.errorLocation = errorLocation;
    this.errors = errors;
    this.logId = logId;
    this.headers = headers == null ? Collections.emptyMap() : headers;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getErrorPath() {
    return errorPath;
  }

  public String getErrorLocation() {
    return errorLocation;
  }

  public JsonNode getErrors() {
    return errors;
  }

  public String getLogId() {
    return logId;
  }

  public Map<String, List<String>> getHeaders() {
    return headers;
  }
}
