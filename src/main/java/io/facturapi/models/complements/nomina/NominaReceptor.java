package io.facturapi.models.complements.nomina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NominaReceptor {
  private String curp;
  @JsonProperty("num_seguridad_social")
  private String numSeguridadSocial;
  @JsonProperty("fecha_inicio_rel_laboral")
  private String fechaInicioRelLaboral;
  private Object antiguedad;
  @JsonProperty("tipo_contrato")
  private String tipoContrato;
  private Boolean sindicalizado;
  @JsonProperty("tipo_jornada")
  private String tipoJornada;
  @JsonProperty("tipo_regimen")
  private String tipoRegimen;
  @JsonProperty("num_empleado")
  private String numEmpleado;
  private String departamento;
  private String puesto;
  @JsonProperty("riesgo_puesto")
  private String riesgoPuesto;
  @JsonProperty("periodicidad_pago")
  private String periodicidadPago;
  private String banco;
  @JsonProperty("nombre_banco")
  private String nombreBanco;
  @JsonProperty("cuenta_bancaria")
  private String cuentaBancaria;
  @JsonProperty("salario_base_cot_apor")
  private Double salarioBaseCotApor;
  @JsonProperty("salario_diario_integrado")
  private Double salarioDiarioIntegrado;
  @JsonProperty("clave_ent_fed")
  private String claveEntFed;
  @JsonProperty("sub_contratacion")
  private List<NominaSubcontratacion> subContratacion = new ArrayList<>();

  public String getCurp() { return curp; }
  public void setCurp(String curp) { this.curp = curp; }
  public String getNumSeguridadSocial() { return numSeguridadSocial; }
  public void setNumSeguridadSocial(String numSeguridadSocial) { this.numSeguridadSocial = numSeguridadSocial; }
  public String getFechaInicioRelLaboral() { return fechaInicioRelLaboral; }
  public void setFechaInicioRelLaboral(String fechaInicioRelLaboral) { this.fechaInicioRelLaboral = fechaInicioRelLaboral; }
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
