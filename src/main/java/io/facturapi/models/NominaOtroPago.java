package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaOtroPago {
  @JsonProperty("tipo_otro_pago")
  private String tipoOtroPago;
  private String clave;
  private String concepto;
  private Double importe;
  @JsonProperty("subsidio_causado")
  private Double subsidioCausado;
  @JsonProperty("compensacion_saldos_a_favor")
  private NominaCompensacion compensacionSaldosAFavor;

  public String getTipoOtroPago() { return tipoOtroPago; }
  public void setTipoOtroPago(String tipoOtroPago) { this.tipoOtroPago = tipoOtroPago; }
  public String getClave() { return clave; }
  public void setClave(String clave) { this.clave = clave; }
  public String getConcepto() { return concepto; }
  public void setConcepto(String concepto) { this.concepto = concepto; }
  public Double getImporte() { return importe; }
  public void setImporte(Double importe) { this.importe = importe; }
  public Double getSubsidioCausado() { return subsidioCausado; }
  public void setSubsidioCausado(Double subsidioCausado) { this.subsidioCausado = subsidioCausado; }
  public NominaCompensacion getCompensacionSaldosAFavor() { return compensacionSaldosAFavor; }
  public void setCompensacionSaldosAFavor(NominaCompensacion compensacionSaldosAFavor) { this.compensacionSaldosAFavor = compensacionSaldosAFavor; }
}
