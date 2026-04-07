package io.facturapi;

import io.facturapi.enums.CancellationMotive;
import io.facturapi.enums.InvoiceType;
import io.facturapi.enums.PaymentForm;
import io.facturapi.enums.TaxFactor;
import io.facturapi.enums.TaxType;
import io.facturapi.http.FacturapiConfig;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.resources.CustomersResource;
import io.facturapi.resources.InvoicesResource;
import io.facturapi.resources.OrganizationsResource;
import io.facturapi.resources.ProductsResource;
import io.facturapi.resources.ReceiptsResource;
import io.facturapi.resources.RetentionsResource;
import io.facturapi.resources.WebhooksResource;
import io.facturapi.tools.CartaPorteCatalogsTool;
import io.facturapi.tools.CatalogsTool;
import io.facturapi.tools.ComercioExteriorCatalogsTool;
import io.facturapi.tools.ToolsResource;
import java.time.Duration;

public class Facturapi {
  private final FacturapiHttpClient httpClient;

  public final CustomersResource customers;
  public final ProductsResource products;
  public final InvoicesResource invoices;
  public final OrganizationsResource organizations;
  public final ReceiptsResource receipts;
  public final RetentionsResource retentions;
  public final WebhooksResource webhooks;

  public final CatalogsTool catalogs;
  public final CartaPorteCatalogsTool cartaPorteCatalogs;
  public final ComercioExteriorCatalogsTool comercioExteriorCatalogs;
  public final ToolsResource tools;

  /**
   * Creates a client using API v2.
   *
   * @param apiKey Facturapi API key.
   */
  public Facturapi(String apiKey) {
    this(FacturapiConfig.builder(apiKey).build());
  }

  /**
   * Creates a client with an explicit API version.
   *
   * @param apiKey Facturapi API key.
   * @param apiVersion API version: v1 or v2.
   */
  public Facturapi(String apiKey, String apiVersion) {
    this(FacturapiConfig.builder(apiKey).apiVersion(apiVersion).build());
  }

  /**
   * Creates a client using a custom SDK configuration.
   *
   * @param config SDK configuration.
   */
  public Facturapi(FacturapiConfig config) {
    this.httpClient = new FacturapiHttpClient(config);
    this.customers = new CustomersResource(httpClient);
    this.products = new ProductsResource(httpClient);
    this.invoices = new InvoicesResource(httpClient);
    this.organizations = new OrganizationsResource(httpClient);
    this.receipts = new ReceiptsResource(httpClient);
    this.retentions = new RetentionsResource(httpClient);
    this.webhooks = new WebhooksResource(httpClient);

    this.catalogs = new CatalogsTool(httpClient);
    this.cartaPorteCatalogs = new CartaPorteCatalogsTool(httpClient);
    this.comercioExteriorCatalogs = new ComercioExteriorCatalogsTool(httpClient);
    this.tools = new ToolsResource(httpClient);
  }

  /**
   * Creates a builder for client initialization.
   *
   * @param apiKey Facturapi API key.
   * @return Builder instance.
   */
  public static Builder builder(String apiKey) {
    return new Builder(apiKey);
  }

  public static final class Builder {
    private final FacturapiConfig.Builder configBuilder;

    private Builder(String apiKey) {
      this.configBuilder = FacturapiConfig.builder(apiKey);
    }

    public Builder apiVersion(ApiVersion apiVersion) {
      this.configBuilder.apiVersion(apiVersion);
      return this;
    }

    public Builder apiVersion(String apiVersion) {
      this.configBuilder.apiVersion(apiVersion);
      return this;
    }

    public Builder timeout(Duration timeout) {
      this.configBuilder.timeout(timeout);
      return this;
    }

    public Facturapi build() {
      return new Facturapi(configBuilder.build());
    }
  }

  public static Class<PaymentForm> PaymentForm() {
    return PaymentForm.class;
  }

  public static Class<TaxType> TaxType() {
    return TaxType.class;
  }

  public static Class<TaxFactor> TaxFactor() {
    return TaxFactor.class;
  }

  public static Class<InvoiceType> InvoiceType() {
    return InvoiceType.class;
  }

  public static Class<CancellationMotive> CancellationMotive() {
    return CancellationMotive.class;
  }
}
