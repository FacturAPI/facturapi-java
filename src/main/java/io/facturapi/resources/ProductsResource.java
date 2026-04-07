package io.facturapi.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.Product;
import io.facturapi.models.SearchResult;
import java.util.Map;

public class ProductsResource extends BaseResource {
  /**
   * Product endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Products">API reference</a>
   */
  public ProductsResource(FacturapiHttpClient client) {
    super(client);
  }

  /**
   * Creates a new product in your organization.
   *
   * @param data Product payload.
   * @return Created product.
   * @see <a href="https://docs.facturapi.io/api#operation/createProduct">API reference</a>
   */
  public Product create(Map<String, Object> data) {
    return post("/products", data, null, Product.class);
  }

  /**
   * Gets a paginated list of products in your organization.
   *
   * @param params Search and pagination parameters.
   * @return Paginated product result.
   * @see <a href="https://docs.facturapi.io/api#operation/listProducts">API reference</a>
   */
  public SearchResult<Product> list(Map<String, ?> params) {
    return get("/products", params, new TypeReference<SearchResult<Product>>() {});
  }

  /**
   * Gets a single product by id.
   *
   * @param id Product id.
   * @return Product object.
   * @see <a href="https://docs.facturapi.io/api#operation/getProduct">API reference</a>
   */
  public Product retrieve(String id) {
    return get("/products/" + id, null, Product.class);
  }

  /**
   * Updates a product.
   *
   * @param id Product id.
   * @param data Product payload updates.
   * @return Updated product.
   * @see <a href="https://docs.facturapi.io/api#operation/editProduct">API reference</a>
   */
  public Product update(String id, Map<String, Object> data) {
    return put("/products/" + id, data, null, Product.class);
  }

  /**
   * Permanently removes a product.
   *
   * @param id Product id.
   * @return Deleted product.
   * @see <a href="https://docs.facturapi.io/api#operation/deleteProduct">API reference</a>
   */
  public Product delete(String id) {
    return delete("/products/" + id, null, Product.class);
  }
}
