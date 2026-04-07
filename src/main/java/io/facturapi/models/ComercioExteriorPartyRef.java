package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComercioExteriorPartyRef {
  private String id;
  @JsonProperty("NumRegIdTrib")
  private String numRegIdTrib;
  @JsonProperty("ResidenciaFiscal")
  private String residenciaFiscal;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getNumRegIdTrib() { return numRegIdTrib; }
  public void setNumRegIdTrib(String numRegIdTrib) { this.numRegIdTrib = numRegIdTrib; }
  public String getResidenciaFiscal() { return residenciaFiscal; }
  public void setResidenciaFiscal(String residenciaFiscal) { this.residenciaFiscal = residenciaFiscal; }
}
