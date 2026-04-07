package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Legal {
  private String name;
  private String legalName;
  private String taxId;
  private String taxSystem;
  private Address address;
  private String phone;
  private String website;
  private String supportEmail;
  private String curp;

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getLegalName() { return legalName; }
  public void setLegalName(String legalName) { this.legalName = legalName; }
  public String getTaxId() { return taxId; }
  public void setTaxId(String taxId) { this.taxId = taxId; }
  public String getTaxSystem() { return taxSystem; }
  public void setTaxSystem(String taxSystem) { this.taxSystem = taxSystem; }
  public Address getAddress() { return address; }
  public void setAddress(Address address) { this.address = address; }
  public String getPhone() { return phone; }
  public void setPhone(String phone) { this.phone = phone; }
  public String getWebsite() { return website; }
  public void setWebsite(String website) { this.website = website; }
  public String getSupportEmail() { return supportEmail; }
  public void setSupportEmail(String supportEmail) { this.supportEmail = supportEmail; }
  public String getCurp() { return curp; }
  public void setCurp(String curp) { this.curp = curp; }
}
