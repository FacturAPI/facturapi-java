package com.facturapi;

import com.facturapi.enums.CancellationMotive;
import com.facturapi.enums.InvoiceType;
import com.facturapi.enums.PaymentForm;
import com.facturapi.enums.TaxFactor;
import com.facturapi.enums.TaxType;
import com.facturapi.http.FacturapiConfig;
import com.facturapi.http.FacturapiHttpClient;
import com.facturapi.resources.CustomersResource;
import com.facturapi.resources.InvoicesResource;
import com.facturapi.resources.OrganizationsResource;
import com.facturapi.resources.ProductsResource;
import com.facturapi.resources.ReceiptsResource;
import com.facturapi.resources.RetentionsResource;
import com.facturapi.resources.WebhooksResource;
import com.facturapi.tools.CartaPorteCatalogsTool;
import com.facturapi.tools.CatalogsTool;
import com.facturapi.tools.ComercioExteriorCatalogsTool;
import com.facturapi.tools.ToolsResource;
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

  public Facturapi(String apiKey) {
    this(FacturapiConfig.builder(apiKey).build());
  }

  // Backward-compatible constructor
  public Facturapi(String apiKey, String apiVersion) {
    this(FacturapiConfig.builder(apiKey).apiVersion(apiVersion).build());
  }

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

    public Builder baseUrl(String baseUrl) {
      this.configBuilder.baseUrl(baseUrl);
      return this;
    }

    public Builder timeout(Duration timeout) {
      this.configBuilder.timeout(timeout);
      return this;
    }

    public Builder userAgent(String userAgent) {
      this.configBuilder.userAgent(userAgent);
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
