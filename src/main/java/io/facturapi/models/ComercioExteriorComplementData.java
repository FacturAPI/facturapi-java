package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComercioExteriorComplementData {
  private static final ObjectMapper MAPPER = new ObjectMapper()
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  @JsonProperty("Version")
  private String version;
  @JsonProperty("MotivoTraslado")
  private String motivoTraslado;
  @JsonProperty("ClaveDePedimento")
  private String claveDePedimento;
  @JsonProperty("CertificadoOrigen")
  private Integer certificadoOrigen;
  @JsonProperty("NumCertificadoOrigen")
  private String numCertificadoOrigen;
  @JsonProperty("NumeroExportadorConfiable")
  private String numeroExportadorConfiable;
  @JsonProperty("Incoterm")
  private String incoterm;
  @JsonProperty("Observaciones")
  private String observaciones;
  @JsonProperty("TipoCambioUSD")
  private Double tipoCambioUsd;
  @JsonProperty("TotalUSD")
  private Double totalUsd;

  @JsonIgnore
  private Boolean emisorFromOrganization;
  @JsonIgnore
  private ComercioExteriorEmisor emisor;

  @JsonProperty("Propietario")
  private List<ComercioExteriorPartyRef> propietario = new ArrayList<>();
  @JsonProperty("Receptor")
  private ComercioExteriorReceptorRef receptor;
  @JsonProperty("Destinatario")
  private List<ComercioExteriorDestinatarioRef> destinatario = new ArrayList<>();
  @JsonProperty("Mercancias")
  private ComercioExteriorMercancias mercancias;

  public String getVersion() { return version; }
  public void setVersion(String version) { this.version = version; }
  public String getMotivoTraslado() { return motivoTraslado; }
  public void setMotivoTraslado(String motivoTraslado) { this.motivoTraslado = motivoTraslado; }
  public String getClaveDePedimento() { return claveDePedimento; }
  public void setClaveDePedimento(String claveDePedimento) { this.claveDePedimento = claveDePedimento; }
  public Integer getCertificadoOrigen() { return certificadoOrigen; }
  public void setCertificadoOrigen(Integer certificadoOrigen) { this.certificadoOrigen = certificadoOrigen; }
  public String getNumCertificadoOrigen() { return numCertificadoOrigen; }
  public void setNumCertificadoOrigen(String numCertificadoOrigen) { this.numCertificadoOrigen = numCertificadoOrigen; }
  public String getNumeroExportadorConfiable() { return numeroExportadorConfiable; }
  public void setNumeroExportadorConfiable(String numeroExportadorConfiable) { this.numeroExportadorConfiable = numeroExportadorConfiable; }
  public String getIncoterm() { return incoterm; }
  public void setIncoterm(String incoterm) { this.incoterm = incoterm; }
  public String getObservaciones() { return observaciones; }
  public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
  public Double getTipoCambioUsd() { return tipoCambioUsd; }
  public void setTipoCambioUsd(Double tipoCambioUsd) { this.tipoCambioUsd = tipoCambioUsd; }
  public Double getTotalUsd() { return totalUsd; }
  public void setTotalUsd(Double totalUsd) { this.totalUsd = totalUsd; }

  @JsonSetter("Emisor")
  private void setEmisorNode(JsonNode node) {
    this.emisorFromOrganization = null;
    this.emisor = null;
    if (node == null || node.isNull()) {
      return;
    }
    if (node.isBoolean()) {
      this.emisorFromOrganization = node.asBoolean();
    } else if (node.isObject()) {
      this.emisor = MAPPER.convertValue(node, ComercioExteriorEmisor.class);
    }
  }

  @JsonProperty("Emisor")
  public Object getEmisor() {
    if (emisorFromOrganization != null) {
      return emisorFromOrganization;
    }
    return emisor;
  }

  public Boolean getEmisorFromOrganization() { return emisorFromOrganization; }
  public ComercioExteriorEmisor getEmisorData() { return emisor; }
  public List<ComercioExteriorPartyRef> getPropietario() { return propietario; }
  public void setPropietario(List<ComercioExteriorPartyRef> propietario) { this.propietario = propietario; }
  public ComercioExteriorReceptorRef getReceptor() { return receptor; }
  public void setReceptor(ComercioExteriorReceptorRef receptor) { this.receptor = receptor; }
  public List<ComercioExteriorDestinatarioRef> getDestinatario() { return destinatario; }
  public void setDestinatario(List<ComercioExteriorDestinatarioRef> destinatario) { this.destinatario = destinatario; }
  public ComercioExteriorMercancias getMercancias() { return mercancias; }
  public void setMercancias(ComercioExteriorMercancias mercancias) { this.mercancias = mercancias; }
}
