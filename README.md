# facturapi-java

Official Java SDK for [Facturapi](https://www.facturapi.io).

## Requirements

- Java 11+
- Maven 3.8+

## Installation

```xml
<dependency>
  <groupId>io.facturapi</groupId>
  <artifactId>facturapi-java</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Quickstart

```java
import com.facturapi.Facturapi;
import java.util.Map;

Facturapi facturapi = new Facturapi("sk_test_...");

var customer = facturapi.customers.create(Map.of(
  "legal_name", "Mi Empresa SA de CV",
  "tax_id", "XAXX010101000",
  "tax_system", "601",
  "email", "cliente@example.com"
), null);

var invoice = facturapi.invoices.create(Map.of(
  "customer", customer.get("id").asText(),
  "items", java.util.List.of(Map.of("quantity", 1, "product", "prod_123"))
), null);
```

## Configuration

```java
Facturapi facturapi = Facturapi.builder("sk_test_...")
  .apiVersion("v2")
  .timeout(java.time.Duration.ofSeconds(20))
  .build();
```

## Notes

- Uses `Authorization: Bearer <apiKey>`.
- Supports custom base URL for integration testing.
- Includes compatibility aliases (`all`, `del`, `lisLiveApiKeys`).
