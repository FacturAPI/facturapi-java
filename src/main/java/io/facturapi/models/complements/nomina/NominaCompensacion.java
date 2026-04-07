package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaCompensacion {
  private Double saldoAFavor;
  private Integer ano;
  private Double remanenteSalFav;

  public Double getSaldoAFavor() { return saldoAFavor; }
  public void setSaldoAFavor(Double saldoAFavor) { this.saldoAFavor = saldoAFavor; }
  public Integer getAno() { return ano; }
  public void setAno(Integer ano) { this.ano = ano; }
  public Double getRemanenteSalFav() { return remanenteSalFav; }
  public void setRemanenteSalFav(Double remanenteSalFav) { this.remanenteSalFav = remanenteSalFav; }
}
