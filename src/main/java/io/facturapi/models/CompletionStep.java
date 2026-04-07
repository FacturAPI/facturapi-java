package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompletionStep {
  private String type;
  private String description;

  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
}
