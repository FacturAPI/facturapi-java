package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaPercepciones {
  @JsonProperty("percepcion")
  private List<NominaPercepcion> percepcion = new ArrayList<>();
  @JsonProperty("jubilacion_pension_retiro")
  private NominaJubilacion jubilacionPensionRetiro;
  @JsonProperty("separacion_indemnizacion")
  private NominaSeparacion separacionIndemnizacion;

  public List<NominaPercepcion> getPercepcion() { return percepcion; }
  public void setPercepcion(List<NominaPercepcion> percepcion) { this.percepcion = percepcion; }
  public NominaJubilacion getJubilacionPensionRetiro() { return jubilacionPensionRetiro; }
  public void setJubilacionPensionRetiro(NominaJubilacion jubilacionPensionRetiro) { this.jubilacionPensionRetiro = jubilacionPensionRetiro; }
  public NominaSeparacion getSeparacionIndemnizacion() { return separacionIndemnizacion; }
  public void setSeparacionIndemnizacion(NominaSeparacion separacionIndemnizacion) { this.separacionIndemnizacion = separacionIndemnizacion; }
}
