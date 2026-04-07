package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiEvent {
  @JsonProperty("created_at")
  private String createdAt;
  private String organization;
  private Boolean livemode;
  private String type;
  private ApiEventData data;

  public String getCreatedAt() { return createdAt; }
  public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
  public String getOrganization() { return organization; }
  public void setOrganization(String organization) { this.organization = organization; }
  public Boolean getLivemode() { return livemode; }
  public void setLivemode(Boolean livemode) { this.livemode = livemode; }
  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
  public ApiEventData getData() { return data; }
  public void setData(ApiEventData data) { this.data = data; }
}
