package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteSeguros {
  @JsonProperty("AseguraRespCivil")
  private String aseguraRespCivil;
  @JsonProperty("PolizaRespCivil")
  private String polizaRespCivil;
  @JsonProperty("AseguraMedAmbiente")
  private String aseguraMedAmbiente;
  @JsonProperty("PolizaMedAmbiente")
  private String polizaMedAmbiente;
  @JsonProperty("AseguraCarga")
  private String aseguraCarga;
  @JsonProperty("PolizaCarga")
  private String polizaCarga;
  @JsonProperty("PrimaSeguro")
  private Double primaSeguro;

  public String getAseguraRespCivil() { return aseguraRespCivil; }
  public void setAseguraRespCivil(String aseguraRespCivil) { this.aseguraRespCivil = aseguraRespCivil; }
  public String getPolizaRespCivil() { return polizaRespCivil; }
  public void setPolizaRespCivil(String polizaRespCivil) { this.polizaRespCivil = polizaRespCivil; }
  public String getAseguraMedAmbiente() { return aseguraMedAmbiente; }
  public void setAseguraMedAmbiente(String aseguraMedAmbiente) { this.aseguraMedAmbiente = aseguraMedAmbiente; }
  public String getPolizaMedAmbiente() { return polizaMedAmbiente; }
  public void setPolizaMedAmbiente(String polizaMedAmbiente) { this.polizaMedAmbiente = polizaMedAmbiente; }
  public String getAseguraCarga() { return aseguraCarga; }
  public void setAseguraCarga(String aseguraCarga) { this.aseguraCarga = aseguraCarga; }
  public String getPolizaCarga() { return polizaCarga; }
  public void setPolizaCarga(String polizaCarga) { this.polizaCarga = polizaCarga; }
  public Double getPrimaSeguro() { return primaSeguro; }
  public void setPrimaSeguro(Double primaSeguro) { this.primaSeguro = primaSeguro; }
}
