package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Webhook {
  private String id;
  @JsonProperty("created_at")
  private Instant createdAt;
  private String organization;
  private Boolean livemode;
  @JsonProperty("enabled_events")
  private List<String> enabledEvents = new ArrayList<>();
  private String description;
  private String url;
  private String secret;
  private String status;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
  public String getOrganization() { return organization; }
  public void setOrganization(String organization) { this.organization = organization; }
  public Boolean getLivemode() { return livemode; }
  public void setLivemode(Boolean livemode) { this.livemode = livemode; }
  public List<String> getEnabledEvents() { return enabledEvents; }
  public void setEnabledEvents(List<String> enabledEvents) { this.enabledEvents = enabledEvents; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public String getUrl() { return url; }
  public void setUrl(String url) { this.url = url; }
  public String getSecret() { return secret; }
  public void setSecret(String secret) { this.secret = secret; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
}
