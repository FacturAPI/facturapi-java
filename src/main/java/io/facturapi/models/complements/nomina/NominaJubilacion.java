package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaJubilacion {
  @JsonProperty("total_una_exhibicion")
  private Double totalUnaExhibicion;
  @JsonProperty("total_parcialidad")
  private Double totalParcialidad;
  @JsonProperty("monto_diario")
  private Double montoDiario;
  @JsonProperty("ingreso_acumulable")
  private Double ingresoAcumulable;
  @JsonProperty("ingreso_no_acumulable")
  private Double ingresoNoAcumulable;

  public Double getTotalUnaExhibicion() { return totalUnaExhibicion; }
  public void setTotalUnaExhibicion(Double totalUnaExhibicion) { this.totalUnaExhibicion = totalUnaExhibicion; }
  public Double getTotalParcialidad() { return totalParcialidad; }
  public void setTotalParcialidad(Double totalParcialidad) { this.totalParcialidad = totalParcialidad; }
  public Double getMontoDiario() { return montoDiario; }
  public void setMontoDiario(Double montoDiario) { this.montoDiario = montoDiario; }
  public Double getIngresoAcumulable() { return ingresoAcumulable; }
  public void setIngresoAcumulable(Double ingresoAcumulable) { this.ingresoAcumulable = ingresoAcumulable; }
  public Double getIngresoNoAcumulable() { return ingresoNoAcumulable; }
  public void setIngresoNoAcumulable(Double ingresoNoAcumulable) { this.ingresoNoAcumulable = ingresoNoAcumulable; }
}
