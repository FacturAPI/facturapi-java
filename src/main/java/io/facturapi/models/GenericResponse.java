package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericResponse {
  private boolean ok;

  public boolean isOk() {
    return ok;
  }

  public void setOk(boolean ok) {
    this.ok = ok;
  }
}
