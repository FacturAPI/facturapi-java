package io.facturapi.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.GenericResponse;
import io.facturapi.models.Invoice;
import io.facturapi.models.SearchResult;
import java.util.Map;

public class InvoicesResource extends BaseResource {
  /**
   * Invoice endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Invoices">API reference</a>
   */
  public InvoicesResource(FacturapiHttpClient client) {
    super(client);
  }

  /**
   * Creates a new valid invoice (CFDI).
   *
   * @param body Invoice payload.
   * @param params Optional query parameters.
   * @return Created invoice.
   * @see <a href="https://docs.facturapi.io/api#operation/createInvoice">API reference</a>
   */
  public Invoice create(Map<String, Object> body, Map<String, ?> params) {
    return post("/invoices", body, params, Invoice.class);
  }

  /**
   * Gets a paginated list of invoices created by your organization.
   *
   * @param params Search and pagination parameters.
   * @return Paginated invoice result.
   * @see <a href="https://docs.facturapi.io/api#operation/listInvoices">API reference</a>
   */
  public SearchResult<Invoice> list(Map<String, ?> params) {
    return get("/invoices", params, new TypeReference<SearchResult<Invoice>>() {});
  }

  /**
   * Gets a single invoice by id.
   *
   * @param id Invoice id.
   * @return Invoice object.
   * @see <a href="https://docs.facturapi.io/api#operation/getInvoice">API reference</a>
   */
  public Invoice retrieve(String id) {
    return get("/invoices/" + id, null, Invoice.class);
  }

  /**
   * Cancels an invoice.
   *
   * @param id Invoice id.
   * @param params Cancellation options.
   * @return Canceled invoice.
   * @see <a href="https://docs.facturapi.io/api#operation/cancelInvoice">API reference</a>
   */
  public Invoice cancel(String id, Map<String, ?> params) {
    return delete("/invoices/" + id, params, Invoice.class);
  }

  /**
   * Sends the invoice to the customer's email.
   *
   * @param id Invoice id.
   * @param options Email options.
   * @return Operation response.
   * @see <a href="https://docs.facturapi.io/api#operation/sendInvoiceByEmail">API reference</a>
   */
  public GenericResponse sendByEmail(String id, Map<String, Object> options) {
    return post("/invoices/" + id + "/email", options, null, GenericResponse.class);
  }

  /**
   * Downloads an invoice PDF file.
   *
   * @param id Invoice id.
   * @return PDF bytes.
   * @see <a href="https://docs.facturapi.io/api#operation/downloadInvoice">API reference</a>
   */
  public byte[] downloadPdf(String id) {
    return client.getBytes("/invoices/" + id + "/pdf");
  }

  /**
   * Downloads an invoice XML file.
   *
   * @param id Invoice id.
   * @return XML bytes.
   * @see <a href="https://docs.facturapi.io/api#operation/downloadInvoice">API reference</a>
   */
  public byte[] downloadXml(String id) {
    return client.getBytes("/invoices/" + id + "/xml");
  }

  /**
   * Downloads an invoice ZIP package with PDF and XML.
   *
   * @param id Invoice id.
   * @return ZIP bytes.
   * @see <a href="https://docs.facturapi.io/api#operation/downloadInvoice">API reference</a>
   */
  public byte[] downloadZip(String id) {
    return client.getBytes("/invoices/" + id + "/zip");
  }

  /**
   * Downloads the cancellation receipt XML file.
   *
   * @param id Invoice id.
   * @return XML bytes.
   * @see <a href="https://docs.facturapi.io/api#operation/downloadCancellationReceiptXml">API reference</a>
   */
  public byte[] downloadCancellationReceiptXml(String id) {
    return client.getBytes("/invoices/" + id + "/cancellation_receipt/xml");
  }

  /**
   * Downloads the cancellation receipt PDF file.
   *
   * @param id Invoice id.
   * @return PDF bytes.
   * @see <a href="https://docs.facturapi.io/api#operation/downloadCancellationReceiptXml">API reference</a>
   */
  public byte[] downloadCancellationReceiptPdf(String id) {
    return client.getBytes("/invoices/" + id + "/cancellation_receipt/pdf");
  }

  /**
   * Updates a draft invoice.
   *
   * @param id Invoice id.
   * @param data Invoice updates.
   * @return Updated draft invoice.
   * @see <a href="https://docs.facturapi.io/api#operation/updateDraftInvoice">API reference</a>
   */
  public Invoice updateDraft(String id, Map<String, Object> data) {
    return put("/invoices/" + id, data, null, Invoice.class);
  }

  /**
   * Stamps an existing draft invoice.
   *
   * @param id Invoice id.
   * @param params Optional query parameters.
   * @return Stamped invoice.
   * @see <a href="https://docs.facturapi.io/api#operation/stampDraftInvoice">API reference</a>
   */
  public Invoice stampDraft(String id, Map<String, ?> params) {
    return post("/invoices/" + id + "/stamp", null, params, Invoice.class);
  }

  /**
   * Refreshes invoice status from SAT.
   *
   * @param id Invoice id.
   * @return Updated invoice.
   * @see <a href="https://docs.facturapi.io/api#operation/updateInvoiceStatus">API reference</a>
   */
  public Invoice updateStatus(String id) {
    return put("/invoices/" + id + "/status", null, null, Invoice.class);
  }

  /**
   * Creates a draft copy from an existing invoice.
   *
   * @param id Invoice id.
   * @return Draft invoice.
   * @see <a href="https://docs.facturapi.io/api#operation/copyToDraftInvoice">API reference</a>
   */
  public Invoice copyToDraft(String id) {
    return post("/invoices/" + id + "/copy", null, null, Invoice.class);
  }

  /**
   * Generates a PDF preview for invoice payload before stamping.
   *
   * @param body Invoice payload.
   * @return PDF bytes.
   * @see <a href="https://docs.facturapi.io/api#operation/previewInvoicePdf">API reference</a>
   */
  public byte[] previewPdf(Map<String, Object> body) {
    return client.postBytes("/invoices/preview/pdf", body);
  }
}
