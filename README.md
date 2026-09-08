# Facturapi Java SDK

Official Java SDK for [Facturapi](https://www.facturapi.io).

Español: [README.es.md](README.es.md)

Facturapi helps developers generate valid electronic invoices (CFDI) in Mexico.

If you've used Stripe or a similar API-first payments or billing SDK, the surface here should feel familiar: typed models on the way out, flexible JSON objects on the way in.

Make sure you have a Facturapi account and your API key.

[![CI](https://img.shields.io/github/actions/workflow/status/facturapi/facturapi-java/ci.yml?branch=main&style=for-the-badge&label=CI)](https://github.com/facturapi/facturapi-java/actions/workflows/ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.facturapi/facturapi-java?style=for-the-badge&label=Maven%20Central)](https://central.sonatype.com/artifact/io.facturapi/facturapi-java)
[![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)

## Compatibility

- Java 11+
- Kotlin/JVM
- Android 8.0 (API level 26) o superior
- Spring Boot, Jakarta EE, Quarkus, Micronaut, and other JVM server apps

## Installation

Maven:

```xml
<dependency>
  <groupId>io.facturapi</groupId>
  <artifactId>facturapi-java</artifactId>
  <version>2.0.0</version>
</dependency>
```

Gradle:

```gradle
implementation("io.facturapi:facturapi-java:2.0.0")
```

## Quickstart

```java
import io.facturapi.Facturapi;
import java.util.Map;

Facturapi facturapi = new Facturapi("sk_test_...");

var customer = facturapi.customers().create(Map.of(
  "legal_name", "Mi Empresa SA de CV",
  "tax_id", "XAXX010101000",
  "tax_system", "601",
  "email", "cliente@example.com"
), null);

var invoice = facturapi.invoices().create(Map.of(
  "customer", customer.getId(),
  "items", java.util.List.of(Map.of("quantity", 1, "product", "prod_123"))
), null);

System.out.println(invoice.getId());
```

## Uploads

```java
import java.io.File;

var organization = facturapi.organizations().uploadLogo(
  "org_123",
  new File("logo.png")
);

var updated = facturapi.organizations().uploadCertificate(
  "org_123",
  new File("certificate.cer"),
  new File("certificate.key"),
  "secret"
);
```

## Errors

```java
import io.facturapi.FacturapiException;

try {
  facturapi.customers().retrieve("cus_123");
} catch (FacturapiException e) {
  System.out.println(e.getMessage());
  System.out.println(e.getStatusCode());
  System.out.println(e.getErrorCode());
  System.out.println(e.getErrorPath());
}
```

## Design

- Inputs use flexible JSON dictionaries (`Map<String, Object>`).
- Outputs are typed Java models (`Invoice`, `Customer`, `SearchResult<T>`, etc.).
- Errors expose the useful API error fields directly on `FacturapiException`.
- Auth uses `Authorization: Bearer <apiKey>`.

## Configuration

```java
Facturapi facturapi = Facturapi.builder("sk_test_...")
  .apiVersion("v2")
  .timeout(java.time.Duration.ofSeconds(20))
  .build();
```

### Custom HTTP Client

For tests or advanced setups, you can inject your own `OkHttpClient`:

```java
import io.facturapi.http.FacturapiConfig;
import okhttp3.OkHttpClient;

Facturapi facturapi = new Facturapi(
  FacturapiConfig.builder("sk_test_...")
    .httpClient(new OkHttpClient())
    .build());
```

## API error language

For API V2, request English error messages with `Accept-Language` using the existing client configuration:

```java
import io.facturapi.Facturapi;
import io.facturapi.http.FacturapiConfig;
import java.time.Duration;
import okhttp3.OkHttpClient;

OkHttpClient httpClient = new OkHttpClient.Builder()
    .connectTimeout(Duration.ofSeconds(30))
    .callTimeout(Duration.ofSeconds(30))
    .addInterceptor(chain -> chain.proceed(
        chain.request().newBuilder()
            .header("Accept-Language", "en")
            .build()))
    .build();

Facturapi facturapi = new Facturapi(
    FacturapiConfig.builder("YOUR_API_KEY")
        .httpClient(httpClient)
        .build());
```

Use `es` for Spanish. Regional variants such as `en-US` and preferences such as `en;q=0.9, es;q=0.5` are also supported. Missing or unsupported language preferences fall back to Spanish. The setting applies to all requests from this instance; use separate instances for different languages. Codes remain unchanged, and external SAT/PAC messages and uncataloged legacy messages retain their original language. Localization requires server-side API V2 support; it does not translate local SDK errors.

## Documentation

Full docs: [https://docs.facturapi.io](https://docs.facturapi.io)

## Support

- Issues: open a GitHub issue
- Email: `contacto@facturapi.io`
