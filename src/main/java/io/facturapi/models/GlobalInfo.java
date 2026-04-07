package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalInfo {
  private String periodicity;
  private String months;
  private Integer year;

  public String getPeriodicity() { return periodicity; }
  public void setPeriodicity(String periodicity) { this.periodicity = periodicity; }
  public String getMonths() { return months; }
  public void setMonths(String months) { this.months = months; }
  public Integer getYear() { return year; }
  public void setYear(Integer year) { this.year = year; }
}
