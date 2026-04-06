package com.facturapi.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public class ToolsResource {
  private final FacturapiHttpClient client;

  public ToolsResource(FacturapiHttpClient client) {
    this.client = client;
  }

  public JsonNode validateTaxId(String taxId) {
    return client.getJson("/tools/tax_id_validation", Map.of("tax_id", taxId));
  }
}
