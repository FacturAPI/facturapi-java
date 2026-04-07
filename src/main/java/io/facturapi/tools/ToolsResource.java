package io.facturapi.tools;

import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.TaxInfoValidation;
import java.util.Map;

public class ToolsResource {
  private final FacturapiHttpClient client;

  /**
   * Utility endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Tools">API reference</a>
   */
  public ToolsResource(FacturapiHttpClient client) {
    this.client = client;
  }

  /**
   * Validates a tax id against EFOS list.
   *
   * @param taxId RFC or tax id value.
   * @return Validation result.
   * @see <a href="https://docs.facturapi.io/api#tag/Tools">API reference</a>
   */
  public TaxInfoValidation validateTaxId(String taxId) {
    return client.get("/tools/tax_id_validation", Map.of("tax_id", taxId), TaxInfoValidation.class);
  }
}
