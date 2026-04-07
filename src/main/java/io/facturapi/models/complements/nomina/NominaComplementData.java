package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaComplementData {
  private LocalDate fechaInicialPago;
  private LocalDate fechaFinalPago;
  private NominaPercepciones percepciones;
  private List<NominaDeduccion> deducciones = new ArrayList<>();
  private List<NominaOtroPago> otrosPagos = new ArrayList<>();
  private List<NominaIncapacidad> incapacidades = new ArrayList<>();
  private NominaEmisor emisor;
  private NominaReceptor receptor;
  private String tipoNomina;
  private LocalDate fechaPago;
  private Double numDiasPagados;

  public LocalDate getFechaInicialPago() { return fechaInicialPago; }
  public void setFechaInicialPago(LocalDate fechaInicialPago) { this.fechaInicialPago = fechaInicialPago; }
  public LocalDate getFechaFinalPago() { return fechaFinalPago; }
  public void setFechaFinalPago(LocalDate fechaFinalPago) { this.fechaFinalPago = fechaFinalPago; }
  public NominaPercepciones getPercepciones() { return percepciones; }
  public void setPercepciones(NominaPercepciones percepciones) { this.percepciones = percepciones; }
  public List<NominaDeduccion> getDeducciones() { return deducciones; }
  public void setDeducciones(List<NominaDeduccion> deducciones) { this.deducciones = deducciones; }
  public List<NominaOtroPago> getOtrosPagos() { return otrosPagos; }
  public void setOtrosPagos(List<NominaOtroPago> otrosPagos) { this.otrosPagos = otrosPagos; }
  public List<NominaIncapacidad> getIncapacidades() { return incapacidades; }
  public void setIncapacidades(List<NominaIncapacidad> incapacidades) { this.incapacidades = incapacidades; }
  public NominaEmisor getEmisor() { return emisor; }
  public void setEmisor(NominaEmisor emisor) { this.emisor = emisor; }
  public NominaReceptor getReceptor() { return receptor; }
  public void setReceptor(NominaReceptor receptor) { this.receptor = receptor; }
  public String getTipoNomina() { return tipoNomina; }
  public void setTipoNomina(String tipoNomina) { this.tipoNomina = tipoNomina; }
  public LocalDate getFechaPago() { return fechaPago; }
  public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }
  public Double getNumDiasPagados() { return numDiasPagados; }
  public void setNumDiasPagados(Double numDiasPagados) { this.numDiasPagados = numDiasPagados; }
}
