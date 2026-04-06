package com.facturapi.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public abstract class BaseResource {
  protected final FacturapiHttpClient client;

  protected BaseResource(FacturapiHttpClient client) {
    this.client = client;
  }

  protected JsonNode get(String path, Map<String, ?> params) {
    return client.getJson(path, params);
  }

  protected JsonNode post(String path, Object body, Map<String, ?> params) {
    return client.postJson(path, body, params);
  }

  protected JsonNode put(String path, Object body, Map<String, ?> params) {
    return client.putJson(path, body, params);
  }

  protected JsonNode delete(String path, Map<String, ?> params) {
    return client.deleteJson(path, params);
  }
}
