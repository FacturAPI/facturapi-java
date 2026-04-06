package com.facturapi.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public class CartaPorteCatalogsTool {
  private static final String BASE_PATH = "/catalogs/cartaporte/3.1";
  private final FacturapiHttpClient client;

  public CartaPorteCatalogsTool(FacturapiHttpClient client) {
    this.client = client;
  }

  public JsonNode searchAirTransportCodes(Map<String, ?> params) {
    return client.getJson(BASE_PATH + "/air-transport-codes", params);
  }

  public JsonNode searchTransportConfigs(Map<String, ?> params) {
    return client.getJson(BASE_PATH + "/transport-configs", params);
  }

  public JsonNode searchRightsOfPassage(Map<String, ?> params) {
    return client.getJson(BASE_PATH + "/rights-of-passage", params);
  }

  public JsonNode searchCustomsDocuments(Map<String, ?> params) {
    return client.getJson(BASE_PATH + "/customs-documents", params);
  }

  public JsonNode searchPackagingTypes(Map<String, ?> params) {
    return client.getJson(BASE_PATH + "/packaging-types", params);
  }

  public JsonNode searchTrailerTypes(Map<String, ?> params) {
    return client.getJson(BASE_PATH + "/trailer-types", params);
  }

  public JsonNode searchHazardousMaterials(Map<String, ?> params) {
    return client.getJson(BASE_PATH + "/hazardous-materials", params);
  }

  public JsonNode searchNavalAuthorizations(Map<String, ?> params) {
    return client.getJson(BASE_PATH + "/naval-authorizations", params);
  }

  public JsonNode searchPortStations(Map<String, ?> params) {
    return client.getJson(BASE_PATH + "/port-stations", params);
  }

  public JsonNode searchMarineContainers(Map<String, ?> params) {
    return client.getJson(BASE_PATH + "/marine-containers", params);
  }
}
