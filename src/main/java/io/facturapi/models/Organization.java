package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization {
  private String id;
  private Instant createdAt;
  private String plan;
  private List<String> addOns = new ArrayList<>();
  @JsonProperty("is_production_ready")
  private Boolean productionReady;
  private List<CompletionStep> pendingSteps = new ArrayList<>();
  private String logoUrl;
  private String domain;
  private String customDomain;
  private String timezone;
  private Legal legal;
  private Customization customization;
  private Certificate certificate;
  private Certificate fiel;
  private ReceiptSettings receipts;
  private SelfInvoiceSettings selfInvoice;
  private PendingPlanUpdate pendingPlanUpdate;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
  public String getPlan() { return plan; }
  public void setPlan(String plan) { this.plan = plan; }
  public List<String> getAddOns() { return addOns; }
  public void setAddOns(List<String> addOns) { this.addOns = addOns; }
  public Boolean getProductionReady() { return productionReady; }
  public void setProductionReady(Boolean productionReady) { this.productionReady = productionReady; }
  public List<CompletionStep> getPendingSteps() { return pendingSteps; }
  public void setPendingSteps(List<CompletionStep> pendingSteps) { this.pendingSteps = pendingSteps; }
  public String getLogoUrl() { return logoUrl; }
  public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }
  public String getDomain() { return domain; }
  public void setDomain(String domain) { this.domain = domain; }
  public String getCustomDomain() { return customDomain; }
  public void setCustomDomain(String customDomain) { this.customDomain = customDomain; }
  public String getTimezone() { return timezone; }
  public void setTimezone(String timezone) { this.timezone = timezone; }
  public Legal getLegal() { return legal; }
  public void setLegal(Legal legal) { this.legal = legal; }
  public Customization getCustomization() { return customization; }
  public void setCustomization(Customization customization) { this.customization = customization; }
  public Certificate getCertificate() { return certificate; }
  public void setCertificate(Certificate certificate) { this.certificate = certificate; }
  public Certificate getFiel() { return fiel; }
  public void setFiel(Certificate fiel) { this.fiel = fiel; }
  public ReceiptSettings getReceipts() { return receipts; }
  public void setReceipts(ReceiptSettings receipts) { this.receipts = receipts; }
  public SelfInvoiceSettings getSelfInvoice() { return selfInvoice; }
  public void setSelfInvoice(SelfInvoiceSettings selfInvoice) { this.selfInvoice = selfInvoice; }
  public PendingPlanUpdate getPendingPlanUpdate() { return pendingPlanUpdate; }
  public void setPendingPlanUpdate(PendingPlanUpdate pendingPlanUpdate) { this.pendingPlanUpdate = pendingPlanUpdate; }
}
