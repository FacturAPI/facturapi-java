package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteRemolqueCcp {
  @JsonProperty("SubTipoRemCCP")
  private String subTipoRemCcp;
  @JsonProperty("PlacaCCP")
  private String placaCcp;

  public String getSubTipoRemCcp() { return subTipoRemCcp; }
  public void setSubTipoRemCcp(String subTipoRemCcp) { this.subTipoRemCcp = subTipoRemCcp; }
  public String getPlacaCcp() { return placaCcp; }
  public void setPlacaCcp(String placaCcp) { this.placaCcp = placaCcp; }
}
