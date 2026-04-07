package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Certificate {
  @JsonProperty("has_certificate")
  private Boolean hasCertificate;
  @JsonProperty("updated_at")
  private String updatedAt;
  @JsonProperty("expires_at")
  private String expiresAt;
  @JsonProperty("serial_number")
  private String serialNumber;

  public Boolean getHasCertificate() { return hasCertificate; }
  public void setHasCertificate(Boolean hasCertificate) { this.hasCertificate = hasCertificate; }
  public String getUpdatedAt() { return updatedAt; }
  public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
  public String getExpiresAt() { return expiresAt; }
  public void setExpiresAt(String expiresAt) { this.expiresAt = expiresAt; }
  public String getSerialNumber() { return serialNumber; }
  public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
}
