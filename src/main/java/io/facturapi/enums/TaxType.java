package io.facturapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TaxType {
  IVA,
  IEPS,
  ISR;

  @JsonValue
  public String value() {
    return name();
  }

  @JsonCreator
  public static TaxType fromValue(String value) {
    return TaxType.valueOf(value);
  }
}
