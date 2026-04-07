package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaSubcontratacion {
  private String rfcLabora;
  private Double porcentajeTiempo;

  public String getRfcLabora() { return rfcLabora; }
  public void setRfcLabora(String rfcLabora) { this.rfcLabora = rfcLabora; }
  public Double getPorcentajeTiempo() { return porcentajeTiempo; }
  public void setPorcentajeTiempo(Double porcentajeTiempo) { this.porcentajeTiempo = porcentajeTiempo; }
}
