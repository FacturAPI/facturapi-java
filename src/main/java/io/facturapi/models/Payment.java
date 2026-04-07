package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {
  @JsonProperty("payment_form")
  private String paymentForm;
  private String currency;
  private Double exchange;
  private Instant date;
  private List<PaymentRelated> related = new ArrayList<>();

  public String getPaymentForm() { return paymentForm; }
  public void setPaymentForm(String paymentForm) { this.paymentForm = paymentForm; }
  public String getCurrency() { return currency; }
  public void setCurrency(String currency) { this.currency = currency; }
  public Double getExchange() { return exchange; }
  public void setExchange(Double exchange) { this.exchange = exchange; }
  public Instant getDate() { return date; }
  public void setDate(Instant date) { this.date = date; }
  public List<PaymentRelated> getRelated() { return related; }
  public void setRelated(List<PaymentRelated> related) { this.related = related; }
}
