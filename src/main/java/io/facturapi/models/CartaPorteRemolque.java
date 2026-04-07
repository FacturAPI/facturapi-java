package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteRemolque {
  @JsonProperty("SubTipoRem")
  private String subTipoRem;
  @JsonProperty("Placa")
  private String placa;

  public String getSubTipoRem() { return subTipoRem; }
  public void setSubTipoRem(String subTipoRem) { this.subTipoRem = subTipoRem; }
  public String getPlaca() { return placa; }
  public void setPlaca(String placa) { this.placa = placa; }
}
