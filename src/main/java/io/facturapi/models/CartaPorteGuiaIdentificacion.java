package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteGuiaIdentificacion {
  @JsonProperty("NumeroGuiaIdentificacion")
  private String numeroGuiaIdentificacion;
  @JsonProperty("DescripGuiaIdentificacion")
  private String descripGuiaIdentificacion;
  @JsonProperty("PesoGuiaIdentificacion")
  private Double pesoGuiaIdentificacion;

  public String getNumeroGuiaIdentificacion() { return numeroGuiaIdentificacion; }
  public void setNumeroGuiaIdentificacion(String numeroGuiaIdentificacion) { this.numeroGuiaIdentificacion = numeroGuiaIdentificacion; }
  public String getDescripGuiaIdentificacion() { return descripGuiaIdentificacion; }
  public void setDescripGuiaIdentificacion(String descripGuiaIdentificacion) { this.descripGuiaIdentificacion = descripGuiaIdentificacion; }
  public Double getPesoGuiaIdentificacion() { return pesoGuiaIdentificacion; }
  public void setPesoGuiaIdentificacion(Double pesoGuiaIdentificacion) { this.pesoGuiaIdentificacion = pesoGuiaIdentificacion; }
}
