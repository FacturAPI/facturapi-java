package io.facturapi.models.complements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.facturapi.models.complements.carta_porte.CartaPorteComplementData;
import io.facturapi.models.complements.comercio_exterior.ComercioExteriorComplementData;
import io.facturapi.models.complements.nomina.NominaComplementData;
import io.facturapi.models.complements.pago.PagoComplementData;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceComplement {
  private static final ObjectMapper MAPPER = new ObjectMapper()
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  private String type;
  @JsonIgnore
  private JsonNode rawData;
  @JsonIgnore
  private List<PagoComplementData> pagoData;
  @JsonIgnore
  private NominaComplementData nominaData;
  @JsonIgnore
  private CartaPorteComplementData cartaPorteData;
  @JsonIgnore
  private ComercioExteriorComplementData comercioExteriorData;
  @JsonIgnore
  private String customData;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
    parseRawData();
  }

  @JsonSetter("data")
  private void setRawData(JsonNode rawData) {
    this.rawData = rawData;
    parseRawData();
  }

  @JsonProperty("data")
  public Object getData() {
    if ("pago".equals(type)) {
      return pagoData;
    }
    if ("nomina".equals(type)) {
      return nominaData;
    }
    if ("custom".equals(type)) {
      return customData;
    }
    if ("carta_porte".equals(type)) {
      return cartaPorteData;
    }
    if ("comercio_exterior".equals(type)) {
      return comercioExteriorData;
    }
    if (pagoData != null) {
      return pagoData;
    }
    if (nominaData != null) {
      return nominaData;
    }
    if (cartaPorteData != null) {
      return cartaPorteData;
    }
    if (comercioExteriorData != null) {
      return comercioExteriorData;
    }
    return customData;
  }

  public List<PagoComplementData> getPagoData() {
    return pagoData;
  }

  public NominaComplementData getNominaData() {
    return nominaData;
  }

  public CartaPorteComplementData getCartaPorteData() {
    return cartaPorteData;
  }

  public ComercioExteriorComplementData getComercioExteriorData() {
    return comercioExteriorData;
  }

  public String getCustomData() {
    return customData;
  }

  private void parseRawData() {
    this.pagoData = null;
    this.nominaData = null;
    this.cartaPorteData = null;
    this.comercioExteriorData = null;
    this.customData = null;

    if (rawData == null || rawData.isNull()) {
      return;
    }

    try {
      if ("pago".equals(type) && rawData.isArray()) {
        this.pagoData = MAPPER.convertValue(rawData, new TypeReference<List<PagoComplementData>>() {});
        return;
      }
      if ("nomina".equals(type) && rawData.isObject()) {
        this.nominaData = MAPPER.convertValue(rawData, NominaComplementData.class);
        return;
      }
      if ("custom".equals(type) && rawData.isTextual()) {
        this.customData = rawData.asText();
        return;
      }
      if ("carta_porte".equals(type) && rawData.isObject()) {
        this.cartaPorteData = MAPPER.convertValue(rawData, CartaPorteComplementData.class);
        return;
      }
      if ("comercio_exterior".equals(type) && rawData.isObject()) {
        this.comercioExteriorData = MAPPER.convertValue(rawData, ComercioExteriorComplementData.class);
        return;
      }

      if (rawData.isArray()) {
        this.pagoData = MAPPER.convertValue(rawData, new TypeReference<List<PagoComplementData>>() {});
      } else if (rawData.isObject()) {
        if (rawData.has("IdCCP") || rawData.has("TranspInternac")) {
          this.cartaPorteData = MAPPER.convertValue(rawData, CartaPorteComplementData.class);
        } else if (rawData.has("ClaveDePedimento") || rawData.has("TipoCambioUSD") || rawData.has("TotalUSD")) {
          this.comercioExteriorData = MAPPER.convertValue(rawData, ComercioExteriorComplementData.class);
        } else {
          this.nominaData = MAPPER.convertValue(rawData, NominaComplementData.class);
        }
      } else if (rawData.isTextual()) {
        this.customData = rawData.asText();
      }
    } catch (IllegalArgumentException ignored) {
      // Keep null typed fields on malformed payloads.
    }
  }
}
