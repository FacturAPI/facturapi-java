package com.facturapi;

public enum ApiVersion {
  V1("v1"),
  V2("v2");

  private final String value;

  ApiVersion(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static ApiVersion fromString(String raw) {
    if (raw == null) {
      return V2;
    }
    String normalized = raw.trim().toLowerCase();
    if ("v1".equals(normalized)) {
      return V1;
    }
    if ("v2".equals(normalized)) {
      return V2;
    }
    throw new IllegalArgumentException("Invalid API version. Valid values are: v1, v2");
  }
}
