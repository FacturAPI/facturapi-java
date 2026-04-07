package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaSeparacion {
  @JsonProperty("total_pagado")
  private Double totalPagado;
  @JsonProperty("num_anos_servicio")
  private Integer numAnosServicio;
  @JsonProperty("ultimo_sueldo_mens_ord")
  private Double ultimoSueldoMensOrd;
  @JsonProperty("ingreso_acumulable")
  private Double ingresoAcumulable;
  @JsonProperty("ingreso_no_acumulable")
  private Double ingresoNoAcumulable;

  public Double getTotalPagado() { return totalPagado; }
  public void setTotalPagado(Double totalPagado) { this.totalPagado = totalPagado; }
  public Integer getNumAnosServicio() { return numAnosServicio; }
  public void setNumAnosServicio(Integer numAnosServicio) { this.numAnosServicio = numAnosServicio; }
  public Double getUltimoSueldoMensOrd() { return ultimoSueldoMensOrd; }
  public void setUltimoSueldoMensOrd(Double ultimoSueldoMensOrd) { this.ultimoSueldoMensOrd = ultimoSueldoMensOrd; }
  public Double getIngresoAcumulable() { return ingresoAcumulable; }
  public void setIngresoAcumulable(Double ingresoAcumulable) { this.ingresoAcumulable = ingresoAcumulable; }
  public Double getIngresoNoAcumulable() { return ingresoNoAcumulable; }
  public void setIngresoNoAcumulable(Double ingresoNoAcumulable) { this.ingresoNoAcumulable = ingresoNoAcumulable; }
}
