package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaSeparacion {
  private Double totalPagado;
  private Integer numAnosServicio;
  private Double ultimoSueldoMensOrd;
  private Double ingresoAcumulable;
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
