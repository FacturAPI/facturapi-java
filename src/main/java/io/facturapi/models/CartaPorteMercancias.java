package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteMercancias {
  @JsonProperty("PesoBrutoTotal")
  private Double pesoBrutoTotal;
  @JsonProperty("UnidadPeso")
  private String unidadPeso;
  @JsonProperty("PesoNetoTotal")
  private Double pesoNetoTotal;
  @JsonProperty("NumTotalMercancias")
  private Double numTotalMercancias;
  @JsonProperty("CargoPorTasacion")
  private Double cargoPorTasacion;
  @JsonProperty("LogisticaInversaRecoleccionDevolucion")
  private String logisticaInversaRecoleccionDevolucion;
  @JsonProperty("Mercancia")
  private List<CartaPorteMercancia> mercancia = new ArrayList<>();
  @JsonProperty("Autotransporte")
  private CartaPorteAutotransporte autotransporte;
  @JsonProperty("TransporteMaritimo")
  private CartaPorteTransporteMaritimo transporteMaritimo;
  @JsonProperty("TransporteAereo")
  private CartaPorteTransporteAereo transporteAereo;
  @JsonProperty("TransporteFerroviario")
  private CartaPorteTransporteFerroviario transporteFerroviario;

  public Double getPesoBrutoTotal() { return pesoBrutoTotal; }
  public void setPesoBrutoTotal(Double pesoBrutoTotal) { this.pesoBrutoTotal = pesoBrutoTotal; }
  public String getUnidadPeso() { return unidadPeso; }
  public void setUnidadPeso(String unidadPeso) { this.unidadPeso = unidadPeso; }
  public Double getPesoNetoTotal() { return pesoNetoTotal; }
  public void setPesoNetoTotal(Double pesoNetoTotal) { this.pesoNetoTotal = pesoNetoTotal; }
  public Double getNumTotalMercancias() { return numTotalMercancias; }
  public void setNumTotalMercancias(Double numTotalMercancias) { this.numTotalMercancias = numTotalMercancias; }
  public Double getCargoPorTasacion() { return cargoPorTasacion; }
  public void setCargoPorTasacion(Double cargoPorTasacion) { this.cargoPorTasacion = cargoPorTasacion; }
  public String getLogisticaInversaRecoleccionDevolucion() { return logisticaInversaRecoleccionDevolucion; }
  public void setLogisticaInversaRecoleccionDevolucion(String logisticaInversaRecoleccionDevolucion) { this.logisticaInversaRecoleccionDevolucion = logisticaInversaRecoleccionDevolucion; }
  public List<CartaPorteMercancia> getMercancia() { return mercancia; }
  public void setMercancia(List<CartaPorteMercancia> mercancia) { this.mercancia = mercancia; }
  public CartaPorteAutotransporte getAutotransporte() { return autotransporte; }
  public void setAutotransporte(CartaPorteAutotransporte autotransporte) { this.autotransporte = autotransporte; }
  public CartaPorteTransporteMaritimo getTransporteMaritimo() { return transporteMaritimo; }
  public void setTransporteMaritimo(CartaPorteTransporteMaritimo transporteMaritimo) { this.transporteMaritimo = transporteMaritimo; }
  public CartaPorteTransporteAereo getTransporteAereo() { return transporteAereo; }
  public void setTransporteAereo(CartaPorteTransporteAereo transporteAereo) { this.transporteAereo = transporteAereo; }
  public CartaPorteTransporteFerroviario getTransporteFerroviario() { return transporteFerroviario; }
  public void setTransporteFerroviario(CartaPorteTransporteFerroviario transporteFerroviario) { this.transporteFerroviario = transporteFerroviario; }
}
