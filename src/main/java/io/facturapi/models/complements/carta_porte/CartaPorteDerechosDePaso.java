package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteDerechosDePaso {
  @JsonProperty("TipoDerechoDePaso")
  private String tipoDerechoDePaso;
  @JsonProperty("KilometrajePagado")
  private Double kilometrajePagado;

  public String getTipoDerechoDePaso() { return tipoDerechoDePaso; }
  public void setTipoDerechoDePaso(String tipoDerechoDePaso) { this.tipoDerechoDePaso = tipoDerechoDePaso; }
  public Double getKilometrajePagado() { return kilometrajePagado; }
  public void setKilometrajePagado(Double kilometrajePagado) { this.kilometrajePagado = kilometrajePagado; }
}
