package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalTax {
  private Double base;
  private Double rate;
  private String type;
  private Boolean withholding;
  private String factor;

  public Double getBase() {
    return base;
  }

  public void setBase(Double base) {
    this.base = base;
  }

  public Double getRate() {
    return rate;
  }

  public void setRate(Double rate) {
    this.rate = rate;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getWithholding() {
    return withholding;
  }

  public void setWithholding(Boolean withholding) {
    this.withholding = withholding;
  }

  public String getFactor() {
    return factor;
  }

  public void setFactor(String factor) {
    this.factor = factor;
  }
}
