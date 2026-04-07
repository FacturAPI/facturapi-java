# facturapi-java

Official Java SDK for [Facturapi](https://www.facturapi.io).

[![CI](https://img.shields.io/github/actions/workflow/status/facturapi/facturapi-java/ci.yml?branch=main&style=for-the-badge&label=CI)](https://github.com/facturapi/facturapi-java/actions/workflows/ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.facturapi/facturapi-java?style=for-the-badge&label=Maven%20Central)](https://central.sonatype.com/artifact/io.facturapi/facturapi-java)
[![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)

## Requirements

- Java 11+

## Installation

Maven:

```xml
<dependency>
  <groupId>io.facturapi</groupId>
  <artifactId>facturapi-java</artifactId>
  <version>0.1.0</version>
</dependency>
```

Gradle:

```gradle
implementation("io.facturapi:facturapi-java:0.1.0")
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

## Design

- Inputs use flexible JSON dictionaries (`Map<String, Object>`).
- Outputs are typed Java models (`Invoice`, `Customer`, `SearchResult<T>`, etc.).
- Auth uses `Authorization: Bearer <apiKey>`.

## Configuration

```java
Facturapi facturapi = Facturapi.builder("sk_test_...")
  .apiVersion("v2")
  .timeout(java.time.Duration.ofSeconds(20))
  .build();
```
