package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfo {
  private String id;
  private String legalName;
  private String taxId;
  private String taxSystem;
  private Address address;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getLegalName() { return legalName; }
  public void setLegalName(String legalName) { this.legalName = legalName; }
  public String getTaxId() { return taxId; }
  public void setTaxId(String taxId) { this.taxId = taxId; }
  public String getTaxSystem() { return taxSystem; }
  public void setTaxSystem(String taxSystem) { this.taxSystem = taxSystem; }
  public Address getAddress() { return address; }
  public void setAddress(Address address) { this.address = address; }
}
