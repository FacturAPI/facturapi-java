package com.facturapi.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public class ProductsResource extends BaseResource {
  public ProductsResource(FacturapiHttpClient client) {
    super(client);
  }

  public JsonNode create(Object data) {
    return post("/products", data, null);
  }

  public JsonNode list(Map<String, ?> params) {
    return get("/products", params);
  }

  public JsonNode all(Map<String, ?> params) {
    return list(params);
  }

  public JsonNode retrieve(String id) {
    return get("/products/" + id, null);
  }

  public JsonNode update(String id, Object data) {
    return put("/products/" + id, data, null);
  }

  public JsonNode delete(String id) {
    return delete("/products/" + id, null);
  }

  public JsonNode del(String id) {
    return delete(id);
  }
}
