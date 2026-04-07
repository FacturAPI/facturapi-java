package io.facturapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CancellationMotive {
  ERRORES_CON_RELACION("01"),
  ERRORES_SIN_RELACION("02"),
  NO_SE_CONCRETO("03"),
  FACTURA_GLOBAL("04");

  private final String value;

  CancellationMotive(String value) {
    this.value = value;
  }

  @JsonValue
  public String value() {
    return value;
  }

  @JsonCreator
  public static CancellationMotive fromValue(String value) {
    for (CancellationMotive item : values()) {
      if (item.value.equals(value)) {
        return item;
      }
    }
    throw new IllegalArgumentException("Unknown cancellation motive: " + value);
  }
}
