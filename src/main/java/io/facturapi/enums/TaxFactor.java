package io.facturapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TaxFactor {
  TASA("Tasa"),
  CUOTA("Cuota"),
  EXENTO("Exento");

  private final String value;

  TaxFactor(String value) {
    this.value = value;
  }

  @JsonValue
  public String value() {
    return value;
  }

  @JsonCreator
  public static TaxFactor fromValue(String value) {
    for (TaxFactor item : values()) {
      if (item.value.equals(value)) {
        return item;
      }
    }
    throw new IllegalArgumentException("Unknown tax factor: " + value);
  }
}
