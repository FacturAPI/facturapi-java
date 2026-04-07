package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {
  @JsonAlias({"series", "name"})
  private String series;
  @JsonProperty("next_folio")
  private Integer nextFolio;
  @JsonProperty("next_folio_test")
  private Integer nextFolioTest;

  public String getSeries() { return series; }
  public void setSeries(String series) { this.series = series; }
  public Integer getNextFolio() { return nextFolio; }
  public void setNextFolio(Integer nextFolio) { this.nextFolio = nextFolio; }
  public Integer getNextFolioTest() { return nextFolioTest; }
  public void setNextFolioTest(Integer nextFolioTest) { this.nextFolioTest = nextFolioTest; }
}
