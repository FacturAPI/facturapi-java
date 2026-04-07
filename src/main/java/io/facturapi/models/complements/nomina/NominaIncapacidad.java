package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaIncapacidad {
  private Integer diasIncapacidad;
  private String tipoIncapacidad;
  private Double importeMonetario;

  public Integer getDiasIncapacidad() { return diasIncapacidad; }
  public void setDiasIncapacidad(Integer diasIncapacidad) { this.diasIncapacidad = diasIncapacidad; }
  public String getTipoIncapacidad() { return tipoIncapacidad; }
  public void setTipoIncapacidad(String tipoIncapacidad) { this.tipoIncapacidad = tipoIncapacidad; }
  public Double getImporteMonetario() { return importeMonetario; }
  public void setImporteMonetario(Double importeMonetario) { this.importeMonetario = importeMonetario; }
}
