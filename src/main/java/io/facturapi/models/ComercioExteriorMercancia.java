package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComercioExteriorMercancia {
  @JsonProperty("DescripcionesEspecificas")
  private List<ComercioExteriorDescripcionesEspecificas> descripcionesEspecificas = new ArrayList<>();
  @JsonProperty("NoIdentificacion")
  private String noIdentificacion;
  @JsonProperty("FraccionArancelaria")
  private String fraccionArancelaria;
  @JsonProperty("CantidadAduana")
  private Double cantidadAduana;
  @JsonProperty("UnidadAduana")
  private String unidadAduana;
  @JsonProperty("ValorUnitarioAduana")
  private Double valorUnitarioAduana;
  @JsonProperty("ValorDolares")
  private Double valorDolares;

  public List<ComercioExteriorDescripcionesEspecificas> getDescripcionesEspecificas() { return descripcionesEspecificas; }
  public void setDescripcionesEspecificas(List<ComercioExteriorDescripcionesEspecificas> descripcionesEspecificas) { this.descripcionesEspecificas = descripcionesEspecificas; }
  public String getNoIdentificacion() { return noIdentificacion; }
  public void setNoIdentificacion(String noIdentificacion) { this.noIdentificacion = noIdentificacion; }
  public String getFraccionArancelaria() { return fraccionArancelaria; }
  public void setFraccionArancelaria(String fraccionArancelaria) { this.fraccionArancelaria = fraccionArancelaria; }
  public Double getCantidadAduana() { return cantidadAduana; }
  public void setCantidadAduana(Double cantidadAduana) { this.cantidadAduana = cantidadAduana; }
  public String getUnidadAduana() { return unidadAduana; }
  public void setUnidadAduana(String unidadAduana) { this.unidadAduana = unidadAduana; }
  public Double getValorUnitarioAduana() { return valorUnitarioAduana; }
  public void setValorUnitarioAduana(Double valorUnitarioAduana) { this.valorUnitarioAduana = valorUnitarioAduana; }
  public Double getValorDolares() { return valorDolares; }
  public void setValorDolares(Double valorDolares) { this.valorDolares = valorDolares; }
}
