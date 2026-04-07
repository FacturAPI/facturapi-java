package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteParteTransporte {
  @JsonProperty("ParteTransporte")
  private String parteTransporte;

  public String getParteTransporte() { return parteTransporte; }
  public void setParteTransporte(String parteTransporte) { this.parteTransporte = parteTransporte; }
}
