package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaHorasExtra {
  private Integer dias;
  @JsonProperty("tipo_horas")
  private String tipoHoras;
  @JsonProperty("horas_extra")
  private Integer horasExtra;
  @JsonProperty("importe_pagado")
  private Double importePagado;

  public Integer getDias() { return dias; }
  public void setDias(Integer dias) { this.dias = dias; }
  public String getTipoHoras() { return tipoHoras; }
  public void setTipoHoras(String tipoHoras) { this.tipoHoras = tipoHoras; }
  public Integer getHorasExtra() { return horasExtra; }
  public void setHorasExtra(Integer horasExtra) { this.horasExtra = horasExtra; }
  public Double getImportePagado() { return importePagado; }
  public void setImportePagado(Double importePagado) { this.importePagado = importePagado; }
}
