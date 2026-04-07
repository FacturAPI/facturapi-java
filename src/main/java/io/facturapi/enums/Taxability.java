package io.facturapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Taxability {
  NOT_SUBJECT_TO_TAX("01"),
  SUBJECT_TO_TAX("02"),
  SUBJECT_TO_TAX_NOT_BREAKDOWN_REQUIRED("03"),
  SUBJECT_TO_TAX_NO_TAX_CAUSED("04"),
  SUBJECT_TO_TAX_VAT_CREDIT_PODEBI("05"),
  SUBJECT_TO_TAX_IVA_NO_TRANSFERRED("06"),
  NOT_SUBJECT_TO_TAX_IVA_BUT_IEPS_BREAKDOWN_REQUIRED("07"),
  NOT_SUBJECT_TO_TAX_IVA_AND_IEPS_BREAKDOWN_NOT_REQUIRED("08");

  private final String value;

  Taxability(String value) {
    this.value = value;
  }

  @JsonValue
  public String value() {
    return value;
  }

  @JsonCreator
  public static Taxability fromValue(String value) {
    for (Taxability item : values()) {
      if (item.value.equals(value)) {
        return item;
      }
    }
    throw new IllegalArgumentException("Unknown taxability: " + value);
  }
}
