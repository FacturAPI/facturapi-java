package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.facturapi.enums.Taxability;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInfo {
  private String id;
  private String productKey;
  private String description;
  private String unitKey;
  private String unitName;
  private Double price;
  private Taxability taxability;
  private Boolean taxIncluded;
  private List<Tax> taxes = new ArrayList<>();
  private List<LocalTax> localTaxes = new ArrayList<>();
  private String sku;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getProductKey() { return productKey; }
  public void setProductKey(String productKey) { this.productKey = productKey; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public String getUnitKey() { return unitKey; }
  public void setUnitKey(String unitKey) { this.unitKey = unitKey; }
  public String getUnitName() { return unitName; }
  public void setUnitName(String unitName) { this.unitName = unitName; }
  public Double getPrice() { return price; }
  public void setPrice(Double price) { this.price = price; }
  public Taxability getTaxability() { return taxability; }
  public void setTaxability(Taxability taxability) { this.taxability = taxability; }
  public Boolean getTaxIncluded() { return taxIncluded; }
  public void setTaxIncluded(Boolean taxIncluded) { this.taxIncluded = taxIncluded; }
  public List<Tax> getTaxes() { return taxes; }
  public void setTaxes(List<Tax> taxes) { this.taxes = taxes; }
  public List<LocalTax> getLocalTaxes() { return localTaxes; }
  public void setLocalTaxes(List<LocalTax> localTaxes) { this.localTaxes = localTaxes; }
  public String getSku() { return sku; }
  public void setSku(String sku) { this.sku = sku; }
}
