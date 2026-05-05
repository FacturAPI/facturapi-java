package io.facturapi.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.GenericResponse;
import io.facturapi.models.Invoice;
import io.facturapi.models.Receipt;
import io.facturapi.models.SearchResult;
import java.io.InputStream;
import java.util.Map;

public class ReceiptsResource extends BaseResource {
  /**
   * Receipt endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Receipts">API reference</a>
   */
  public ReceiptsResource(FacturapiHttpClient client) {
    super(client);
  }

  /**
   * Creates a new receipt.
   *
   * @param data Receipt payload.
   * @return Created receipt.
   * @see <a href="https://docs.facturapi.io/api#operation/createReceipt">API reference</a>
   */
  public Receipt create(Map<String, Object> data) {
    return post("/receipts", data, null, Receipt.class);
  }

  /**
   * Gets a paginated list of receipts in your organization.
   *
   * @param params Search and pagination parameters.
   * @return Paginated receipt result.
   * @see <a href="https://docs.facturapi.io/api#operation/listReceipts">API reference</a>
   */
  public SearchResult<Receipt> list(Map<String, ?> params) {
    return get("/receipts", params, new TypeReference<SearchResult<Receipt>>() {});
  }

  /**
   * Gets a single receipt by id.
   *
   * @param id Receipt id.
   * @return Receipt object.
   * @see <a href="https://docs.facturapi.io/api#operation/getReceipt">API reference</a>
   */
  public Receipt retrieve(String id) {
    return get("/receipts/" + id, null, Receipt.class);
  }

  /**
   * Creates an invoice for a receipt.
   *
   * @param id Receipt id.
   * @param data Invoice payload.
   * @return Created invoice.
   * @see <a href="https://docs.facturapi.io/api#operation/invoiceReceipt">API reference</a>
   */
  public Invoice invoice(String id, Map<String, Object> data) {
    return post("/receipts/" + id + "/invoice", data, null, Invoice.class);
  }

  /**
   * Creates a global invoice for open receipts.
   *
   * @param data Global invoice payload.
   * @return Created invoice.
   * @see <a href="https://docs.facturapi.io/api#operation/createGlobalInvoice">API reference</a>
   */
  public Invoice createGlobalInvoice(Map<String, Object> data) {
    return post("/receipts/global-invoice", data, null, Invoice.class);
  }

  /**
   * Creates a to-invoice from a list of receipt keys.
   * Returns the created invoice.
   *
   * @param data to-invoice payload.
   * @return Created invoice.
   */
  public Invoice toInvoice(Map<String, Object> data) {
    return post("/receipts/to-invoice", data, null, Invoice.class);
  }

  /**
   * Generates a PDF preview for a to-invoice payload.
   *
   * @param data To-invoice preview payload.
   * @return PDF bytes.
   */
  public byte[] previewToInvoicePdf(Map<String, Object> data) {
    return client.postBytes("/receipts/to-invoice/preview", data);
  }

  /**
   * Cancels a receipt.
   *
   * @param id Receipt id.
   * @return Canceled receipt.
   * @see <a href="https://docs.facturapi.io/api#operation/cancelReceipt">API reference</a>
   */
  public Receipt cancel(String id) {
    return delete("/receipts/" + id, null, Receipt.class);
  }

  /**
   * Sends the receipt to the customer's email.
   *
   * @param id Receipt id.
   * @param data Email options.
   * @return Operation response.
   * @see <a href="https://docs.facturapi.io/api#operation/sendReceiptByEmail">API reference</a>
   */
  public GenericResponse sendByEmail(String id, Map<String, Object> data) {
    return post("/receipts/" + id + "/email", data, null, GenericResponse.class);
  }

  /**
   * Downloads a receipt PDF file.
   *
   * @param id Receipt id.
   * @return PDF bytes.
   * @see <a href="https://docs.facturapi.io/api#operation/downloadReceiptPdf">API reference</a>
   */
  public byte[] downloadPdf(String id) {
    return client.getBytes("/receipts/" + id + "/pdf");
  }

  /**
   * Opens a streaming receipt PDF download.
   *
   * @param id Receipt id.
   * @return PDF stream. Caller owns closing it.
   * @see <a href="https://docs.facturapi.io/api#operation/downloadReceiptPdf">API reference</a>
   */
  public InputStream downloadPdfStream(String id) {
    return client.getStream("/receipts/" + id + "/pdf");
  }
}
