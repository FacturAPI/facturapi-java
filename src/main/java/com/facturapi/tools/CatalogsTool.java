package com.facturapi.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public class CatalogsTool {
  private final FacturapiHttpClient client;

  public CatalogsTool(FacturapiHttpClient client) {
    this.client = client;
  }

  public JsonNode searchProducts(Map<String, ?> params) {
    return client.getJson("/catalogs/products", params);
  }

  public JsonNode searchUnits(Map<String, ?> params) {
    return client.getJson("/catalogs/units", params);
  }
}
