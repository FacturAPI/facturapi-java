package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentRelated {
  private String uuid;
  private Integer installment;
  private Double lastBalance;
  private Double amount;
  private String currency;
  private Double exchange;

  public String getUuid() { return uuid; }
  public void setUuid(String uuid) { this.uuid = uuid; }
  public Integer getInstallment() { return installment; }
  public void setInstallment(Integer installment) { this.installment = installment; }
  public Double getLastBalance() { return lastBalance; }
  public void setLastBalance(Double lastBalance) { this.lastBalance = lastBalance; }
  public Double getAmount() { return amount; }
  public void setAmount(Double amount) { this.amount = amount; }
  public String getCurrency() { return currency; }
  public void setCurrency(String currency) { this.currency = currency; }
  public Double getExchange() { return exchange; }
  public void setExchange(Double exchange) { this.exchange = exchange; }
}
