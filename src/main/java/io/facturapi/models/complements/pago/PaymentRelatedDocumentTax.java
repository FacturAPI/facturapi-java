package io.facturapi.models.complements.pago;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRelatedDocumentTax {
  private Double base;
  private Double rate;
  private String type;
  private String factor;
  private Boolean withholding;

  public Double getBase() { return base; }
  public void setBase(Double base) { this.base = base; }
  public Double getRate() { return rate; }
  public void setRate(Double rate) { this.rate = rate; }
  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
  public String getFactor() { return factor; }
  public void setFactor(String factor) { this.factor = factor; }
  public Boolean getWithholding() { return withholding; }
  public void setWithholding(Boolean withholding) { this.withholding = withholding; }
}
