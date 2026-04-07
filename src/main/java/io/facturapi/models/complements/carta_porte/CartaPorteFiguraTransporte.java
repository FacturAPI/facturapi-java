package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteFiguraTransporte {
  @JsonProperty("TipoFigura")
  private String tipoFigura;
  @JsonProperty("RFCFigura")
  private String rfcFigura;
  @JsonProperty("NumLicencia")
  private String numLicencia;
  @JsonProperty("NombreFigura")
  private String nombreFigura;
  @JsonProperty("NumRegIdTribFigura")
  private String numRegIdTribFigura;
  @JsonProperty("ResidenciaFiscalFigura")
  private String residenciaFiscalFigura;
  @JsonProperty("PartesTransporte")
  private List<CartaPorteParteTransporte> partesTransporte = new ArrayList<>();
  @JsonProperty("Domicilio")
  private CartaPorteDomicilio domicilio;

  public String getTipoFigura() { return tipoFigura; }
  public void setTipoFigura(String tipoFigura) { this.tipoFigura = tipoFigura; }
  public String getRfcFigura() { return rfcFigura; }
  public void setRfcFigura(String rfcFigura) { this.rfcFigura = rfcFigura; }
  public String getNumLicencia() { return numLicencia; }
  public void setNumLicencia(String numLicencia) { this.numLicencia = numLicencia; }
  public String getNombreFigura() { return nombreFigura; }
  public void setNombreFigura(String nombreFigura) { this.nombreFigura = nombreFigura; }
  public String getNumRegIdTribFigura() { return numRegIdTribFigura; }
  public void setNumRegIdTribFigura(String numRegIdTribFigura) { this.numRegIdTribFigura = numRegIdTribFigura; }
  public String getResidenciaFiscalFigura() { return residenciaFiscalFigura; }
  public void setResidenciaFiscalFigura(String residenciaFiscalFigura) { this.residenciaFiscalFigura = residenciaFiscalFigura; }
  public List<CartaPorteParteTransporte> getPartesTransporte() { return partesTransporte; }
  public void setPartesTransporte(List<CartaPorteParteTransporte> partesTransporte) { this.partesTransporte = partesTransporte; }
  public CartaPorteDomicilio getDomicilio() { return domicilio; }
  public void setDomicilio(CartaPorteDomicilio domicilio) { this.domicilio = domicilio; }
}
