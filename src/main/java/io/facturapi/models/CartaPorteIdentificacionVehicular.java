package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteIdentificacionVehicular {
  @JsonProperty("ConfigVehicular")
  private String configVehicular;
  @JsonProperty("PesoBrutoVehicular")
  private Double pesoBrutoVehicular;
  @JsonProperty("PlacaVM")
  private String placaVm;
  @JsonProperty("AnioModeloVM")
  private String anioModeloVm;

  public String getConfigVehicular() { return configVehicular; }
  public void setConfigVehicular(String configVehicular) { this.configVehicular = configVehicular; }
  public Double getPesoBrutoVehicular() { return pesoBrutoVehicular; }
  public void setPesoBrutoVehicular(Double pesoBrutoVehicular) { this.pesoBrutoVehicular = pesoBrutoVehicular; }
  public String getPlacaVm() { return placaVm; }
  public void setPlacaVm(String placaVm) { this.placaVm = placaVm; }
  public String getAnioModeloVm() { return anioModeloVm; }
  public void setAnioModeloVm(String anioModeloVm) { this.anioModeloVm = anioModeloVm; }
}
