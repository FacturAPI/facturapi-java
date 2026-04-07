package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaPercepcion {
  private String tipoPercepcion;
  private String concepto;
  private String clave;
  private Double importeGravado;
  private Double importeExento;
  private NominaAcciones accionesOTitulos;
  private List<NominaHorasExtra> horasExtra = new ArrayList<>();

  public String getTipoPercepcion() { return tipoPercepcion; }
  public void setTipoPercepcion(String tipoPercepcion) { this.tipoPercepcion = tipoPercepcion; }
  public String getConcepto() { return concepto; }
  public void setConcepto(String concepto) { this.concepto = concepto; }
  public String getClave() { return clave; }
  public void setClave(String clave) { this.clave = clave; }
  public Double getImporteGravado() { return importeGravado; }
  public void setImporteGravado(Double importeGravado) { this.importeGravado = importeGravado; }
  public Double getImporteExento() { return importeExento; }
  public void setImporteExento(Double importeExento) { this.importeExento = importeExento; }
  public NominaAcciones getAccionesOTitulos() { return accionesOTitulos; }
  public void setAccionesOTitulos(NominaAcciones accionesOTitulos) { this.accionesOTitulos = accionesOTitulos; }
  public List<NominaHorasExtra> getHorasExtra() { return horasExtra; }
  public void setHorasExtra(List<NominaHorasExtra> horasExtra) { this.horasExtra = horasExtra; }
}
