package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteMercancia {
  @JsonProperty("BienesTransp")
  private String bienesTransp;
  @JsonProperty("ClaveSTCC")
  private String claveStcc;
  @JsonProperty("Descripcion")
  private String descripcion;
  @JsonProperty("Cantidad")
  private Double cantidad;
  @JsonProperty("ClaveUnidad")
  private String claveUnidad;
  @JsonProperty("Unidad")
  private String unidad;
  @JsonProperty("Dimensiones")
  private String dimensiones;
  @JsonProperty("MaterialPeligroso")
  private String materialPeligroso;
  @JsonProperty("CveMaterialPeligroso")
  private String cveMaterialPeligroso;
  @JsonProperty("Embalaje")
  private String embalaje;
  @JsonProperty("DescripEmbalaje")
  private String descripEmbalaje;
  @JsonProperty("SectorCOFEPRIS")
  private String sectorCofepris;
  @JsonProperty("NombreIngredienteActivo")
  private String nombreIngredienteActivo;
  @JsonProperty("NomQuimico")
  private String nomQuimico;
  @JsonProperty("DenominacionGenericaProd")
  private String denominacionGenericaProd;
  @JsonProperty("DenominacionDistintivaProd")
  private String denominacionDistintivaProd;
  @JsonProperty("Fabricante")
  private String fabricante;
  @JsonProperty("FechaCaducidad")
  private String fechaCaducidad;
  @JsonProperty("LoteMedicamento")
  private String loteMedicamento;
  @JsonProperty("FormaFarmaceutica")
  private String formaFarmaceutica;
  @JsonProperty("CondicionesEspTransp")
  private String condicionesEspTransp;
  @JsonProperty("RegistroSanitarioFolioAutorizacion")
  private String registroSanitarioFolioAutorizacion;
  @JsonProperty("PermisoImportacion")
  private String permisoImportacion;
  @JsonProperty("FolioImpoVUCEM")
  private String folioImpoVucem;
  @JsonProperty("NumCAS")
  private String numCas;
  @JsonProperty("RazonSocialEmpImp")
  private String razonSocialEmpImp;
  @JsonProperty("NumRegSanPlagCOFEPRIS")
  private String numRegSanPlagCofepris;
  @JsonProperty("DatosFabricante")
  private String datosFabricante;
  @JsonProperty("DatosFormulador")
  private String datosFormulador;
  @JsonProperty("DatosMaquilador")
  private String datosMaquilador;
  @JsonProperty("UsoAutorizado")
  private String usoAutorizado;
  @JsonProperty("PesoEnKg")
  private Double pesoEnKg;
  @JsonProperty("ValorMercancia")
  private Double valorMercancia;
  @JsonProperty("Moneda")
  private String moneda;
  @JsonProperty("FraccionArancelaria")
  private String fraccionArancelaria;
  @JsonProperty("UUIDComercioExt")
  private String uuidComercioExt;
  @JsonProperty("TipoMateria")
  private String tipoMateria;
  @JsonProperty("DescripcionMateria")
  private String descripcionMateria;
  @JsonProperty("DocumentacionAduanera")
  private List<CartaPorteDocumentacionAduanera> documentacionAduanera = new ArrayList<>();
  @JsonProperty("GuiasIdentificacion")
  private List<CartaPorteGuiaIdentificacion> guiasIdentificacion = new ArrayList<>();
  @JsonProperty("CantidadTransporta")
  private List<CartaPorteCantidadTransporta> cantidadTransporta = new ArrayList<>();
  @JsonProperty("DetalleMercancia")
  private List<CartaPorteDetalleMercancia> detalleMercancia = new ArrayList<>();

  public String getBienesTransp() { return bienesTransp; }
  public void setBienesTransp(String bienesTransp) { this.bienesTransp = bienesTransp; }
  public String getClaveStcc() { return claveStcc; }
  public void setClaveStcc(String claveStcc) { this.claveStcc = claveStcc; }
  public String getDescripcion() { return descripcion; }
  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
  public Double getCantidad() { return cantidad; }
  public void setCantidad(Double cantidad) { this.cantidad = cantidad; }
  public String getClaveUnidad() { return claveUnidad; }
  public void setClaveUnidad(String claveUnidad) { this.claveUnidad = claveUnidad; }
  public String getUnidad() { return unidad; }
  public void setUnidad(String unidad) { this.unidad = unidad; }
  public String getDimensiones() { return dimensiones; }
  public void setDimensiones(String dimensiones) { this.dimensiones = dimensiones; }
  public String getMaterialPeligroso() { return materialPeligroso; }
  public void setMaterialPeligroso(String materialPeligroso) { this.materialPeligroso = materialPeligroso; }
  public String getCveMaterialPeligroso() { return cveMaterialPeligroso; }
  public void setCveMaterialPeligroso(String cveMaterialPeligroso) { this.cveMaterialPeligroso = cveMaterialPeligroso; }
  public String getEmbalaje() { return embalaje; }
  public void setEmbalaje(String embalaje) { this.embalaje = embalaje; }
  public String getDescripEmbalaje() { return descripEmbalaje; }
  public void setDescripEmbalaje(String descripEmbalaje) { this.descripEmbalaje = descripEmbalaje; }
  public String getSectorCofepris() { return sectorCofepris; }
  public void setSectorCofepris(String sectorCofepris) { this.sectorCofepris = sectorCofepris; }
  public String getNombreIngredienteActivo() { return nombreIngredienteActivo; }
  public void setNombreIngredienteActivo(String nombreIngredienteActivo) { this.nombreIngredienteActivo = nombreIngredienteActivo; }
  public String getNomQuimico() { return nomQuimico; }
  public void setNomQuimico(String nomQuimico) { this.nomQuimico = nomQuimico; }
  public String getDenominacionGenericaProd() { return denominacionGenericaProd; }
  public void setDenominacionGenericaProd(String denominacionGenericaProd) { this.denominacionGenericaProd = denominacionGenericaProd; }
  public String getDenominacionDistintivaProd() { return denominacionDistintivaProd; }
  public void setDenominacionDistintivaProd(String denominacionDistintivaProd) { this.denominacionDistintivaProd = denominacionDistintivaProd; }
  public String getFabricante() { return fabricante; }
  public void setFabricante(String fabricante) { this.fabricante = fabricante; }
  public String getFechaCaducidad() { return fechaCaducidad; }
  public void setFechaCaducidad(String fechaCaducidad) { this.fechaCaducidad = fechaCaducidad; }
  public String getLoteMedicamento() { return loteMedicamento; }
  public void setLoteMedicamento(String loteMedicamento) { this.loteMedicamento = loteMedicamento; }
  public String getFormaFarmaceutica() { return formaFarmaceutica; }
  public void setFormaFarmaceutica(String formaFarmaceutica) { this.formaFarmaceutica = formaFarmaceutica; }
  public String getCondicionesEspTransp() { return condicionesEspTransp; }
  public void setCondicionesEspTransp(String condicionesEspTransp) { this.condicionesEspTransp = condicionesEspTransp; }
  public String getRegistroSanitarioFolioAutorizacion() { return registroSanitarioFolioAutorizacion; }
  public void setRegistroSanitarioFolioAutorizacion(String registroSanitarioFolioAutorizacion) { this.registroSanitarioFolioAutorizacion = registroSanitarioFolioAutorizacion; }
  public String getPermisoImportacion() { return permisoImportacion; }
  public void setPermisoImportacion(String permisoImportacion) { this.permisoImportacion = permisoImportacion; }
  public String getFolioImpoVucem() { return folioImpoVucem; }
  public void setFolioImpoVucem(String folioImpoVucem) { this.folioImpoVucem = folioImpoVucem; }
  public String getNumCas() { return numCas; }
  public void setNumCas(String numCas) { this.numCas = numCas; }
  public String getRazonSocialEmpImp() { return razonSocialEmpImp; }
  public void setRazonSocialEmpImp(String razonSocialEmpImp) { this.razonSocialEmpImp = razonSocialEmpImp; }
  public String getNumRegSanPlagCofepris() { return numRegSanPlagCofepris; }
  public void setNumRegSanPlagCofepris(String numRegSanPlagCofepris) { this.numRegSanPlagCofepris = numRegSanPlagCofepris; }
  public String getDatosFabricante() { return datosFabricante; }
  public void setDatosFabricante(String datosFabricante) { this.datosFabricante = datosFabricante; }
  public String getDatosFormulador() { return datosFormulador; }
  public void setDatosFormulador(String datosFormulador) { this.datosFormulador = datosFormulador; }
  public String getDatosMaquilador() { return datosMaquilador; }
  public void setDatosMaquilador(String datosMaquilador) { this.datosMaquilador = datosMaquilador; }
  public String getUsoAutorizado() { return usoAutorizado; }
  public void setUsoAutorizado(String usoAutorizado) { this.usoAutorizado = usoAutorizado; }
  public Double getPesoEnKg() { return pesoEnKg; }
  public void setPesoEnKg(Double pesoEnKg) { this.pesoEnKg = pesoEnKg; }
  public Double getValorMercancia() { return valorMercancia; }
  public void setValorMercancia(Double valorMercancia) { this.valorMercancia = valorMercancia; }
  public String getMoneda() { return moneda; }
  public void setMoneda(String moneda) { this.moneda = moneda; }
  public String getFraccionArancelaria() { return fraccionArancelaria; }
  public void setFraccionArancelaria(String fraccionArancelaria) { this.fraccionArancelaria = fraccionArancelaria; }
  public String getUuidComercioExt() { return uuidComercioExt; }
  public void setUuidComercioExt(String uuidComercioExt) { this.uuidComercioExt = uuidComercioExt; }
  public String getTipoMateria() { return tipoMateria; }
  public void setTipoMateria(String tipoMateria) { this.tipoMateria = tipoMateria; }
  public String getDescripcionMateria() { return descripcionMateria; }
  public void setDescripcionMateria(String descripcionMateria) { this.descripcionMateria = descripcionMateria; }
  public List<CartaPorteDocumentacionAduanera> getDocumentacionAduanera() { return documentacionAduanera; }
  public void setDocumentacionAduanera(List<CartaPorteDocumentacionAduanera> documentacionAduanera) { this.documentacionAduanera = documentacionAduanera; }
  public List<CartaPorteGuiaIdentificacion> getGuiasIdentificacion() { return guiasIdentificacion; }
  public void setGuiasIdentificacion(List<CartaPorteGuiaIdentificacion> guiasIdentificacion) { this.guiasIdentificacion = guiasIdentificacion; }
  public List<CartaPorteCantidadTransporta> getCantidadTransporta() { return cantidadTransporta; }
  public void setCantidadTransporta(List<CartaPorteCantidadTransporta> cantidadTransporta) { this.cantidadTransporta = cantidadTransporta; }
  public List<CartaPorteDetalleMercancia> getDetalleMercancia() { return detalleMercancia; }
  public void setDetalleMercancia(List<CartaPorteDetalleMercancia> detalleMercancia) { this.detalleMercancia = detalleMercancia; }
}
