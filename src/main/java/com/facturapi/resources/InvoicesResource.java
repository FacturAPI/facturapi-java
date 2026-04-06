package com.facturapi.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public class InvoicesResource extends BaseResource {
  public InvoicesResource(FacturapiHttpClient client) {
    super(client);
  }

  public JsonNode create(Object body, Map<String, ?> params) {
    return post("/invoices", body, params);
  }

  public JsonNode list(Map<String, ?> params) {
    return get("/invoices", params);
  }

  public JsonNode all(Map<String, ?> params) {
    return list(params);
  }

  public JsonNode retrieve(String id) {
    return get("/invoices/" + id, null);
  }

  public JsonNode cancel(String id, Map<String, ?> params) {
    return delete("/invoices/" + id, params);
  }

  public JsonNode sendByEmail(String id, Map<String, ?> options) {
    return post("/invoices/" + id + "/email", options, null);
  }

  public byte[] downloadPdf(String id) {
    return client.getBytes("/invoices/" + id + "/pdf");
  }

  public byte[] downloadXml(String id) {
    return client.getBytes("/invoices/" + id + "/xml");
  }

  public byte[] downloadZip(String id) {
    return client.getBytes("/invoices/" + id + "/zip");
  }

  public byte[] downloadCancellationReceiptXml(String id) {
    return client.getBytes("/invoices/" + id + "/cancellation_receipt/xml");
  }

  public byte[] downloadCancellationReceiptPdf(String id) {
    return client.getBytes("/invoices/" + id + "/cancellation_receipt/pdf");
  }

  public JsonNode updateDraft(String id, Object data) {
    return put("/invoices/" + id, data, null);
  }

  public JsonNode stampDraft(String id, Map<String, ?> params) {
    return post("/invoices/" + id + "/stamp", null, params);
  }

  public JsonNode updateStatus(String id) {
    return put("/invoices/" + id + "/status", null, null);
  }

  public JsonNode copyToDraft(String id) {
    return post("/invoices/" + id + "/copy", null, null);
  }

  public byte[] previewPdf(Object body) {
    return client.postBytes("/invoices/preview/pdf", body);
  }
}
