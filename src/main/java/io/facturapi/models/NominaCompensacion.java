package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaCompensacion {
  @JsonProperty("saldo_a_favor")
  private Double saldoAFavor;
  private Integer ano;
  @JsonProperty("remanente_sal_fav")
  private Double remanenteSalFav;

  public Double getSaldoAFavor() { return saldoAFavor; }
  public void setSaldoAFavor(Double saldoAFavor) { this.saldoAFavor = saldoAFavor; }
  public Integer getAno() { return ano; }
  public void setAno(Integer ano) { this.ano = ano; }
  public Double getRemanenteSalFav() { return remanenteSalFav; }
  public void setRemanenteSalFav(Double remanenteSalFav) { this.remanenteSalFav = remanenteSalFav; }
}
