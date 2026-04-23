# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.2.0] - 2026-04-23

### Added

- Add `ComplementsCatalogsConstants` with Carta Porte/Comercio Exterior catalog enums and Spanish description maps for customs regimes, transport keys, permits, COFEPRIS sectors, pharmaceutical forms, special conditions, material types, customs document types, transport parts/figures, ISTMO registry, loading keys, maritime configs, rail traffic/container/car/service types, traslado motives, incoterms, and customs units.

## [1.1.0] - 2026-04-16

### Added

- Add `organizations.updateDefaultSeries` to set an organization's default series by document type.

## [1.0.0] - 2026-04-07

### Added

- Initial official Java SDK release for Facturapi (`io.facturapi:facturapi-java`).
- Typed resources for core domains including customers, products, invoices, organizations, receipts, retentions, webhooks, and catalogs.
- Accessor-based root client API (`facturapi.customers()`, `facturapi.invoices()`, etc.) aligned with modern Java SDK style.
- Deeply typed complement models for `pago`, `nomina`, `carta_porte`, and `comercio_exterior`.
- Java time support with typed date fields (`Instant` and `LocalDate`) using Jackson `JavaTimeModule`.
- Enum coverage for core SAT and document state fields (invoice status/type, payment form/method, cancellation motive/status, tax factor/type, taxability, and related constants).
- Download ergonomics with both byte and stream methods for invoice/retention/receipt files.
- Upload ergonomics with `File` and `byte[]` methods for organization logo and certificate uploads.
- Typed `FacturapiException` surface exposing status and structured error fields (`statusCode`, `errorCode`, `errorPath`).
- CI workflow for pull requests and pushes to `main` (Java 11, 17, 21, and 25).
- Maven Central publish workflow gated by semantic version comparison.
- Bilingual consumer docs (`README.md` and `README.es.md`).

### Changed

- Standardized request auth to `Authorization: Bearer <apiKey>`.
- Adopted global Jackson `snake_case` naming strategy for consistent API-model mapping.
- Unified HTTP transport on OkHttp to support Java server environments and Android-compatible runtimes.
