package io.facturapi.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.Customer;
import io.facturapi.models.GenericResponse;
import io.facturapi.models.SearchResult;
import io.facturapi.models.TaxInfoValidation;
import java.util.Map;

public class CustomersResource extends BaseResource {
  /**
   * Customer endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Customers">API reference</a>
   */
  public CustomersResource(FacturapiHttpClient client) {
    super(client);
  }

  /**
   * Creates a new customer in your organization.
   *
   * @param data Customer payload.
   * @param params Optional query parameters.
   * @return Created customer.
   * @see <a href="https://docs.facturapi.io/api#operation/createCustomer">API reference</a>
   */
  public Customer create(Map<String, Object> data, Map<String, ?> params) {
    return post("/customers", data, params, Customer.class);
  }

  /**
   * Gets a paginated list of customers in your organization.
   *
   * @param params Search and pagination parameters.
   * @return Paginated customer result.
   * @see <a href="https://docs.facturapi.io/api#operation/listCustomers">API reference</a>
   */
  public SearchResult<Customer> list(Map<String, ?> params) {
    return get("/customers", params, new TypeReference<SearchResult<Customer>>() {});
  }

  /**
   * Gets a single customer by id.
   *
   * @param id Customer id.
   * @return Customer object.
   * @see <a href="https://docs.facturapi.io/api#operation/getCustomer">API reference</a>
   */
  public Customer retrieve(String id) {
    return get("/customers/" + id, null, Customer.class);
  }

  /**
   * Updates a customer.
   *
   * @param id Customer id.
   * @param data Customer payload updates.
   * @param params Optional query parameters.
   * @return Updated customer.
   * @see <a href="https://docs.facturapi.io/api#operation/editCustomer">API reference</a>
   */
  public Customer update(String id, Map<String, Object> data, Map<String, ?> params) {
    return put("/customers/" + id, data, params, Customer.class);
  }

  /**
   * Permanently removes a customer.
   *
   * @param id Customer id.
   * @return Deleted customer.
   * @see <a href="https://docs.facturapi.io/api#operation/deleteCustomer">API reference</a>
   */
  public Customer delete(String id) {
    return delete("/customers/" + id, null, Customer.class);
  }

  /**
   * Validates customer tax information with SAT.
   *
   * @param id Customer id.
   * @return Validation result.
   * @see <a href="https://docs.facturapi.io/api#operation/validateCustomerTaxInfo">API reference</a>
   */
  public TaxInfoValidation validateTaxInfo(String id) {
    return get("/customers/" + id + "/tax-info-validation", null, TaxInfoValidation.class);
  }

  /**
   * Sends an email to the customer with an edit link.
   *
   * @param id Customer id.
   * @param email Destination email.
   * @return Operation response.
   * @see <a href="https://docs.facturapi.io/api#operation/sendEditLinkByEmail">API reference</a>
   */
  public GenericResponse sendEditLinkByEmail(String id, String email) {
    return post("/customers/" + id + "/email-edit-link", Map.of("email", email), null, GenericResponse.class);
  }
}
