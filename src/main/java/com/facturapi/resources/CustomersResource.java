package com.facturapi.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public class CustomersResource extends BaseResource {
  public CustomersResource(FacturapiHttpClient client) {
    super(client);
  }

  public JsonNode create(Object data, Map<String, ?> params) {
    return post("/customers", data, params);
  }

  public JsonNode list(Map<String, ?> params) {
    return get("/customers", params);
  }

  // PHP-compatible alias
  public JsonNode all(Map<String, ?> params) {
    return list(params);
  }

  public JsonNode retrieve(String id) {
    return get("/customers/" + id, null);
  }

  public JsonNode update(String id, Object data, Map<String, ?> params) {
    return put("/customers/" + id, data, params);
  }

  public JsonNode delete(String id) {
    return delete("/customers/" + id, null);
  }

  // Node-compatible alias
  public JsonNode del(String id) {
    return delete(id);
  }

  public JsonNode validateTaxInfo(String id) {
    return get("/customers/" + id + "/tax-info-validation", null);
  }

  public JsonNode sendEditLinkByEmail(String id, String email) {
    return post("/customers/" + id + "/email-edit-link", Map.of("email", email), null);
  }
}
