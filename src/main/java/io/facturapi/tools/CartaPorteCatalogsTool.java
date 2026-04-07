package io.facturapi.tools;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.CatalogItem;
import io.facturapi.models.SearchResult;
import java.util.Map;

public class CartaPorteCatalogsTool {
  private static final String BASE_PATH = "/catalogs/cartaporte/3.1";
  private final FacturapiHttpClient client;

  /**
   * Carta Porte catalogs endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Carta-Porte-Catalogs">API reference</a>
   */
  public CartaPorteCatalogsTool(FacturapiHttpClient client) {
    this.client = client;
  }

  /**
   * Searches air transport codes (Carta Porte 3.1).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   * @see <a href="https://docs.facturapi.io/api#tag/Carta-Porte-Catalogs">API reference</a>
   */
  public SearchResult<CatalogItem> searchAirTransportCodes(Map<String, ?> params) {
    return search(BASE_PATH + "/air-transport-codes", params);
  }

  /**
   * Searches transport configurations (Carta Porte 3.1).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   */
  public SearchResult<CatalogItem> searchTransportConfigs(Map<String, ?> params) {
    return search(BASE_PATH + "/transport-configs", params);
  }

  /**
   * Searches rights of passage catalog (Carta Porte 3.1).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   */
  public SearchResult<CatalogItem> searchRightsOfPassage(Map<String, ?> params) {
    return search(BASE_PATH + "/rights-of-passage", params);
  }

  /**
   * Searches customs documents catalog (Carta Porte 3.1).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   */
  public SearchResult<CatalogItem> searchCustomsDocuments(Map<String, ?> params) {
    return search(BASE_PATH + "/customs-documents", params);
  }

  /**
   * Searches packaging types catalog (Carta Porte 3.1).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   */
  public SearchResult<CatalogItem> searchPackagingTypes(Map<String, ?> params) {
    return search(BASE_PATH + "/packaging-types", params);
  }

  /**
   * Searches trailer types catalog (Carta Porte 3.1).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   */
  public SearchResult<CatalogItem> searchTrailerTypes(Map<String, ?> params) {
    return search(BASE_PATH + "/trailer-types", params);
  }

  /**
   * Searches hazardous materials catalog (Carta Porte 3.1).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   */
  public SearchResult<CatalogItem> searchHazardousMaterials(Map<String, ?> params) {
    return search(BASE_PATH + "/hazardous-materials", params);
  }

  /**
   * Searches naval authorizations catalog (Carta Porte 3.1).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   */
  public SearchResult<CatalogItem> searchNavalAuthorizations(Map<String, ?> params) {
    return search(BASE_PATH + "/naval-authorizations", params);
  }

  /**
   * Searches port stations catalog (Carta Porte 3.1).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   */
  public SearchResult<CatalogItem> searchPortStations(Map<String, ?> params) {
    return search(BASE_PATH + "/port-stations", params);
  }

  /**
   * Searches marine containers catalog (Carta Porte 3.1).
   *
   * @param params Search and pagination parameters.
   * @return Paginated catalog result.
   */
  public SearchResult<CatalogItem> searchMarineContainers(Map<String, ?> params) {
    return search(BASE_PATH + "/marine-containers", params);
  }

  private SearchResult<CatalogItem> search(String path, Map<String, ?> params) {
    return client.get(path, params, new TypeReference<SearchResult<CatalogItem>>() {});
  }
}
