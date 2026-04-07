package io.facturapi.models.complements.pago;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.facturapi.enums.TaxFactor;
import io.facturapi.enums.TaxType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRelatedDocumentTax {
  private Double base;
  private Double rate;
  private TaxType type;
  private TaxFactor factor;
  private Boolean withholding;

  public Double getBase() { return base; }
  public void setBase(Double base) { this.base = base; }
  public Double getRate() { return rate; }
  public void setRate(Double rate) { this.rate = rate; }
  public TaxType getType() { return type; }
  public void setType(TaxType type) { this.type = type; }
  public TaxFactor getFactor() { return factor; }
  public void setFactor(TaxFactor factor) { this.factor = factor; }
  public Boolean getWithholding() { return withholding; }
  public void setWithholding(Boolean withholding) { this.withholding = withholding; }
}
