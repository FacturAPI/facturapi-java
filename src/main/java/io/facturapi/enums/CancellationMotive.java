package io.facturapi.enums;

public enum CancellationMotive {
  ERRORES_CON_RELACION("01"),
  ERRORES_SIN_RELACION("02"),
  NO_SE_CONCRETO("03"),
  FACTURA_GLOBAL("04");

  private final String value;

  CancellationMotive(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
