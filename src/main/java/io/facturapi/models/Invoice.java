package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.facturapi.models.complements.InvoiceComplement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {
  private String id;
  private String organization;
  private Boolean livemode;
  @JsonProperty("created_at")
  private Instant createdAt;
  private Instant date;
  @JsonProperty("issuer_type")
  private String issuerType;
  private String type;
  private String status;
  @JsonProperty("cfdi_version")
  private Integer cfdiVersion;
  @JsonProperty("issuer_info")
  private CustomerInfo issuerInfo;
  @JsonProperty("payment_form")
  private String paymentForm;
  @JsonProperty("payment_method")
  private String paymentMethod;
  private String currency;
  private Double exchange;
  private String uuid;
  private CustomerInfo customer;
  private Double total;
  private String use;
  @JsonProperty("folio_number")
  private String folioNumber;
  private String series;
  @JsonProperty("is_ready_to_stamp")
  private Boolean readyToStamp;
  private List<InvoiceItem> items = new ArrayList<>();
  private Address address;
  @JsonProperty("amount_due")
  private Double amountDue;
  @JsonProperty("verification_url")
  private String verificationUrl;
  @JsonProperty("verification_carta_porte")
  private String verificationCartaPorte;
  @JsonProperty("cancellation_status")
  private String cancellationStatus;
  @JsonProperty("external_id")
  private String externalId;
  @JsonProperty("idempotency_key")
  private String idempotencyKey;
  private Stamp stamp;
  private String addenda;
  private String conditions;
  @JsonProperty("pdf_custom_section")
  private String pdfCustomSection;
  @JsonProperty("export")
  private String exportReference;
  private GlobalInfo global;
  private InvoiceCancellation cancellation;
  private List<InvoiceComplement> complements = new ArrayList<>();
  @JsonProperty("related_documents")
  private List<RelatedDocument> relatedDocuments = new ArrayList<>();
  private List<XmlNamespace> namespaces = new ArrayList<>();
  @JsonProperty("received_payment_ids")
  private List<String> receivedPaymentIds = new ArrayList<>();
  @JsonProperty("target_invoice_ids")
  private List<String> targetInvoiceIds = new ArrayList<>();

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getOrganization() { return organization; }
  public void setOrganization(String organization) { this.organization = organization; }
  public Boolean getLivemode() { return livemode; }
  public void setLivemode(Boolean livemode) { this.livemode = livemode; }
  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
  public Instant getDate() { return date; }
  public void setDate(Instant date) { this.date = date; }
  public String getIssuerType() { return issuerType; }
  public void setIssuerType(String issuerType) { this.issuerType = issuerType; }
  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  public Integer getCfdiVersion() { return cfdiVersion; }
  public void setCfdiVersion(Integer cfdiVersion) { this.cfdiVersion = cfdiVersion; }
  public CustomerInfo getIssuerInfo() { return issuerInfo; }
  public void setIssuerInfo(CustomerInfo issuerInfo) { this.issuerInfo = issuerInfo; }
  public String getPaymentForm() { return paymentForm; }
  public void setPaymentForm(String paymentForm) { this.paymentForm = paymentForm; }
  public String getPaymentMethod() { return paymentMethod; }
  public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
  public String getCurrency() { return currency; }
  public void setCurrency(String currency) { this.currency = currency; }
  public Double getExchange() { return exchange; }
  public void setExchange(Double exchange) { this.exchange = exchange; }
  public String getUuid() { return uuid; }
  public void setUuid(String uuid) { this.uuid = uuid; }
  public CustomerInfo getCustomer() { return customer; }
  public void setCustomer(CustomerInfo customer) { this.customer = customer; }
  public Double getTotal() { return total; }
  public void setTotal(Double total) { this.total = total; }
  public String getUse() { return use; }
  public void setUse(String use) { this.use = use; }
  public String getFolioNumber() { return folioNumber; }
  public void setFolioNumber(String folioNumber) { this.folioNumber = folioNumber; }
  public String getSeries() { return series; }
  public void setSeries(String series) { this.series = series; }
  public Boolean getReadyToStamp() { return readyToStamp; }
  public void setReadyToStamp(Boolean readyToStamp) { this.readyToStamp = readyToStamp; }
  public List<InvoiceItem> getItems() { return items; }
  public void setItems(List<InvoiceItem> items) { this.items = items; }
  public Address getAddress() { return address; }
  public void setAddress(Address address) { this.address = address; }
  public Double getAmountDue() { return amountDue; }
  public void setAmountDue(Double amountDue) { this.amountDue = amountDue; }
  public String getVerificationUrl() { return verificationUrl; }
  public void setVerificationUrl(String verificationUrl) { this.verificationUrl = verificationUrl; }
  public String getVerificationCartaPorte() { return verificationCartaPorte; }
  public void setVerificationCartaPorte(String verificationCartaPorte) { this.verificationCartaPorte = verificationCartaPorte; }
  public String getCancellationStatus() { return cancellationStatus; }
  public void setCancellationStatus(String cancellationStatus) { this.cancellationStatus = cancellationStatus; }
  public String getExternalId() { return externalId; }
  public void setExternalId(String externalId) { this.externalId = externalId; }
  public String getIdempotencyKey() { return idempotencyKey; }
  public void setIdempotencyKey(String idempotencyKey) { this.idempotencyKey = idempotencyKey; }
  public Stamp getStamp() { return stamp; }
  public void setStamp(Stamp stamp) { this.stamp = stamp; }
  public String getAddenda() { return addenda; }
  public void setAddenda(String addenda) { this.addenda = addenda; }
  public String getConditions() { return conditions; }
  public void setConditions(String conditions) { this.conditions = conditions; }
  public String getPdfCustomSection() { return pdfCustomSection; }
  public void setPdfCustomSection(String pdfCustomSection) { this.pdfCustomSection = pdfCustomSection; }
  public String getExportReference() { return exportReference; }
  public void setExportReference(String exportReference) { this.exportReference = exportReference; }
  public GlobalInfo getGlobal() { return global; }
  public void setGlobal(GlobalInfo global) { this.global = global; }
  public InvoiceCancellation getCancellation() { return cancellation; }
  public void setCancellation(InvoiceCancellation cancellation) { this.cancellation = cancellation; }
  public List<InvoiceComplement> getComplements() { return complements; }
  public void setComplements(List<InvoiceComplement> complements) { this.complements = complements; }
  public List<RelatedDocument> getRelatedDocuments() { return relatedDocuments; }
  public void setRelatedDocuments(List<RelatedDocument> relatedDocuments) { this.relatedDocuments = relatedDocuments; }
  public List<XmlNamespace> getNamespaces() { return namespaces; }
  public void setNamespaces(List<XmlNamespace> namespaces) { this.namespaces = namespaces; }
  public List<String> getReceivedPaymentIds() { return receivedPaymentIds; }
  public void setReceivedPaymentIds(List<String> receivedPaymentIds) { this.receivedPaymentIds = receivedPaymentIds; }
  public List<String> getTargetInvoiceIds() { return targetInvoiceIds; }
  public void setTargetInvoiceIds(List<String> targetInvoiceIds) { this.targetInvoiceIds = targetInvoiceIds; }
}
