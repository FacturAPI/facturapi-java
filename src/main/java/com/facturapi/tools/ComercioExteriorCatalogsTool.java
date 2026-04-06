package com.facturapi.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public class ComercioExteriorCatalogsTool {
  private final FacturapiHttpClient client;

  public ComercioExteriorCatalogsTool(FacturapiHttpClient client) {
    this.client = client;
  }

  public JsonNode searchTariffFractions(Map<String, ?> params) {
    return client.getJson("/catalogs/comercioexterior/2.0/tariff-fractions", params);
  }
}
