package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxInfoValidationError {
  private String path;
  private String message;

  public String getPath() { return path; }
  public void setPath(String path) { this.path = path; }
  public String getMessage() { return message; }
  public void setMessage(String message) { this.message = message; }
}
