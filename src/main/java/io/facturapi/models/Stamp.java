package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stamp {
  private Instant date;
  private String satSignature;
  private String satCertNumber;
  private String signature;
  private String complementString;
  private String rfcProviderCert;

  public Instant getDate() { return date; }
  public void setDate(Instant date) { this.date = date; }
  public String getSatSignature() { return satSignature; }
  public void setSatSignature(String satSignature) { this.satSignature = satSignature; }
  public String getSatCertNumber() { return satCertNumber; }
  public void setSatCertNumber(String satCertNumber) { this.satCertNumber = satCertNumber; }
  public String getSignature() { return signature; }
  public void setSignature(String signature) { this.signature = signature; }
  public String getComplementString() { return complementString; }
  public void setComplementString(String complementString) { this.complementString = complementString; }
  public String getRfcProviderCert() { return rfcProviderCert; }
  public void setRfcProviderCert(String rfcProviderCert) { this.rfcProviderCert = rfcProviderCert; }
}
