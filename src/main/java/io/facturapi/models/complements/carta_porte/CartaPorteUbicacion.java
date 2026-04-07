package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteUbicacion {
  @JsonProperty("TipoUbicacion")
  private String tipoUbicacion;
  @JsonProperty("IDUbicacion")
  private String idUbicacion;
  @JsonProperty("RFCRemitenteDestinatario")
  private String rfcRemitenteDestinatario;
  @JsonProperty("NombreRemitenteDestinatario")
  private String nombreRemitenteDestinatario;
  @JsonProperty("NumRegIdTrib")
  private String numRegIdTrib;
  @JsonProperty("ResidenciaFiscal")
  private String residenciaFiscal;
  @JsonProperty("NumEstacion")
  private String numEstacion;
  @JsonProperty("NombreEstacion")
  private String nombreEstacion;
  @JsonProperty("NavegacionTrafico")
  private String navegacionTrafico;
  @JsonProperty("FechaHoraSalidaLlegada")
  private String fechaHoraSalidaLlegada;
  @JsonProperty("TipoEstacion")
  private String tipoEstacion;
  @JsonProperty("DistanciaRecorrida")
  private Double distanciaRecorrida;
  @JsonProperty("Domicilio")
  private CartaPorteDomicilio domicilio;

  public String getTipoUbicacion() { return tipoUbicacion; }
  public void setTipoUbicacion(String tipoUbicacion) { this.tipoUbicacion = tipoUbicacion; }
  public String getIdUbicacion() { return idUbicacion; }
  public void setIdUbicacion(String idUbicacion) { this.idUbicacion = idUbicacion; }
  public String getRfcRemitenteDestinatario() { return rfcRemitenteDestinatario; }
  public void setRfcRemitenteDestinatario(String rfcRemitenteDestinatario) { this.rfcRemitenteDestinatario = rfcRemitenteDestinatario; }
  public String getNombreRemitenteDestinatario() { return nombreRemitenteDestinatario; }
  public void setNombreRemitenteDestinatario(String nombreRemitenteDestinatario) { this.nombreRemitenteDestinatario = nombreRemitenteDestinatario; }
  public String getNumRegIdTrib() { return numRegIdTrib; }
  public void setNumRegIdTrib(String numRegIdTrib) { this.numRegIdTrib = numRegIdTrib; }
  public String getResidenciaFiscal() { return residenciaFiscal; }
  public void setResidenciaFiscal(String residenciaFiscal) { this.residenciaFiscal = residenciaFiscal; }
  public String getNumEstacion() { return numEstacion; }
  public void setNumEstacion(String numEstacion) { this.numEstacion = numEstacion; }
  public String getNombreEstacion() { return nombreEstacion; }
  public void setNombreEstacion(String nombreEstacion) { this.nombreEstacion = nombreEstacion; }
  public String getNavegacionTrafico() { return navegacionTrafico; }
  public void setNavegacionTrafico(String navegacionTrafico) { this.navegacionTrafico = navegacionTrafico; }
  public String getFechaHoraSalidaLlegada() { return fechaHoraSalidaLlegada; }
  public void setFechaHoraSalidaLlegada(String fechaHoraSalidaLlegada) { this.fechaHoraSalidaLlegada = fechaHoraSalidaLlegada; }
  public String getTipoEstacion() { return tipoEstacion; }
  public void setTipoEstacion(String tipoEstacion) { this.tipoEstacion = tipoEstacion; }
  public Double getDistanciaRecorrida() { return distanciaRecorrida; }
  public void setDistanciaRecorrida(Double distanciaRecorrida) { this.distanciaRecorrida = distanciaRecorrida; }
  public CartaPorteDomicilio getDomicilio() { return domicilio; }
  public void setDomicilio(CartaPorteDomicilio domicilio) { this.domicilio = domicilio; }
}
