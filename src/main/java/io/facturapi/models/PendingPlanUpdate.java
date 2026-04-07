package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PendingPlanUpdate {
  private String plan;
  @JsonProperty("scheduled_for")
  private Instant scheduledFor;

  public String getPlan() { return plan; }
  public void setPlan(String plan) { this.plan = plan; }
  public Instant getScheduledFor() { return scheduledFor; }
  public void setScheduledFor(Instant scheduledFor) { this.scheduledFor = scheduledFor; }
}
