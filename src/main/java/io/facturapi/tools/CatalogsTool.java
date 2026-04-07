package io.facturapi.tools;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.CatalogItem;
import io.facturapi.models.SearchResult;
import java.util.Map;

public class CatalogsTool {
  private final FacturapiHttpClient client;

  /**
   * SAT catalogs endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Catalogs">API reference</a>
   */
  public CatalogsTool(FacturapiHttpClient client) {
    this.client = client;
  }

  /**
   * Searches SAT product/service catalog entries.
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   * @see <a href="https://docs.facturapi.io/api#tag/Catalogs">API reference</a>
   */
  public SearchResult<CatalogItem> searchProducts(Map<String, ?> params) {
    return client.get("/catalogs/products", params, new TypeReference<SearchResult<CatalogItem>>() {});
  }

  /**
   * Searches SAT unit catalog entries.
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   * @see <a href="https://docs.facturapi.io/api#tag/Catalogs">API reference</a>
   */
  public SearchResult<CatalogItem> searchUnits(Map<String, ?> params) {
    return client.get("/catalogs/units", params, new TypeReference<SearchResult<CatalogItem>>() {});
  }
}
