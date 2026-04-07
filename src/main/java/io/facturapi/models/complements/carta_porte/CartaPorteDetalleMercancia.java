package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteDetalleMercancia {
  @JsonProperty("UnidadPesoMerc")
  private String unidadPesoMerc;
  @JsonProperty("PesoBruto")
  private Double pesoBruto;
  @JsonProperty("PesoNeto")
  private Double pesoNeto;
  @JsonProperty("PesoTara")
  private Double pesoTara;
  @JsonProperty("NumPiezas")
  private Double numPiezas;

  public String getUnidadPesoMerc() { return unidadPesoMerc; }
  public void setUnidadPesoMerc(String unidadPesoMerc) { this.unidadPesoMerc = unidadPesoMerc; }
  public Double getPesoBruto() { return pesoBruto; }
  public void setPesoBruto(Double pesoBruto) { this.pesoBruto = pesoBruto; }
  public Double getPesoNeto() { return pesoNeto; }
  public void setPesoNeto(Double pesoNeto) { this.pesoNeto = pesoNeto; }
  public Double getPesoTara() { return pesoTara; }
  public void setPesoTara(Double pesoTara) { this.pesoTara = pesoTara; }
  public Double getNumPiezas() { return numPiezas; }
  public void setNumPiezas(Double numPiezas) { this.numPiezas = numPiezas; }
}
