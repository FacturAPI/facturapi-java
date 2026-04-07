package io.facturapi.models.complements.comercio_exterior;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComercioExteriorDestinatarioRef {
  private String id;
  @JsonProperty("Domicilio")
  private List<ComercioExteriorDomicilio> domicilio = new ArrayList<>();
  @JsonProperty("NumRegIdTrib")
  private String numRegIdTrib;
  @JsonProperty("Nombre")
  private String nombre;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public List<ComercioExteriorDomicilio> getDomicilio() { return domicilio; }
  public void setDomicilio(List<ComercioExteriorDomicilio> domicilio) { this.domicilio = domicilio; }
  public String getNumRegIdTrib() { return numRegIdTrib; }
  public void setNumRegIdTrib(String numRegIdTrib) { this.numRegIdTrib = numRegIdTrib; }
  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
}
