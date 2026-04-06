package com.facturapi.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public class ReceiptsResource extends BaseResource {
  public ReceiptsResource(FacturapiHttpClient client) {
    super(client);
  }

  public JsonNode create(Object data) {
    return post("/receipts", data, null);
  }

  public JsonNode list(Map<String, ?> params) {
    return get("/receipts", params);
  }

  public JsonNode all(Map<String, ?> params) {
    return list(params);
  }

  public JsonNode retrieve(String id) {
    return get("/receipts/" + id, null);
  }

  public JsonNode invoice(String id, Object data) {
    return post("/receipts/" + id + "/invoice", data, null);
  }

  public JsonNode createGlobalInvoice(Object data) {
    return post("/receipts/global-invoice", data, null);
  }

  public JsonNode cancel(String id) {
    return delete("/receipts/" + id, null);
  }

  public JsonNode sendByEmail(String id, Map<String, ?> data) {
    return post("/receipts/" + id + "/email", data, null);
  }

  public byte[] downloadPdf(String id) {
    return client.getBytes("/receipts/" + id + "/pdf");
  }
}
