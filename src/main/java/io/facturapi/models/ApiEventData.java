package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiEventData {
  private String type;
  private Object object;

  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
  public Object getObject() { return object; }
  public void setObject(Object object) { this.object = object; }
}
