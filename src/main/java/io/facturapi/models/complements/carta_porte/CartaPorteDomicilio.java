package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteDomicilio {
  @JsonProperty("Calle")
  private String calle;
  @JsonProperty("NumeroExterior")
  private String numeroExterior;
  @JsonProperty("NumeroInterior")
  private String numeroInterior;
  @JsonProperty("Colonia")
  private String colonia;
  @JsonProperty("Localidad")
  private String localidad;
  @JsonProperty("Referencia")
  private String referencia;
  @JsonProperty("Municipio")
  private String municipio;
  @JsonProperty("Estado")
  private String estado;
  @JsonProperty("Pais")
  private String pais;
  @JsonProperty("CodigoPostal")
  private String codigoPostal;

  public String getCalle() { return calle; }
  public void setCalle(String calle) { this.calle = calle; }
  public String getNumeroExterior() { return numeroExterior; }
  public void setNumeroExterior(String numeroExterior) { this.numeroExterior = numeroExterior; }
  public String getNumeroInterior() { return numeroInterior; }
  public void setNumeroInterior(String numeroInterior) { this.numeroInterior = numeroInterior; }
  public String getColonia() { return colonia; }
  public void setColonia(String colonia) { this.colonia = colonia; }
  public String getLocalidad() { return localidad; }
  public void setLocalidad(String localidad) { this.localidad = localidad; }
  public String getReferencia() { return referencia; }
  public void setReferencia(String referencia) { this.referencia = referencia; }
  public String getMunicipio() { return municipio; }
  public void setMunicipio(String municipio) { this.municipio = municipio; }
  public String getEstado() { return estado; }
  public void setEstado(String estado) { this.estado = estado; }
  public String getPais() { return pais; }
  public void setPais(String pais) { this.pais = pais; }
  public String getCodigoPostal() { return codigoPostal; }
  public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
}
