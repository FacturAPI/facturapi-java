package io.facturapi.models.complements.carta_porte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaPorteCarroFerroviario {
  @JsonProperty("TipoCarro")
  private String tipoCarro;
  @JsonProperty("MatriculaCarro")
  private String matriculaCarro;
  @JsonProperty("GuiaCarro")
  private String guiaCarro;
  @JsonProperty("ToneladasNetasCarro")
  private Double toneladasNetasCarro;
  @JsonProperty("Contenedor")
  private List<CartaPorteContenedorFerroviario> contenedor = new ArrayList<>();

  public String getTipoCarro() { return tipoCarro; }
  public void setTipoCarro(String tipoCarro) { this.tipoCarro = tipoCarro; }
  public String getMatriculaCarro() { return matriculaCarro; }
  public void setMatriculaCarro(String matriculaCarro) { this.matriculaCarro = matriculaCarro; }
  public String getGuiaCarro() { return guiaCarro; }
  public void setGuiaCarro(String guiaCarro) { this.guiaCarro = guiaCarro; }
  public Double getToneladasNetasCarro() { return toneladasNetasCarro; }
  public void setToneladasNetasCarro(Double toneladasNetasCarro) { this.toneladasNetasCarro = toneladasNetasCarro; }
  public List<CartaPorteContenedorFerroviario> getContenedor() { return contenedor; }
  public void setContenedor(List<CartaPorteContenedorFerroviario> contenedor) { this.contenedor = contenedor; }
}
