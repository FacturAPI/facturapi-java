# facturapi-java

SDK oficial de Java para [Facturapi](https://www.facturapi.io).

English: [README.md](README.md)

[![CI](https://img.shields.io/github/actions/workflow/status/facturapi/facturapi-java/ci.yml?branch=main&style=for-the-badge&label=CI)](https://github.com/facturapi/facturapi-java/actions/workflows/ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.facturapi/facturapi-java?style=for-the-badge&label=Maven%20Central)](https://central.sonatype.com/artifact/io.facturapi/facturapi-java)
[![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)

## Requisitos

- Java 11+
- Kotlin/JVM
- Android 8.0 (API level 26) o superior
- Spring Boot, Jakarta EE, Quarkus, Micronaut y otras apps JVM de servidor

## Instalación

Maven:

```xml
<dependency>
  <groupId>io.facturapi</groupId>
  <artifactId>facturapi-java</artifactId>
  <version>1.0.0</version>
</dependency>
```

Gradle:

```gradle
implementation("io.facturapi:facturapi-java:1.0.0")
```

## Inicio rápido

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

## Subidas

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

## Errores

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

## Diseño

- Las entradas usan diccionarios JSON flexibles (`Map<String, Object>`).
- Las salidas son modelos Java tipados (`Invoice`, `Customer`, `SearchResult<T>`, etc.).
- Los errores exponen directamente los campos útiles del error del API en `FacturapiException`.
- La autenticación usa `Authorization: Bearer <apiKey>`.

## Configuración

```java
Facturapi facturapi = Facturapi.builder("sk_test_...")
  .apiVersion("v2")
  .timeout(java.time.Duration.ofSeconds(20))
  .build();
```
