package io.facturapi.models.complements.comercio_exterior;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComercioExteriorDescripcionesEspecificas {
  @JsonProperty("Marca")
  private String marca;
  @JsonProperty("Modelo")
  private String modelo;
  @JsonProperty("SubModelo")
  private String subModelo;
  @JsonProperty("NumeroSerie")
  private String numeroSerie;

  public String getMarca() { return marca; }
  public void setMarca(String marca) { this.marca = marca; }
  public String getModelo() { return modelo; }
  public void setModelo(String modelo) { this.modelo = modelo; }
  public String getSubModelo() { return subModelo; }
  public void setSubModelo(String subModelo) { this.subModelo = subModelo; }
  public String getNumeroSerie() { return numeroSerie; }
  public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }
}
