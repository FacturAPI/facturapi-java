package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteComplementData {
  @JsonProperty("IdCCP")
  private String idCcp;
  @JsonProperty("TranspInternac")
  private String transpInternac;
  @JsonProperty("EntradaSalidaMerc")
  private String entradaSalidaMerc;
  @JsonProperty("PaisOrigenDestino")
  private String paisOrigenDestino;
  @JsonProperty("ViaEntradaSalida")
  private String viaEntradaSalida;
  @JsonProperty("TotalDistRec")
  private Double totalDistRec;
  @JsonProperty("RegistroISTMO")
  private String registroIstmo;
  @JsonProperty("UbicacionPoloOrigen")
  private String ubicacionPoloOrigen;
  @JsonProperty("UbicacionPoloDestino")
  private String ubicacionPoloDestino;
  @JsonProperty("RegimenesAduaneros")
  private Map<String, Object> regimenesAduaneros = new HashMap<>();
  @JsonProperty("Ubicaciones")
  private List<CartaPorteUbicacion> ubicaciones = new ArrayList<>();
  @JsonProperty("Mercancias")
  private CartaPorteMercancias mercancias;
  @JsonProperty("FiguraTransporte")
  private List<CartaPorteFiguraTransporte> figuraTransporte = new ArrayList<>();

  public String getIdCcp() { return idCcp; }
  public void setIdCcp(String idCcp) { this.idCcp = idCcp; }
  public String getTranspInternac() { return transpInternac; }
  public void setTranspInternac(String transpInternac) { this.transpInternac = transpInternac; }
  public String getEntradaSalidaMerc() { return entradaSalidaMerc; }
  public void setEntradaSalidaMerc(String entradaSalidaMerc) { this.entradaSalidaMerc = entradaSalidaMerc; }
  public String getPaisOrigenDestino() { return paisOrigenDestino; }
  public void setPaisOrigenDestino(String paisOrigenDestino) { this.paisOrigenDestino = paisOrigenDestino; }
  public String getViaEntradaSalida() { return viaEntradaSalida; }
  public void setViaEntradaSalida(String viaEntradaSalida) { this.viaEntradaSalida = viaEntradaSalida; }
  public Double getTotalDistRec() { return totalDistRec; }
  public void setTotalDistRec(Double totalDistRec) { this.totalDistRec = totalDistRec; }
  public String getRegistroIstmo() { return registroIstmo; }
  public void setRegistroIstmo(String registroIstmo) { this.registroIstmo = registroIstmo; }
  public String getUbicacionPoloOrigen() { return ubicacionPoloOrigen; }
  public void setUbicacionPoloOrigen(String ubicacionPoloOrigen) { this.ubicacionPoloOrigen = ubicacionPoloOrigen; }
  public String getUbicacionPoloDestino() { return ubicacionPoloDestino; }
  public void setUbicacionPoloDestino(String ubicacionPoloDestino) { this.ubicacionPoloDestino = ubicacionPoloDestino; }
  public Map<String, Object> getRegimenesAduaneros() { return regimenesAduaneros; }
  public void setRegimenesAduaneros(Map<String, Object> regimenesAduaneros) { this.regimenesAduaneros = regimenesAduaneros; }
  public List<CartaPorteUbicacion> getUbicaciones() { return ubicaciones; }
  public void setUbicaciones(List<CartaPorteUbicacion> ubicaciones) { this.ubicaciones = ubicaciones; }
  public CartaPorteMercancias getMercancias() { return mercancias; }
  public void setMercancias(CartaPorteMercancias mercancias) { this.mercancias = mercancias; }
  public List<CartaPorteFiguraTransporte> getFiguraTransporte() { return figuraTransporte; }
  public void setFiguraTransporte(List<CartaPorteFiguraTransporte> figuraTransporte) { this.figuraTransporte = figuraTransporte; }
}
