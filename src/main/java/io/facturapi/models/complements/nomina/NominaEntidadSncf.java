package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaEntidadSncf {
  @JsonProperty("origen_recurso")
  private String origenRecurso;
  @JsonProperty("monto_recurso_propio")
  private Double montoRecursoPropio;

  public String getOrigenRecurso() { return origenRecurso; }
  public void setOrigenRecurso(String origenRecurso) { this.origenRecurso = origenRecurso; }
  public Double getMontoRecursoPropio() { return montoRecursoPropio; }
  public void setMontoRecursoPropio(Double montoRecursoPropio) { this.montoRecursoPropio = montoRecursoPropio; }
}
