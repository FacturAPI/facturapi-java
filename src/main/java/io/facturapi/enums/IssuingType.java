package io.facturapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IssuingType {
  ISSUING,
  RECEIVING;

  @JsonValue
  public String value() {
    return name().toLowerCase();
  }

  @JsonCreator
  public static IssuingType fromValue(String value) {
    return IssuingType.valueOf(value.toUpperCase());
  }
}
