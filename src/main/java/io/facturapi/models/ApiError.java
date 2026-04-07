package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiError {
  private String message;
  private Integer status;
  private boolean ok;
  private Object code;
  private String path;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @JsonSetter("status")
  public void setStatus(JsonNode status) {
    if (status == null || status.isNull()) {
      this.status = null;
      return;
    }
    if (status.isIntegralNumber()) {
      this.status = status.intValue();
      return;
    }
    if (status.isNumber()) {
      this.status = (int) Math.round(status.asDouble());
      return;
    }
    if (status.isTextual()) {
      try {
        this.status = Integer.parseInt(status.asText());
      } catch (NumberFormatException ignored) {
        this.status = null;
      }
    }
  }

  public boolean isOk() {
    return ok;
  }

  public void setOk(boolean ok) {
    this.ok = ok;
  }

  public Object getCode() {
    return code;
  }

  @JsonSetter("code")
  public void setCode(JsonNode code) {
    if (code == null || code.isNull()) {
      this.code = null;
    } else if (code.isTextual()) {
      this.code = code.asText();
    } else if (code.isIntegralNumber()) {
      this.code = code.intValue();
    } else if (code.isNumber()) {
      this.code = code.numberValue();
    } else if (code.isBoolean()) {
      this.code = code.asBoolean();
    } else {
      this.code = code.toString();
    }
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
