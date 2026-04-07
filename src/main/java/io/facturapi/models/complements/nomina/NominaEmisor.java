package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaEmisor {
  private String curp;
  private String registroPatronal;
  private String rfcPatronOrigen;
  private NominaEntidadSncf entidadSncf;

  public String getCurp() { return curp; }
  public void setCurp(String curp) { this.curp = curp; }
  public String getRegistroPatronal() { return registroPatronal; }
  public void setRegistroPatronal(String registroPatronal) { this.registroPatronal = registroPatronal; }
  public String getRfcPatronOrigen() { return rfcPatronOrigen; }
  public void setRfcPatronOrigen(String rfcPatronOrigen) { this.rfcPatronOrigen = rfcPatronOrigen; }
  public NominaEntidadSncf getEntidadSncf() { return entidadSncf; }
  public void setEntidadSncf(NominaEntidadSncf entidadSncf) { this.entidadSncf = entidadSncf; }
}
