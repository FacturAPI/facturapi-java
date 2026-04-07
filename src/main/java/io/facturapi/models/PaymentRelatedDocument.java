package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRelatedDocument {
  private String uuid;
  private Double amount;
  private Integer installment;
  @JsonProperty("last_balance")
  private Double lastBalance;
  private String currency;
  private Double exchange;
  @JsonProperty("folio_number")
  private String folioNumber;
  private String series;
  private String taxability;
  private List<PaymentRelatedDocumentTax> taxes = new ArrayList<>();

  public String getUuid() { return uuid; }
  public void setUuid(String uuid) { this.uuid = uuid; }
  public Double getAmount() { return amount; }
  public void setAmount(Double amount) { this.amount = amount; }
  public Integer getInstallment() { return installment; }
  public void setInstallment(Integer installment) { this.installment = installment; }
  public Double getLastBalance() { return lastBalance; }
  public void setLastBalance(Double lastBalance) { this.lastBalance = lastBalance; }
  public String getCurrency() { return currency; }
  public void setCurrency(String currency) { this.currency = currency; }
  public Double getExchange() { return exchange; }
  public void setExchange(Double exchange) { this.exchange = exchange; }
  public String getFolioNumber() { return folioNumber; }
  public void setFolioNumber(String folioNumber) { this.folioNumber = folioNumber; }
  public String getSeries() { return series; }
  public void setSeries(String series) { this.series = series; }
  public String getTaxability() { return taxability; }
  public void setTaxability(String taxability) { this.taxability = taxability; }
  public List<PaymentRelatedDocumentTax> getTaxes() { return taxes; }
  public void setTaxes(List<PaymentRelatedDocumentTax> taxes) { this.taxes = taxes; }
}
