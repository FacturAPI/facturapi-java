package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.facturapi.enums.Taxability;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
  private String id;
  private String organization;
  private Boolean livemode;
  @JsonProperty("product_key")
  private String productKey;
  private String description;
  private Double price;
  @JsonProperty("created_at")
  private Instant createdAt;
  @JsonProperty("tax_included")
  private Boolean taxIncluded;
  private List<Tax> taxes = new ArrayList<>();
  @JsonProperty("local_taxes")
  private List<LocalTax> localTaxes = new ArrayList<>();
  @JsonProperty("unit_key")
  private String unitKey;
  @JsonProperty("unit_name")
  private String unitName;
  private String sku;
  private Taxability taxability;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getOrganization() { return organization; }
  public void setOrganization(String organization) { this.organization = organization; }
  public Boolean getLivemode() { return livemode; }
  public void setLivemode(Boolean livemode) { this.livemode = livemode; }
  public String getProductKey() { return productKey; }
  public void setProductKey(String productKey) { this.productKey = productKey; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public Double getPrice() { return price; }
  public void setPrice(Double price) { this.price = price; }
  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
  public Boolean getTaxIncluded() { return taxIncluded; }
  public void setTaxIncluded(Boolean taxIncluded) { this.taxIncluded = taxIncluded; }
  public List<Tax> getTaxes() { return taxes; }
  public void setTaxes(List<Tax> taxes) { this.taxes = taxes; }
  public List<LocalTax> getLocalTaxes() { return localTaxes; }
  public void setLocalTaxes(List<LocalTax> localTaxes) { this.localTaxes = localTaxes; }
  public String getUnitKey() { return unitKey; }
  public void setUnitKey(String unitKey) { this.unitKey = unitKey; }
  public String getUnitName() { return unitName; }
  public void setUnitName(String unitName) { this.unitName = unitName; }
  public String getSku() { return sku; }
  public void setSku(String sku) { this.sku = sku; }
  public Taxability getTaxability() { return taxability; }
  public void setTaxability(Taxability taxability) { this.taxability = taxability; }
}
