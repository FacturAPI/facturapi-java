package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteTransporteAereo {
  @JsonProperty("PermSCT")
  private String permSct;
  @JsonProperty("NumPermisoSCT")
  private String numPermisoSct;
  @JsonProperty("MatriculaAeronave")
  private String matriculaAeronave;
  @JsonProperty("NombreAseg")
  private String nombreAseg;
  @JsonProperty("NumPolizaSeguro")
  private String numPolizaSeguro;
  @JsonProperty("NumeroGuia")
  private String numeroGuia;
  @JsonProperty("LugarContrato")
  private String lugarContrato;
  @JsonProperty("CodigoTransportista")
  private String codigoTransportista;
  @JsonProperty("RFCEmbarcador")
  private String rfcEmbarcador;
  @JsonProperty("NumRegIdTribEmbarc")
  private String numRegIdTribEmbarc;
  @JsonProperty("ResidenciaFiscalEmbarc")
  private String residenciaFiscalEmbarc;
  @JsonProperty("NombreEmbarcador")
  private String nombreEmbarcador;

  public String getPermSct() { return permSct; }
  public void setPermSct(String permSct) { this.permSct = permSct; }
  public String getNumPermisoSct() { return numPermisoSct; }
  public void setNumPermisoSct(String numPermisoSct) { this.numPermisoSct = numPermisoSct; }
  public String getMatriculaAeronave() { return matriculaAeronave; }
  public void setMatriculaAeronave(String matriculaAeronave) { this.matriculaAeronave = matriculaAeronave; }
  public String getNombreAseg() { return nombreAseg; }
  public void setNombreAseg(String nombreAseg) { this.nombreAseg = nombreAseg; }
  public String getNumPolizaSeguro() { return numPolizaSeguro; }
  public void setNumPolizaSeguro(String numPolizaSeguro) { this.numPolizaSeguro = numPolizaSeguro; }
  public String getNumeroGuia() { return numeroGuia; }
  public void setNumeroGuia(String numeroGuia) { this.numeroGuia = numeroGuia; }
  public String getLugarContrato() { return lugarContrato; }
  public void setLugarContrato(String lugarContrato) { this.lugarContrato = lugarContrato; }
  public String getCodigoTransportista() { return codigoTransportista; }
  public void setCodigoTransportista(String codigoTransportista) { this.codigoTransportista = codigoTransportista; }
  public String getRfcEmbarcador() { return rfcEmbarcador; }
  public void setRfcEmbarcador(String rfcEmbarcador) { this.rfcEmbarcador = rfcEmbarcador; }
  public String getNumRegIdTribEmbarc() { return numRegIdTribEmbarc; }
  public void setNumRegIdTribEmbarc(String numRegIdTribEmbarc) { this.numRegIdTribEmbarc = numRegIdTribEmbarc; }
  public String getResidenciaFiscalEmbarc() { return residenciaFiscalEmbarc; }
  public void setResidenciaFiscalEmbarc(String residenciaFiscalEmbarc) { this.residenciaFiscalEmbarc = residenciaFiscalEmbarc; }
  public String getNombreEmbarcador() { return nombreEmbarcador; }
  public void setNombreEmbarcador(String nombreEmbarcador) { this.nombreEmbarcador = nombreEmbarcador; }
}
