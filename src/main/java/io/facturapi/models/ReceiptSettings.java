package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiptSettings {
  private String periodicity;
  @JsonProperty("duration_days")
  private Integer durationDays;
  @JsonProperty("next_folio_number")
  private Integer nextFolioNumber;
  @JsonProperty("next_folio_number_test")
  private Integer nextFolioNumberTest;

  public String getPeriodicity() { return periodicity; }
  public void setPeriodicity(String periodicity) { this.periodicity = periodicity; }
  public Integer getDurationDays() { return durationDays; }
  public void setDurationDays(Integer durationDays) { this.durationDays = durationDays; }
  public Integer getNextFolioNumber() { return nextFolioNumber; }
  public void setNextFolioNumber(Integer nextFolioNumber) { this.nextFolioNumber = nextFolioNumber; }
  public Integer getNextFolioNumberTest() { return nextFolioNumberTest; }
  public void setNextFolioNumberTest(Integer nextFolioNumberTest) { this.nextFolioNumberTest = nextFolioNumberTest; }
}
