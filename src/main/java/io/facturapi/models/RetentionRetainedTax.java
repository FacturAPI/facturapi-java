package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RetentionRetainedTax {
  private Double baseRet;
  private String impuesto;
  private String tipoPagoRet;
  private Double montoRet;
  private Boolean pagoProvisional;

  public Double getBaseRet() { return baseRet; }
  public void setBaseRet(Double baseRet) { this.baseRet = baseRet; }
  public String getImpuesto() { return impuesto; }
  public void setImpuesto(String impuesto) { this.impuesto = impuesto; }
  public String getTipoPagoRet() { return tipoPagoRet; }
  public void setTipoPagoRet(String tipoPagoRet) { this.tipoPagoRet = tipoPagoRet; }
  public Double getMontoRet() { return montoRet; }
  public void setMontoRet(Double montoRet) { this.montoRet = montoRet; }
  public Boolean getPagoProvisional() { return pagoProvisional; }
  public void setPagoProvisional(Boolean pagoProvisional) { this.pagoProvisional = pagoProvisional; }
}
