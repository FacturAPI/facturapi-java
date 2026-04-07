package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.facturapi.enums.CancellationMotive;
import io.facturapi.enums.CancellationStatus;
import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceCancellation {
  private Instant requestedAt;
  private CancellationStatus status;
  private Instant lastChecked;
  private CancellationMotive motive;
  private String substitutionUuid;

  public Instant getRequestedAt() { return requestedAt; }
  public void setRequestedAt(Instant requestedAt) { this.requestedAt = requestedAt; }
  public CancellationStatus getStatus() { return status; }
  public void setStatus(CancellationStatus status) { this.status = status; }
  public Instant getLastChecked() { return lastChecked; }
  public void setLastChecked(Instant lastChecked) { this.lastChecked = lastChecked; }
  public CancellationMotive getMotive() { return motive; }
  public void setMotive(CancellationMotive motive) { this.motive = motive; }
  public String getSubstitutionUuid() { return substitutionUuid; }
  public void setSubstitutionUuid(String substitutionUuid) { this.substitutionUuid = substitutionUuid; }
}
