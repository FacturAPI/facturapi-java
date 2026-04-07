package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceItem {
  private Double quantity;
  private ProductInfo product;
  private Double discount;
  private List<String> customsKeys = new ArrayList<>();
  private InvoiceItemThirdParty thirdParty;
  private String complement;
  private List<InvoiceItemPart> parts = new ArrayList<>();
  private String propertyTaxAccount;

  public Double getQuantity() { return quantity; }
  public void setQuantity(Double quantity) { this.quantity = quantity; }
  public ProductInfo getProduct() { return product; }
  public void setProduct(ProductInfo product) { this.product = product; }
  public Double getDiscount() { return discount; }
  public void setDiscount(Double discount) { this.discount = discount; }
  public List<String> getCustomsKeys() { return customsKeys; }
  public void setCustomsKeys(List<String> customsKeys) { this.customsKeys = customsKeys; }
  public InvoiceItemThirdParty getThirdParty() { return thirdParty; }
  public void setThirdParty(InvoiceItemThirdParty thirdParty) { this.thirdParty = thirdParty; }
  public String getComplement() { return complement; }
  public void setComplement(String complement) { this.complement = complement; }
  public List<InvoiceItemPart> getParts() { return parts; }
  public void setParts(List<InvoiceItemPart> parts) { this.parts = parts; }
  public String getPropertyTaxAccount() { return propertyTaxAccount; }
  public void setPropertyTaxAccount(String propertyTaxAccount) { this.propertyTaxAccount = propertyTaxAccount; }
}
