package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceCancellation {
  @JsonProperty("requested_at")
  private Instant requestedAt;
  private String status;
  @JsonProperty("last_checked")
  private Instant lastChecked;
  private String motive;
  @JsonProperty("substitution_uuid")
  private String substitutionUuid;

  public Instant getRequestedAt() { return requestedAt; }
  public void setRequestedAt(Instant requestedAt) { this.requestedAt = requestedAt; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  public Instant getLastChecked() { return lastChecked; }
  public void setLastChecked(Instant lastChecked) { this.lastChecked = lastChecked; }
  public String getMotive() { return motive; }
  public void setMotive(String motive) { this.motive = motive; }
  public String getSubstitutionUuid() { return substitutionUuid; }
  public void setSubstitutionUuid(String substitutionUuid) { this.substitutionUuid = substitutionUuid; }
}
