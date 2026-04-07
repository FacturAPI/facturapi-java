package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RetentionTotals {
  @JsonProperty("monto_tot_grav")
  private Double montoTotGrav;
  @JsonProperty("monto_tot_exent")
  private Double montoTotExent;
  @JsonProperty("monto_tot_operacion")
  private Double montoTotOperacion;
  @JsonProperty("monto_tot_ret")
  private Double montoTotRet;
  @JsonProperty("imp_retenidos")
  private List<RetentionRetainedTax> impRetenidos = new ArrayList<>();

  public Double getMontoTotGrav() { return montoTotGrav; }
  public void setMontoTotGrav(Double montoTotGrav) { this.montoTotGrav = montoTotGrav; }
  public Double getMontoTotExent() { return montoTotExent; }
  public void setMontoTotExent(Double montoTotExent) { this.montoTotExent = montoTotExent; }
  public Double getMontoTotOperacion() { return montoTotOperacion; }
  public void setMontoTotOperacion(Double montoTotOperacion) { this.montoTotOperacion = montoTotOperacion; }
  public Double getMontoTotRet() { return montoTotRet; }
  public void setMontoTotRet(Double montoTotRet) { this.montoTotRet = montoTotRet; }
  public List<RetentionRetainedTax> getImpRetenidos() { return impRetenidos; }
  public void setImpRetenidos(List<RetentionRetainedTax> impRetenidos) { this.impRetenidos = impRetenidos; }
}
