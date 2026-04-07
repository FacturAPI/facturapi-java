package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
  private String id;
  private String organization;
  private Boolean livemode;
  @JsonProperty("created_at")
  private String createdAt;
  @JsonProperty("tax_id")
  private String taxId;
  @JsonProperty("tax_system")
  private String taxSystem;
  @JsonProperty("legal_name")
  private String legalName;
  private String email;
  private String phone;
  private String curp;
  private Address address;
  @JsonProperty("external_id")
  private String externalId;
  @JsonProperty("default_invoice_use")
  private String defaultInvoiceUse;
  @JsonProperty("sat_validated_at")
  private String satValidatedAt;
  @JsonProperty("edit_link")
  private String editLink;
  @JsonProperty("edit_link_expires_at")
  private String editLinkExpiresAt;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getOrganization() { return organization; }
  public void setOrganization(String organization) { this.organization = organization; }
  public Boolean getLivemode() { return livemode; }
  public void setLivemode(Boolean livemode) { this.livemode = livemode; }
  public String getCreatedAt() { return createdAt; }
  public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
  public String getTaxId() { return taxId; }
  public void setTaxId(String taxId) { this.taxId = taxId; }
  public String getTaxSystem() { return taxSystem; }
  public void setTaxSystem(String taxSystem) { this.taxSystem = taxSystem; }
  public String getLegalName() { return legalName; }
  public void setLegalName(String legalName) { this.legalName = legalName; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getPhone() { return phone; }
  public void setPhone(String phone) { this.phone = phone; }
  public String getCurp() { return curp; }
  public void setCurp(String curp) { this.curp = curp; }
  public Address getAddress() { return address; }
  public void setAddress(Address address) { this.address = address; }
  public String getExternalId() { return externalId; }
  public void setExternalId(String externalId) { this.externalId = externalId; }
  public String getDefaultInvoiceUse() { return defaultInvoiceUse; }
  public void setDefaultInvoiceUse(String defaultInvoiceUse) { this.defaultInvoiceUse = defaultInvoiceUse; }
  public String getSatValidatedAt() { return satValidatedAt; }
  public void setSatValidatedAt(String satValidatedAt) { this.satValidatedAt = satValidatedAt; }
  public String getEditLink() { return editLink; }
  public void setEditLink(String editLink) { this.editLink = editLink; }
  public String getEditLinkExpiresAt() { return editLinkExpiresAt; }
  public void setEditLinkExpiresAt(String editLinkExpiresAt) { this.editLinkExpiresAt = editLinkExpiresAt; }
}
