package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiKey {
  private String id;
  @JsonProperty("first_12")
  private String first12;
  @JsonProperty("created_at")
  private String createdAt;
  @JsonAlias({"key", "api_key", "token"})
  private String key;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getFirst12() { return first12; }
  public void setFirst12(String first12) { this.first12 = first12; }
  public String getCreatedAt() { return createdAt; }
  public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
  public String getKey() { return key; }
  public void setKey(String key) { this.key = key; }
}
