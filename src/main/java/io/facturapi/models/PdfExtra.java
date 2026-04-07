package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PdfExtra {
  private Boolean codes;
  private Boolean addressCodes;
  private Boolean productKey;
  private Boolean roundUnitPrice;
  private Boolean taxBreakdown;
  private Boolean iepsBreakdown;
  private Boolean renderCartaPorte;
  private Boolean repeatSignature;

  public Boolean getCodes() { return codes; }
  public void setCodes(Boolean codes) { this.codes = codes; }
  public Boolean getAddressCodes() { return addressCodes; }
  public void setAddressCodes(Boolean addressCodes) { this.addressCodes = addressCodes; }
  public Boolean getProductKey() { return productKey; }
  public void setProductKey(Boolean productKey) { this.productKey = productKey; }
  public Boolean getRoundUnitPrice() { return roundUnitPrice; }
  public void setRoundUnitPrice(Boolean roundUnitPrice) { this.roundUnitPrice = roundUnitPrice; }
  public Boolean getTaxBreakdown() { return taxBreakdown; }
  public void setTaxBreakdown(Boolean taxBreakdown) { this.taxBreakdown = taxBreakdown; }
  public Boolean getIepsBreakdown() { return iepsBreakdown; }
  public void setIepsBreakdown(Boolean iepsBreakdown) { this.iepsBreakdown = iepsBreakdown; }
  public Boolean getRenderCartaPorte() { return renderCartaPorte; }
  public void setRenderCartaPorte(Boolean renderCartaPorte) { this.renderCartaPorte = renderCartaPorte; }
  public Boolean getRepeatSignature() { return repeatSignature; }
  public void setRepeatSignature(Boolean repeatSignature) { this.repeatSignature = repeatSignature; }
}
