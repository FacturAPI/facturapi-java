package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaIncapacidad {
  @JsonProperty("dias_incapacidad")
  private Integer diasIncapacidad;
  @JsonProperty("tipo_incapacidad")
  private String tipoIncapacidad;
  @JsonProperty("importe_monetario")
  private Double importeMonetario;

  public Integer getDiasIncapacidad() { return diasIncapacidad; }
  public void setDiasIncapacidad(Integer diasIncapacidad) { this.diasIncapacidad = diasIncapacidad; }
  public String getTipoIncapacidad() { return tipoIncapacidad; }
  public void setTipoIncapacidad(String tipoIncapacidad) { this.tipoIncapacidad = tipoIncapacidad; }
  public Double getImporteMonetario() { return importeMonetario; }
  public void setImporteMonetario(Double importeMonetario) { this.importeMonetario = importeMonetario; }
}
