package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceItemThirdParty {
  @JsonProperty("tax_id")
  private String taxId;
  @JsonProperty("legal_name")
  private String legalName;
  @JsonProperty("tax_system")
  private String taxSystem;
  private String zip;

  public String getTaxId() { return taxId; }
  public void setTaxId(String taxId) { this.taxId = taxId; }
  public String getLegalName() { return legalName; }
  public void setLegalName(String legalName) { this.legalName = legalName; }
  public String getTaxSystem() { return taxSystem; }
  public void setTaxSystem(String taxSystem) { this.taxSystem = taxSystem; }
  public String getZip() { return zip; }
  public void setZip(String zip) { this.zip = zip; }
}
