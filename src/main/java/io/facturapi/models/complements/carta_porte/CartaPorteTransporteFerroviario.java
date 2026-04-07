package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteTransporteFerroviario {
  @JsonProperty("TipoDeServicio")
  private String tipoDeServicio;
  @JsonProperty("TipoDeTrafico")
  private String tipoDeTrafico;
  @JsonProperty("NombreAseg")
  private String nombreAseg;
  @JsonProperty("NumPolizaSeguro")
  private String numPolizaSeguro;
  @JsonProperty("DerechosDePaso")
  private List<CartaPorteDerechosDePaso> derechosDePaso = new ArrayList<>();
  @JsonProperty("Carro")
  private List<CartaPorteCarroFerroviario> carro = new ArrayList<>();

  public String getTipoDeServicio() { return tipoDeServicio; }
  public void setTipoDeServicio(String tipoDeServicio) { this.tipoDeServicio = tipoDeServicio; }
  public String getTipoDeTrafico() { return tipoDeTrafico; }
  public void setTipoDeTrafico(String tipoDeTrafico) { this.tipoDeTrafico = tipoDeTrafico; }
  public String getNombreAseg() { return nombreAseg; }
  public void setNombreAseg(String nombreAseg) { this.nombreAseg = nombreAseg; }
  public String getNumPolizaSeguro() { return numPolizaSeguro; }
  public void setNumPolizaSeguro(String numPolizaSeguro) { this.numPolizaSeguro = numPolizaSeguro; }
  public List<CartaPorteDerechosDePaso> getDerechosDePaso() { return derechosDePaso; }
  public void setDerechosDePaso(List<CartaPorteDerechosDePaso> derechosDePaso) { this.derechosDePaso = derechosDePaso; }
  public List<CartaPorteCarroFerroviario> getCarro() { return carro; }
  public void setCarro(List<CartaPorteCarroFerroviario> carro) { this.carro = carro; }
}
