package io.facturapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InvoiceStatus {
  PENDING,
  VALID,
  CANCELED,
  DRAFT;

  @JsonValue
  public String value() {
    return name().toLowerCase();
  }

  @JsonCreator
  public static InvoiceStatus fromValue(String value) {
    return InvoiceStatus.valueOf(value.toUpperCase());
  }
}
