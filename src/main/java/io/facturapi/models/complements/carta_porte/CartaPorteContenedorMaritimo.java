package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteContenedorMaritimo {
  @JsonProperty("TipoContenedor")
  private String tipoContenedor;
  @JsonProperty("MatriculaContenedor")
  private String matriculaContenedor;
  @JsonProperty("NumPrecinto")
  private String numPrecinto;
  @JsonProperty("IdCCPRelacionado")
  private String idCcpRelacionado;
  @JsonProperty("PlacaVMCCP")
  private String placaVmCcp;
  @JsonProperty("FechaCertificacionCCP")
  private String fechaCertificacionCcp;
  @JsonProperty("RemolquesCCP")
  private List<CartaPorteRemolqueCcp> remolquesCcp = new ArrayList<>();

  public String getTipoContenedor() { return tipoContenedor; }
  public void setTipoContenedor(String tipoContenedor) { this.tipoContenedor = tipoContenedor; }
  public String getMatriculaContenedor() { return matriculaContenedor; }
  public void setMatriculaContenedor(String matriculaContenedor) { this.matriculaContenedor = matriculaContenedor; }
  public String getNumPrecinto() { return numPrecinto; }
  public void setNumPrecinto(String numPrecinto) { this.numPrecinto = numPrecinto; }
  public String getIdCcpRelacionado() { return idCcpRelacionado; }
  public void setIdCcpRelacionado(String idCcpRelacionado) { this.idCcpRelacionado = idCcpRelacionado; }
  public String getPlacaVmCcp() { return placaVmCcp; }
  public void setPlacaVmCcp(String placaVmCcp) { this.placaVmCcp = placaVmCcp; }
  public String getFechaCertificacionCcp() { return fechaCertificacionCcp; }
  public void setFechaCertificacionCcp(String fechaCertificacionCcp) { this.fechaCertificacionCcp = fechaCertificacionCcp; }
  public List<CartaPorteRemolqueCcp> getRemolquesCcp() { return remolquesCcp; }
  public void setRemolquesCcp(List<CartaPorteRemolqueCcp> remolquesCcp) { this.remolquesCcp = remolquesCcp; }
}
