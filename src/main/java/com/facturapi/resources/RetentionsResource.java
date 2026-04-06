package com.facturapi.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public class RetentionsResource extends BaseResource {
  public RetentionsResource(FacturapiHttpClient client) {
    super(client);
  }

  public JsonNode create(Object data) {
    return post("/retentions", data, null);
  }

  public JsonNode list(Map<String, ?> params) {
    return get("/retentions", params);
  }

  public JsonNode all(Map<String, ?> params) {
    return list(params);
  }

  public JsonNode retrieve(String id) {
    return get("/retentions/" + id, null);
  }

  public JsonNode cancel(String id, Map<String, ?> params) {
    return delete("/retentions/" + id, params);
  }

  public JsonNode sendByEmail(String id, Map<String, ?> data) {
    return post("/retentions/" + id + "/email", data, null);
  }

  public byte[] downloadPdf(String id) {
    return client.getBytes("/retentions/" + id + "/pdf");
  }

  public byte[] downloadXml(String id) {
    return client.getBytes("/retentions/" + id + "/xml");
  }

  public byte[] downloadZip(String id) {
    return client.getBytes("/retentions/" + id + "/zip");
  }
}
