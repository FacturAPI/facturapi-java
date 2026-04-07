package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customization {
  private String color;
  private PdfExtra pdfExtra;
  private Map<String, String> defaultSeries = new HashMap<>();
  private Boolean hasLogo;

  public String getColor() { return color; }
  public void setColor(String color) { this.color = color; }
  public PdfExtra getPdfExtra() { return pdfExtra; }
  public void setPdfExtra(PdfExtra pdfExtra) { this.pdfExtra = pdfExtra; }
  public Map<String, String> getDefaultSeries() { return defaultSeries; }
  public void setDefaultSeries(Map<String, String> defaultSeries) { this.defaultSeries = defaultSeries; }
  public Boolean getHasLogo() { return hasLogo; }
  public void setHasLogo(Boolean hasLogo) { this.hasLogo = hasLogo; }
}
