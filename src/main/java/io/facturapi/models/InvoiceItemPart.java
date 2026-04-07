package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceItemPart {
  private Double quantity;
  private String productKey;
  private String description;
  private String unitName;
  private String sku;
  private Double unitPrice;

  public Double getQuantity() { return quantity; }
  public void setQuantity(Double quantity) { this.quantity = quantity; }
  public String getProductKey() { return productKey; }
  public void setProductKey(String productKey) { this.productKey = productKey; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public String getUnitName() { return unitName; }
  public void setUnitName(String unitName) { this.unitName = unitName; }
  public String getSku() { return sku; }
  public void setSku(String sku) { this.sku = sku; }
  public Double getUnitPrice() { return unitPrice; }
  public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }
}
