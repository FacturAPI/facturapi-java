package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteDocumentacionAduanera {
  @JsonProperty("TipoDocumento")
  private String tipoDocumento;
  @JsonProperty("NumPedimento")
  private String numPedimento;
  @JsonProperty("IdentDocAduanero")
  private String identDocAduanero;
  @JsonProperty("RFCImpo")
  private String rfcImpo;

  public String getTipoDocumento() { return tipoDocumento; }
  public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
  public String getNumPedimento() { return numPedimento; }
  public void setNumPedimento(String numPedimento) { this.numPedimento = numPedimento; }
  public String getIdentDocAduanero() { return identDocAduanero; }
  public void setIdentDocAduanero(String identDocAduanero) { this.identDocAduanero = identDocAduanero; }
  public String getRfcImpo() { return rfcImpo; }
  public void setRfcImpo(String rfcImpo) { this.rfcImpo = rfcImpo; }
}
