package io.facturapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentMethod {
  PUE,
  PPD;

  @JsonValue
  public String value() {
    return name();
  }

  @JsonCreator
  public static PaymentMethod fromValue(String value) {
    return PaymentMethod.valueOf(value);
  }
}
