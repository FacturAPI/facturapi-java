package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteCantidadTransporta {
  @JsonProperty("Cantidad")
  private Double cantidad;
  @JsonProperty("IDOrigen")
  private String idOrigen;
  @JsonProperty("IDDestino")
  private String idDestino;
  @JsonProperty("CvesTransporte")
  private String cvesTransporte;

  public Double getCantidad() { return cantidad; }
  public void setCantidad(Double cantidad) { this.cantidad = cantidad; }
  public String getIdOrigen() { return idOrigen; }
  public void setIdOrigen(String idOrigen) { this.idOrigen = idOrigen; }
  public String getIdDestino() { return idDestino; }
  public void setIdDestino(String idDestino) { this.idDestino = idDestino; }
  public String getCvesTransporte() { return cvesTransporte; }
  public void setCvesTransporte(String cvesTransporte) { this.cvesTransporte = cvesTransporte; }
}
