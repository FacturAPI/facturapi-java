package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComercioExteriorEmisor {
  @JsonProperty("Domicilio")
  private ComercioExteriorDomicilio domicilio;
  @JsonProperty("Curp")
  private String curp;

  public ComercioExteriorDomicilio getDomicilio() { return domicilio; }
  public void setDomicilio(ComercioExteriorDomicilio domicilio) { this.domicilio = domicilio; }
  public String getCurp() { return curp; }
  public void setCurp(String curp) { this.curp = curp; }
}
