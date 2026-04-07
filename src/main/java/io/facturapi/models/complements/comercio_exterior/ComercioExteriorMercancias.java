package io.facturapi.models.complements.comercio_exterior;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComercioExteriorMercancias {
  @JsonProperty("Mercancia")
  private List<ComercioExteriorMercancia> mercancia = new ArrayList<>();

  public List<ComercioExteriorMercancia> getMercancia() { return mercancia; }
  public void setMercancia(List<ComercioExteriorMercancia> mercancia) { this.mercancia = mercancia; }
}
