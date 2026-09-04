package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

/**
 * Related document summary for a payment complement (complemento de pago).
 * Ready to be used as an element of the complement's related documents.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentSummary {
  private String uuid;
  private Integer folioNumber;
  private String series;
  private Integer installment;
  private Double lastBalance;
  private Double total;
  private String currency;
  private Double amount;
  private List<PaymentSummaryTax> taxes = new ArrayList<>();

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public Integer getFolioNumber() {
    return folioNumber;
  }

  public void setFolioNumber(Integer folioNumber) {
    this.folioNumber = folioNumber;
  }

  public String getSeries() {
    return series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  public Integer getInstallment() {
    return installment;
  }

  public void setInstallment(Integer installment) {
    this.installment = installment;
  }

  public Double getLastBalance() {
    return lastBalance;
  }

  public void setLastBalance(Double lastBalance) {
    this.lastBalance = lastBalance;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public List<PaymentSummaryTax> getTaxes() {
    return taxes;
  }

  public void setTaxes(List<PaymentSummaryTax> taxes) {
    this.taxes = taxes;
  }

  /** Prorated tax breakdown for the paid amount. */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class PaymentSummaryTax {
    private Double base;
    private Double rate;
    private String type;
    private String factor;
    private Boolean withholding;

    public Double getBase() {
      return base;
    }

    public void setBase(Double base) {
      this.base = base;
    }

    public Double getRate() {
      return rate;
    }

    public void setRate(Double rate) {
      this.rate = rate;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getFactor() {
      return factor;
    }

    public void setFactor(String factor) {
      this.factor = factor;
    }

    public Boolean getWithholding() {
      return withholding;
    }

    public void setWithholding(Boolean withholding) {
      this.withholding = withholding;
    }
  }
}
