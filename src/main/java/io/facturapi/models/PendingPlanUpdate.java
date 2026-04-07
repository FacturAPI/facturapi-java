package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PendingPlanUpdate {
  private String plan;
  @JsonProperty("scheduled_for")
  private String scheduledFor;

  public String getPlan() { return plan; }
  public void setPlan(String plan) { this.plan = plan; }
  public String getScheduledFor() { return scheduledFor; }
  public void setScheduledFor(String scheduledFor) { this.scheduledFor = scheduledFor; }
}
