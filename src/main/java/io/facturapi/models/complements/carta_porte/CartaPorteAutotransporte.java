package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteAutotransporte {
  @JsonProperty("PermSCT")
  private String permSct;
  @JsonProperty("NumPermisoSCT")
  private String numPermisoSct;
  @JsonProperty("IdentificacionVehicular")
  private CartaPorteIdentificacionVehicular identificacionVehicular;
  @JsonProperty("Seguros")
  private CartaPorteSeguros seguros;
  @JsonProperty("Remolques")
  private List<CartaPorteRemolque> remolques = new ArrayList<>();

  public String getPermSct() { return permSct; }
  public void setPermSct(String permSct) { this.permSct = permSct; }
  public String getNumPermisoSct() { return numPermisoSct; }
  public void setNumPermisoSct(String numPermisoSct) { this.numPermisoSct = numPermisoSct; }
  public CartaPorteIdentificacionVehicular getIdentificacionVehicular() { return identificacionVehicular; }
  public void setIdentificacionVehicular(CartaPorteIdentificacionVehicular identificacionVehicular) { this.identificacionVehicular = identificacionVehicular; }
  public CartaPorteSeguros getSeguros() { return seguros; }
  public void setSeguros(CartaPorteSeguros seguros) { this.seguros = seguros; }
  public List<CartaPorteRemolque> getRemolques() { return remolques; }
  public void setRemolques(List<CartaPorteRemolque> remolques) { this.remolques = remolques; }
}
