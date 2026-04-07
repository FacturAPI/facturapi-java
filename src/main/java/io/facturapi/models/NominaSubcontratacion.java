package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaSubcontratacion {
  @JsonProperty("rfc_labora")
  private String rfcLabora;
  @JsonProperty("porcentaje_tiempo")
  private Double porcentajeTiempo;

  public String getRfcLabora() { return rfcLabora; }
  public void setRfcLabora(String rfcLabora) { this.rfcLabora = rfcLabora; }
  public Double getPorcentajeTiempo() { return porcentajeTiempo; }
  public void setPorcentajeTiempo(Double porcentajeTiempo) { this.porcentajeTiempo = porcentajeTiempo; }
}
