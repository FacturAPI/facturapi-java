package io.facturapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

  @JsonValue
  public String value() {
    return value;
  }

  @JsonCreator
  public static InvoiceType fromValue(String value) {
    for (InvoiceType item : values()) {
      if (item.value.equals(value)) {
        return item;
      }
    }
    throw new IllegalArgumentException("Unknown invoice type: " + value);
  }
}
