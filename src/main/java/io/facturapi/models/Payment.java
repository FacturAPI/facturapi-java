package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.facturapi.enums.PaymentForm;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {
  private PaymentForm paymentForm;
  private String currency;
  private Double exchange;
  private Instant date;
  private List<PaymentRelated> related = new ArrayList<>();

  public PaymentForm getPaymentForm() { return paymentForm; }
  public void setPaymentForm(PaymentForm paymentForm) { this.paymentForm = paymentForm; }
  public String getCurrency() { return currency; }
  public void setCurrency(String currency) { this.currency = currency; }
  public Double getExchange() { return exchange; }
  public void setExchange(Double exchange) { this.exchange = exchange; }
  public Instant getDate() { return date; }
  public void setDate(Instant date) { this.date = date; }
  public List<PaymentRelated> getRelated() { return related; }
  public void setRelated(List<PaymentRelated> related) { this.related = related; }
}
