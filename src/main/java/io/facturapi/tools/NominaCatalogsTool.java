package io.facturapi.tools;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.CatalogItem;
import io.facturapi.models.SearchResult;
import java.util.Map;

public class NominaCatalogsTool {
  private final FacturapiHttpClient client;

  public NominaCatalogsTool(FacturapiHttpClient client) {
    this.client = client;
  }

  /** Searches payroll deduction types. */
  public SearchResult<CatalogItem> searchDeductions(Map<String, ?> params) {
    return client.get("/catalogs/deductions", params, new TypeReference<SearchResult<CatalogItem>>() {});
  }

  /** Searches payroll perception types. */
  public SearchResult<CatalogItem> searchPerceptions(Map<String, ?> params) {
    return client.get("/catalogs/perceptions", params, new TypeReference<SearchResult<CatalogItem>>() {});
  }
}
