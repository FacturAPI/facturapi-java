package io.facturapi.tools;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.CatalogItem;
import io.facturapi.models.SearchResult;
import java.util.Map;

public class ComercioExteriorCatalogsTool {
  private final FacturapiHttpClient client;

  /**
   * Comercio Exterior catalogs endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Comercio-Exterior-Catalogs">API reference</a>
   */
  public ComercioExteriorCatalogsTool(FacturapiHttpClient client) {
    this.client = client;
  }

  /**
   * Searches tariff fractions catalog entries (Comercio Exterior 2.0).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   * @see <a href="https://docs.facturapi.io/api#tag/Comercio-Exterior-Catalogs">API reference</a>
   */
  public SearchResult<CatalogItem> searchTariffFractions(Map<String, ?> params) {
    return client.get(
      "/catalogs/comercioexterior/2.0/tariff-fractions",
      params,
      new TypeReference<SearchResult<CatalogItem>>() {}
    );
  }
}
