package io.facturapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CancellationStatus {
  NONE,
  VERIFYING,
  PENDING,
  ACCEPTED,
  REJECTED,
  EXPIRED;

  @JsonValue
  public String value() {
    return name().toLowerCase();
  }

  @JsonCreator
  public static CancellationStatus fromValue(String value) {
    return CancellationStatus.valueOf(value.toUpperCase());
  }
}
