package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteTransporteMaritimo {
  @JsonProperty("PermSCT")
  private String permSct;
  @JsonProperty("NumPermisoSCT")
  private String numPermisoSct;
  @JsonProperty("NombreAseg")
  private String nombreAseg;
  @JsonProperty("NumPolizaSeguro")
  private String numPolizaSeguro;
  @JsonProperty("TipoEmbarcacion")
  private String tipoEmbarcacion;
  @JsonProperty("Matricula")
  private String matricula;
  @JsonProperty("NumeroOMI")
  private String numeroOmi;
  @JsonProperty("AnioEmbarcacion")
  private String anioEmbarcacion;
  @JsonProperty("NombreEmbarc")
  private String nombreEmbarc;
  @JsonProperty("NacionalidadEmbarc")
  private String nacionalidadEmbarc;
  @JsonProperty("UnidadesDeArqBruto")
  private Double unidadesDeArqBruto;
  @JsonProperty("TipoCarga")
  private String tipoCarga;
  @JsonProperty("Eslora")
  private Double eslora;
  @JsonProperty("Manga")
  private Double manga;
  @JsonProperty("Calado")
  private Double calado;
  @JsonProperty("Puntal")
  private Double puntal;
  @JsonProperty("LineaNaviera")
  private String lineaNaviera;
  @JsonProperty("NombreAgenteNaviero")
  private String nombreAgenteNaviero;
  @JsonProperty("NumAutorizacionNaviero")
  private String numAutorizacionNaviero;
  @JsonProperty("NumViaje")
  private String numViaje;
  @JsonProperty("NumConocEmbarc")
  private String numConocEmbarc;
  @JsonProperty("PermisoTempNavegacion")
  private String permisoTempNavegacion;
  @JsonProperty("Contenedor")
  private List<CartaPorteContenedorMaritimo> contenedor = new ArrayList<>();

  public String getPermSct() { return permSct; }
  public void setPermSct(String permSct) { this.permSct = permSct; }
  public String getNumPermisoSct() { return numPermisoSct; }
  public void setNumPermisoSct(String numPermisoSct) { this.numPermisoSct = numPermisoSct; }
  public String getNombreAseg() { return nombreAseg; }
  public void setNombreAseg(String nombreAseg) { this.nombreAseg = nombreAseg; }
  public String getNumPolizaSeguro() { return numPolizaSeguro; }
  public void setNumPolizaSeguro(String numPolizaSeguro) { this.numPolizaSeguro = numPolizaSeguro; }
  public String getTipoEmbarcacion() { return tipoEmbarcacion; }
  public void setTipoEmbarcacion(String tipoEmbarcacion) { this.tipoEmbarcacion = tipoEmbarcacion; }
  public String getMatricula() { return matricula; }
  public void setMatricula(String matricula) { this.matricula = matricula; }
  public String getNumeroOmi() { return numeroOmi; }
  public void setNumeroOmi(String numeroOmi) { this.numeroOmi = numeroOmi; }
  public String getAnioEmbarcacion() { return anioEmbarcacion; }
  public void setAnioEmbarcacion(String anioEmbarcacion) { this.anioEmbarcacion = anioEmbarcacion; }
  public String getNombreEmbarc() { return nombreEmbarc; }
  public void setNombreEmbarc(String nombreEmbarc) { this.nombreEmbarc = nombreEmbarc; }
  public String getNacionalidadEmbarc() { return nacionalidadEmbarc; }
  public void setNacionalidadEmbarc(String nacionalidadEmbarc) { this.nacionalidadEmbarc = nacionalidadEmbarc; }
  public Double getUnidadesDeArqBruto() { return unidadesDeArqBruto; }
  public void setUnidadesDeArqBruto(Double unidadesDeArqBruto) { this.unidadesDeArqBruto = unidadesDeArqBruto; }
  public String getTipoCarga() { return tipoCarga; }
  public void setTipoCarga(String tipoCarga) { this.tipoCarga = tipoCarga; }
  public Double getEslora() { return eslora; }
  public void setEslora(Double eslora) { this.eslora = eslora; }
  public Double getManga() { return manga; }
  public void setManga(Double manga) { this.manga = manga; }
  public Double getCalado() { return calado; }
  public void setCalado(Double calado) { this.calado = calado; }
  public Double getPuntal() { return puntal; }
  public void setPuntal(Double puntal) { this.puntal = puntal; }
  public String getLineaNaviera() { return lineaNaviera; }
  public void setLineaNaviera(String lineaNaviera) { this.lineaNaviera = lineaNaviera; }
  public String getNombreAgenteNaviero() { return nombreAgenteNaviero; }
  public void setNombreAgenteNaviero(String nombreAgenteNaviero) { this.nombreAgenteNaviero = nombreAgenteNaviero; }
  public String getNumAutorizacionNaviero() { return numAutorizacionNaviero; }
  public void setNumAutorizacionNaviero(String numAutorizacionNaviero) { this.numAutorizacionNaviero = numAutorizacionNaviero; }
  public String getNumViaje() { return numViaje; }
  public void setNumViaje(String numViaje) { this.numViaje = numViaje; }
  public String getNumConocEmbarc() { return numConocEmbarc; }
  public void setNumConocEmbarc(String numConocEmbarc) { this.numConocEmbarc = numConocEmbarc; }
  public String getPermisoTempNavegacion() { return permisoTempNavegacion; }
  public void setPermisoTempNavegacion(String permisoTempNavegacion) { this.permisoTempNavegacion = permisoTempNavegacion; }
  public List<CartaPorteContenedorMaritimo> getContenedor() { return contenedor; }
  public void setContenedor(List<CartaPorteContenedorMaritimo> contenedor) { this.contenedor = contenedor; }
}
