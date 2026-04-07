package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RetentionPeriod {
  @JsonProperty("mes_ini")
  private Integer mesIni;
  @JsonProperty("mes_fin")
  private Integer mesFin;
  private Integer ejerc;

  public Integer getMesIni() { return mesIni; }
  public void setMesIni(Integer mesIni) { this.mesIni = mesIni; }
  public Integer getMesFin() { return mesFin; }
  public void setMesFin(Integer mesFin) { this.mesFin = mesFin; }
  public Integer getEjerc() { return ejerc; }
  public void setEjerc(Integer ejerc) { this.ejerc = ejerc; }
}
