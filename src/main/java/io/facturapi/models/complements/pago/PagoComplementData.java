package io.facturapi.models.complements.pago;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PagoComplementData {
  @JsonProperty("payment_form")
  private String paymentForm;
  private String date;
  @JsonProperty("related_documents")
  private List<PaymentRelatedDocument> relatedDocuments = new ArrayList<>();
  private String currency;
  private Double exchange;
  private String numOperacion;
  private String rfcEmisorCtaOrd;
  private String nomBancoOrdExt;
  private String ctaOrdenante;
  private String rfcEmisorCtaBen;
  private String ctaBeneficiario;
  private String tipoCadPago;
  private String certPago;
  private String cadPago;
  private String selloPago;

  public String getPaymentForm() { return paymentForm; }
  public void setPaymentForm(String paymentForm) { this.paymentForm = paymentForm; }
  public String getDate() { return date; }
  public void setDate(String date) { this.date = date; }
  public List<PaymentRelatedDocument> getRelatedDocuments() { return relatedDocuments; }
  public void setRelatedDocuments(List<PaymentRelatedDocument> relatedDocuments) { this.relatedDocuments = relatedDocuments; }
  public String getCurrency() { return currency; }
  public void setCurrency(String currency) { this.currency = currency; }
  public Double getExchange() { return exchange; }
  public void setExchange(Double exchange) { this.exchange = exchange; }
  public String getNumOperacion() { return numOperacion; }
  public void setNumOperacion(String numOperacion) { this.numOperacion = numOperacion; }
  public String getRfcEmisorCtaOrd() { return rfcEmisorCtaOrd; }
  public void setRfcEmisorCtaOrd(String rfcEmisorCtaOrd) { this.rfcEmisorCtaOrd = rfcEmisorCtaOrd; }
  public String getNomBancoOrdExt() { return nomBancoOrdExt; }
  public void setNomBancoOrdExt(String nomBancoOrdExt) { this.nomBancoOrdExt = nomBancoOrdExt; }
  public String getCtaOrdenante() { return ctaOrdenante; }
  public void setCtaOrdenante(String ctaOrdenante) { this.ctaOrdenante = ctaOrdenante; }
  public String getRfcEmisorCtaBen() { return rfcEmisorCtaBen; }
  public void setRfcEmisorCtaBen(String rfcEmisorCtaBen) { this.rfcEmisorCtaBen = rfcEmisorCtaBen; }
  public String getCtaBeneficiario() { return ctaBeneficiario; }
  public void setCtaBeneficiario(String ctaBeneficiario) { this.ctaBeneficiario = ctaBeneficiario; }
  public String getTipoCadPago() { return tipoCadPago; }
  public void setTipoCadPago(String tipoCadPago) { this.tipoCadPago = tipoCadPago; }
  public String getCertPago() { return certPago; }
  public void setCertPago(String certPago) { this.certPago = certPago; }
  public String getCadPago() { return cadPago; }
  public void setCadPago(String cadPago) { this.cadPago = cadPago; }
  public String getSelloPago() { return selloPago; }
  public void setSelloPago(String selloPago) { this.selloPago = selloPago; }
}
