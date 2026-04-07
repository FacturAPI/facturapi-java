package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteContenedorFerroviario {
  @JsonProperty("TipoContenedor")
  private String tipoContenedor;
  @JsonProperty("PesoContenedorVacio")
  private Double pesoContenedorVacio;
  @JsonProperty("PesoNetoMercancia")
  private Double pesoNetoMercancia;

  public String getTipoContenedor() { return tipoContenedor; }
  public void setTipoContenedor(String tipoContenedor) { this.tipoContenedor = tipoContenedor; }
  public Double getPesoContenedorVacio() { return pesoContenedorVacio; }
  public void setPesoContenedorVacio(Double pesoContenedorVacio) { this.pesoContenedorVacio = pesoContenedorVacio; }
  public Double getPesoNetoMercancia() { return pesoNetoMercancia; }
  public void setPesoNetoMercancia(Double pesoNetoMercancia) { this.pesoNetoMercancia = pesoNetoMercancia; }
}
