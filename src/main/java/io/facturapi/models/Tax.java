package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.facturapi.enums.TaxFactor;
import io.facturapi.enums.TaxType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tax {
  private Double base;
  private Double amount;
  private Double rate;
  private TaxType type;
  private Boolean withholding;
  private TaxFactor factor;

  public Double getBase() {
    return base;
  }

  public void setBase(Double base) {
    this.base = base;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getRate() {
    return rate;
  }

  public void setRate(Double rate) {
    this.rate = rate;
  }

  public TaxType getType() {
    return type;
  }

  public void setType(TaxType type) {
    this.type = type;
  }

  public Boolean getWithholding() {
    return withholding;
  }

  public void setWithholding(Boolean withholding) {
    this.withholding = withholding;
  }

  public TaxFactor getFactor() {
    return factor;
  }

  public void setFactor(TaxFactor factor) {
    this.factor = factor;
  }
}
