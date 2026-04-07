package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaReceptor {
  private String curp;
  private String numSeguridadSocial;
  private LocalDate fechaInicioRelLaboral;
  private Object antiguedad;
  private String tipoContrato;
  private Boolean sindicalizado;
  private String tipoJornada;
  private String tipoRegimen;
  private String numEmpleado;
  private String departamento;
  private String puesto;
  private String riesgoPuesto;
  private String periodicidadPago;
  private String banco;
  private String nombreBanco;
  private String cuentaBancaria;
  private Double salarioBaseCotApor;
  private Double salarioDiarioIntegrado;
  private String claveEntFed;
  private List<NominaSubcontratacion> subContratacion = new ArrayList<>();

  public String getCurp() { return curp; }
  public void setCurp(String curp) { this.curp = curp; }
  public String getNumSeguridadSocial() { return numSeguridadSocial; }
  public void setNumSeguridadSocial(String numSeguridadSocial) { this.numSeguridadSocial = numSeguridadSocial; }
  public LocalDate getFechaInicioRelLaboral() { return fechaInicioRelLaboral; }
  public void setFechaInicioRelLaboral(LocalDate fechaInicioRelLaboral) { this.fechaInicioRelLaboral = fechaInicioRelLaboral; }
  public Object getAntiguedad() { return antiguedad; }
  public void setAntiguedad(Object antiguedad) { this.antiguedad = antiguedad; }
  public String getTipoContrato() { return tipoContrato; }
  public void setTipoContrato(String tipoContrato) { this.tipoContrato = tipoContrato; }
  public Boolean getSindicalizado() { return sindicalizado; }
  public void setSindicalizado(Boolean sindicalizado) { this.sindicalizado = sindicalizado; }
  public String getTipoJornada() { return tipoJornada; }
  public void setTipoJornada(String tipoJornada) { this.tipoJornada = tipoJornada; }
  public String getTipoRegimen() { return tipoRegimen; }
  public void setTipoRegimen(String tipoRegimen) { this.tipoRegimen = tipoRegimen; }
  public String getNumEmpleado() { return numEmpleado; }
  public void setNumEmpleado(String numEmpleado) { this.numEmpleado = numEmpleado; }
  public String getDepartamento() { return departamento; }
  public void setDepartamento(String departamento) { this.departamento = departamento; }
  public String getPuesto() { return puesto; }
  public void setPuesto(String puesto) { this.puesto = puesto; }
  public String getRiesgoPuesto() { return riesgoPuesto; }
  public void setRiesgoPuesto(String riesgoPuesto) { this.riesgoPuesto = riesgoPuesto; }
  public String getPeriodicidadPago() { return periodicidadPago; }
  public void setPeriodicidadPago(String periodicidadPago) { this.periodicidadPago = periodicidadPago; }
  public String getBanco() { return banco; }
  public void setBanco(String banco) { this.banco = banco; }
  public String getNombreBanco() { return nombreBanco; }
  public void setNombreBanco(String nombreBanco) { this.nombreBanco = nombreBanco; }
  public String getCuentaBancaria() { return cuentaBancaria; }
  public void setCuentaBancaria(String cuentaBancaria) { this.cuentaBancaria = cuentaBancaria; }
  public Double getSalarioBaseCotApor() { return salarioBaseCotApor; }
  public void setSalarioBaseCotApor(Double salarioBaseCotApor) { this.salarioBaseCotApor = salarioBaseCotApor; }
  public Double getSalarioDiarioIntegrado() { return salarioDiarioIntegrado; }
  public void setSalarioDiarioIntegrado(Double salarioDiarioIntegrado) { this.salarioDiarioIntegrado = salarioDiarioIntegrado; }
  public String getClaveEntFed() { return claveEntFed; }
  public void setClaveEntFed(String claveEntFed) { this.claveEntFed = claveEntFed; }
  public List<NominaSubcontratacion> getSubContratacion() { return subContratacion; }
  public void setSubContratacion(List<NominaSubcontratacion> subContratacion) { this.subContratacion = subContratacion; }
}
