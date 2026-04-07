package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaAcciones {
  private Double valorMercado;
  private Double precioAlOtorgarse;

  public Double getValorMercado() { return valorMercado; }
  public void setValorMercado(Double valorMercado) { this.valorMercado = valorMercado; }
  public Double getPrecioAlOtorgarse() { return precioAlOtorgarse; }
  public void setPrecioAlOtorgarse(Double precioAlOtorgarse) { this.precioAlOtorgarse = precioAlOtorgarse; }
}
