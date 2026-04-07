package io.facturapi.models;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiEvent {
  @JsonProperty("created_at")
  private Instant createdAt;
  private String organization;
  private Boolean livemode;
  private String type;
  private ApiEventData data;

  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
  public String getOrganization() { return organization; }
  public void setOrganization(String organization) { this.organization = organization; }
  public Boolean getLivemode() { return livemode; }
  public void setLivemode(Boolean livemode) { this.livemode = livemode; }
  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
  public ApiEventData getData() { return data; }
  public void setData(ApiEventData data) { this.data = data; }
}
