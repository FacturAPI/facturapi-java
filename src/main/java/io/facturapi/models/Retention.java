package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Retention {
  private String id;
  @JsonProperty("created_at")
  private Instant createdAt;
  private CustomerInfo customer;
  private String organization;
  private Boolean livemode;
  private String status;
  private String uuid;
  @JsonProperty("external_id")
  private String externalId;
  @JsonProperty("fecha_exp")
  private Instant fechaExp;
  @JsonProperty("cve_retenc")
  private String cveRetenc;
  @JsonProperty("folio_int")
  private String folioInt;
  @JsonProperty("desc_retenc")
  private String descRetenc;
  private RetentionPeriod periodo;
  private RetentionTotals totales;
  private List<XmlNamespace> namespaces = new ArrayList<>();
  @JsonProperty("related_documents")
  private List<RelatedDocument> relatedDocuments = new ArrayList<>();
  private List<String> complements = new ArrayList<>();
  private List<String> addenda = new ArrayList<>();
  @JsonProperty("cancellation_receipt")
  private String cancellationReceipt;
  private Stamp stamp;
  @JsonProperty("pdf_custom_section")
  private String pdfCustomSection;
  @JsonProperty("verification_url")
  private String verificationUrl;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
  public CustomerInfo getCustomer() { return customer; }
  public void setCustomer(CustomerInfo customer) { this.customer = customer; }
  public String getOrganization() { return organization; }
  public void setOrganization(String organization) { this.organization = organization; }
  public Boolean getLivemode() { return livemode; }
  public void setLivemode(Boolean livemode) { this.livemode = livemode; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  public String getUuid() { return uuid; }
  public void setUuid(String uuid) { this.uuid = uuid; }
  public String getExternalId() { return externalId; }
  public void setExternalId(String externalId) { this.externalId = externalId; }
  public Instant getFechaExp() { return fechaExp; }
  public void setFechaExp(Instant fechaExp) { this.fechaExp = fechaExp; }
  public String getCveRetenc() { return cveRetenc; }
  public void setCveRetenc(String cveRetenc) { this.cveRetenc = cveRetenc; }
  public String getFolioInt() { return folioInt; }
  public void setFolioInt(String folioInt) { this.folioInt = folioInt; }
  public String getDescRetenc() { return descRetenc; }
  public void setDescRetenc(String descRetenc) { this.descRetenc = descRetenc; }
  public RetentionPeriod getPeriodo() { return periodo; }
  public void setPeriodo(RetentionPeriod periodo) { this.periodo = periodo; }
  public RetentionTotals getTotales() { return totales; }
  public void setTotales(RetentionTotals totales) { this.totales = totales; }
  public List<XmlNamespace> getNamespaces() { return namespaces; }
  public void setNamespaces(List<XmlNamespace> namespaces) { this.namespaces = namespaces; }
  public List<RelatedDocument> getRelatedDocuments() { return relatedDocuments; }
  public void setRelatedDocuments(List<RelatedDocument> relatedDocuments) { this.relatedDocuments = relatedDocuments; }
  public List<String> getComplements() { return complements; }
  public void setComplements(List<String> complements) { this.complements = complements; }
  public List<String> getAddenda() { return addenda; }
  public void setAddenda(List<String> addenda) { this.addenda = addenda; }
  public String getCancellationReceipt() { return cancellationReceipt; }
  public void setCancellationReceipt(String cancellationReceipt) { this.cancellationReceipt = cancellationReceipt; }
  public Stamp getStamp() { return stamp; }
  public void setStamp(Stamp stamp) { this.stamp = stamp; }
  public String getPdfCustomSection() { return pdfCustomSection; }
  public void setPdfCustomSection(String pdfCustomSection) { this.pdfCustomSection = pdfCustomSection; }
  public String getVerificationUrl() { return verificationUrl; }
  public void setVerificationUrl(String verificationUrl) { this.verificationUrl = verificationUrl; }
}
