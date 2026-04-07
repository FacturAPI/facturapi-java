package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stamp {
  private String date;
  @JsonProperty("sat_signature")
  private String satSignature;
  @JsonProperty("sat_cert_number")
  private String satCertNumber;
  private String signature;
  @JsonProperty("complement_string")
  private String complementString;
  @JsonProperty("rfc_provider_cert")
  private String rfcProviderCert;

  public String getDate() { return date; }
  public void setDate(String date) { this.date = date; }
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
