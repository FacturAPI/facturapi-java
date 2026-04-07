package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Receipt {
  private String id;
  @JsonProperty("created_at")
  private String createdAt;
  private String date;
  @JsonProperty("api_version")
  private Integer apiVersion;
  private Boolean livemode;
  private String organization;
  @JsonProperty("folio_number")
  private Integer folioNumber;
  @JsonProperty("external_id")
  private String externalId;
  @JsonProperty("idempotency_key")
  private String idempotencyKey;
  private String branch;
  @JsonProperty("payment_form")
  private String paymentForm;
  private List<InvoiceItem> items = new ArrayList<>();
  private String currency;
  private Double exchange;
  private Double total;
  private String invoice;
  @JsonProperty("expires_at")
  private String expiresAt;
  private String key;
  private String status;
  @JsonProperty("self_invoice_url")
  private String selfInvoiceUrl;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getCreatedAt() { return createdAt; }
  public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
  public String getDate() { return date; }
  public void setDate(String date) { this.date = date; }
  public Integer getApiVersion() { return apiVersion; }
  public void setApiVersion(Integer apiVersion) { this.apiVersion = apiVersion; }
  public Boolean getLivemode() { return livemode; }
  public void setLivemode(Boolean livemode) { this.livemode = livemode; }
  public String getOrganization() { return organization; }
  public void setOrganization(String organization) { this.organization = organization; }
  public Integer getFolioNumber() { return folioNumber; }
  public void setFolioNumber(Integer folioNumber) { this.folioNumber = folioNumber; }
  public String getExternalId() { return externalId; }
  public void setExternalId(String externalId) { this.externalId = externalId; }
  public String getIdempotencyKey() { return idempotencyKey; }
  public void setIdempotencyKey(String idempotencyKey) { this.idempotencyKey = idempotencyKey; }
  public String getBranch() { return branch; }
  public void setBranch(String branch) { this.branch = branch; }
  public String getPaymentForm() { return paymentForm; }
  public void setPaymentForm(String paymentForm) { this.paymentForm = paymentForm; }
  public List<InvoiceItem> getItems() { return items; }
  public void setItems(List<InvoiceItem> items) { this.items = items; }
  public String getCurrency() { return currency; }
  public void setCurrency(String currency) { this.currency = currency; }
  public Double getExchange() { return exchange; }
  public void setExchange(Double exchange) { this.exchange = exchange; }
  public Double getTotal() { return total; }
  public void setTotal(Double total) { this.total = total; }
  public String getInvoice() { return invoice; }
  public void setInvoice(String invoice) { this.invoice = invoice; }
  public String getExpiresAt() { return expiresAt; }
  public void setExpiresAt(String expiresAt) { this.expiresAt = expiresAt; }
  public String getKey() { return key; }
  public void setKey(String key) { this.key = key; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  public String getSelfInvoiceUrl() { return selfInvoiceUrl; }
  public void setSelfInvoiceUrl(String selfInvoiceUrl) { this.selfInvoiceUrl = selfInvoiceUrl; }
}
