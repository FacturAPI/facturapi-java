package com.facturapi.enums;

public enum PaymentForm {
  EFECTIVO("01"),
  CHEQUE_NOMINATIVO("02"),
  TRANSFERENCIA_ELECTRONICA_DE_FONDOS("03"),
  TARJETA_DE_CREDITO("04"),
  TARJETA_DE_DEBITO("28"),
  POR_DEFINIR("99");

  private final String value;

  PaymentForm(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
