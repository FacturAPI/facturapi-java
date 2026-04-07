package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComercioExteriorReceptorRef {
  private String id;
  @JsonProperty("Domicilio")
  private ComercioExteriorDomicilio domicilio;
  @JsonProperty("NumRegIdTrib")
  private String numRegIdTrib;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public ComercioExteriorDomicilio getDomicilio() { return domicilio; }
  public void setDomicilio(ComercioExteriorDomicilio domicilio) { this.domicilio = domicilio; }
  public String getNumRegIdTrib() { return numRegIdTrib; }
  public void setNumRegIdTrib(String numRegIdTrib) { this.numRegIdTrib = numRegIdTrib; }
}
