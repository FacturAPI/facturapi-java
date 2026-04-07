package io.facturapi.enums;

public enum InvoiceType {
  INGRESO("I"),
  EGRESO("E"),
  TRASLADO("T"),
  NOMINA("N"),
  PAGO("P");

  private final String value;

  InvoiceType(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
