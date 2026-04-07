package io.facturapi.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.GenericResponse;
import io.facturapi.models.Retention;
import io.facturapi.models.SearchResult;
import java.util.Map;

public class RetentionsResource extends BaseResource {
  /**
   * Retention endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Retentions">API reference</a>
   */
  public RetentionsResource(FacturapiHttpClient client) {
    super(client);
  }

  /**
   * Creates a new valid retention (CFDI).
   *
   * @param data Retention payload.
   * @return Created retention.
   * @see <a href="https://docs.facturapi.io/api#operation/createRetention">API reference</a>
   */
  public Retention create(Map<String, Object> data) {
    return post("/retentions", data, null, Retention.class);
  }

  /**
   * Gets a paginated list of retentions.
   *
   * @param params Search and pagination parameters.
   * @return Paginated retention result.
   * @see <a href="https://docs.facturapi.io/api#operation/listRetentions">API reference</a>
   */
  public SearchResult<Retention> list(Map<String, ?> params) {
    return get("/retentions", params, new TypeReference<SearchResult<Retention>>() {});
  }

  /**
   * Gets a single retention by id.
   *
   * @param id Retention id.
   * @return Retention object.
   * @see <a href="https://docs.facturapi.io/api#operation/getRetention">API reference</a>
   */
  public Retention retrieve(String id) {
    return get("/retentions/" + id, null, Retention.class);
  }

  /**
   * Cancels a retention.
   *
   * @param id Retention id.
   * @param params Cancellation options.
   * @return Canceled retention.
   * @see <a href="https://docs.facturapi.io/api#operation/cancelRetention">API reference</a>
   */
  public Retention cancel(String id, Map<String, ?> params) {
    return delete("/retentions/" + id, params, Retention.class);
  }

  /**
   * Sends the retention to the customer's email.
   *
   * @param id Retention id.
   * @param data Email options.
   * @return Operation response.
   * @see <a href="https://docs.facturapi.io/api#operation/sendRetentionByEmail">API reference</a>
   */
  public GenericResponse sendByEmail(String id, Map<String, Object> data) {
    return post("/retentions/" + id + "/email", data, null, GenericResponse.class);
  }

  /**
   * Downloads a retention PDF file.
   *
   * @param id Retention id.
   * @return PDF bytes.
   * @see <a href="https://docs.facturapi.io/api#operation/downloadRetention">API reference</a>
   */
  public byte[] downloadPdf(String id) {
    return client.getBytes("/retentions/" + id + "/pdf");
  }

  /**
   * Downloads a retention XML file.
   *
   * @param id Retention id.
   * @return XML bytes.
   * @see <a href="https://docs.facturapi.io/api#operation/downloadRetention">API reference</a>
   */
  public byte[] downloadXml(String id) {
    return client.getBytes("/retentions/" + id + "/xml");
  }

  /**
   * Downloads a retention ZIP package with PDF and XML.
   *
   * @param id Retention id.
   * @return ZIP bytes.
   * @see <a href="https://docs.facturapi.io/api#operation/downloadRetention">API reference</a>
   */
  public byte[] downloadZip(String id) {
    return client.getBytes("/retentions/" + id + "/zip");
  }
}
