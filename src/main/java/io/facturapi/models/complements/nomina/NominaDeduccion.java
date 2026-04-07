package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaDeduccion {
  private String tipoDeduccion;
  private String concepto;
  private String clave;
  private Double importe;

  public String getTipoDeduccion() { return tipoDeduccion; }
  public void setTipoDeduccion(String tipoDeduccion) { this.tipoDeduccion = tipoDeduccion; }
  public String getConcepto() { return concepto; }
  public void setConcepto(String concepto) { this.concepto = concepto; }
  public String getClave() { return clave; }
  public void setClave(String clave) { this.clave = clave; }
  public Double getImporte() { return importe; }
  public void setImporte(Double importe) { this.importe = importe; }
}
