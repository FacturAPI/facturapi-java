package io.facturapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.facturapi.enums.CancellationStatus;
import io.facturapi.enums.InvoiceStatus;
import io.facturapi.enums.InvoiceType;
import io.facturapi.enums.IssuingType;
import io.facturapi.enums.PaymentForm;
import io.facturapi.enums.PaymentMethod;
import io.facturapi.enums.TaxFactor;
import io.facturapi.enums.TaxType;
import io.facturapi.enums.Taxability;
import io.facturapi.http.FacturapiConfig;
import io.facturapi.models.Customer;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FacturapiResourcesTest {
  @Test
  void invoiceCreateUsesExpectedPath() {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueJson(200, "{\"id\":\"inv_1\"}");

    Facturapi sdk = new Facturapi(
      FacturapiConfig.builder("sk_test")
        .httpClient(httpClient)
        .build()
    );

    var response = sdk.invoices().create(Map.of("customer", "cus_1"), Map.of("test", true));

    assertEquals("inv_1", response.getId());

    var request = httpClient.requests().get(0);
    assertEquals("POST", request.method());
    assertEquals("/v2/invoices?test=true", request.uri().getPath() + "?" + request.uri().getQuery());
  }

  @Test
  void invoicePdfCanBeStreamed() throws Exception {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueBinary(200, "PDF-CONTENT".getBytes(), "application/pdf");

    Facturapi sdk = new Facturapi(
      FacturapiConfig.builder("sk_test")
        .httpClient(httpClient)
        .build()
    );

    try (InputStream stream = sdk.invoices().downloadPdfStream("inv_1")) {
      assertEquals("PDF-CONTENT", new String(stream.readAllBytes(), StandardCharsets.UTF_8));
    }

    var request = httpClient.requests().get(0);
    assertEquals("/v2/invoices/inv_1/pdf", request.uri().getPath());
  }

  @Test
  void organizationUploadsAcceptBytes() {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueJson(200, "{\"id\":\"org_1\"}");

    Facturapi sdk = new Facturapi(
      FacturapiConfig.builder("sk_test")
        .httpClient(httpClient)
        .build()
    );

    var response = sdk.organizations().uploadLogo("org_1", "logo-bytes".getBytes(StandardCharsets.UTF_8));

    assertEquals("org_1", response.getId());
    assertEquals("PUT", httpClient.requests().get(0).method());
    assertEquals("/v2/organizations/org_1/logo", httpClient.requests().get(0).uri().getPath());
  }

  @Test
  void organizationCertificateUploadsAcceptBytes() {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueJson(200, "{\"id\":\"org_1\"}");

    Facturapi sdk = new Facturapi(
      FacturapiConfig.builder("sk_test")
        .httpClient(httpClient)
        .build()
    );

    var response = sdk.organizations().uploadCertificate(
      "org_1",
      "cer-bytes".getBytes(StandardCharsets.UTF_8),
      "key-bytes".getBytes(StandardCharsets.UTF_8),
      "secret"
    );

    assertEquals("org_1", response.getId());
    assertEquals("PUT", httpClient.requests().get(0).method());
    assertEquals("/v2/organizations/org_1/certificate", httpClient.requests().get(0).uri().getPath());
  }

  @Test
  void sdkExposesAccessorBasedSurface() {
    Facturapi sdk = new Facturapi(
      FacturapiConfig.builder("sk_test")
        .httpClient(new StubHttpClient())
        .build()
    );

    assertNotNull(sdk.customers());
    assertNotNull(sdk.invoices());
    assertNotNull(sdk.receipts());
    assertNotNull(sdk.retentions());
    assertNotNull(sdk.webhooks());
    assertNotNull(sdk.organizations());
    assertNotNull(sdk.catalogs());
    assertNotNull(sdk.cartaPorteCatalogs());
    assertNotNull(sdk.comercioExteriorCatalogs());
    assertNotNull(sdk.tools());
  }

  @Test
  void organizationListLiveApiKeysIsTyped() {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueJson(200, "[{\"id\":\"live_1\",\"key\":\"sk_live_x\"}]");

    Facturapi sdk = new Facturapi(
      FacturapiConfig.builder("sk_test")
        .httpClient(httpClient)
        .build()
    );

    var response = sdk.organizations().listLiveApiKeys("org_1");

    assertEquals(1, response.size());
    assertNotNull(response.get(0).getId());
    var request = httpClient.requests().get(0);
    assertEquals("/v2/organizations/org_1/apikeys/live", request.uri().getPath());
  }

  @Test
  void invoiceComplementsAreTypedForPagoNominaAndCustom() {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueJson(
      200,
      "{\"id\":\"inv_1\",\"created_at\":\"2026-04-07T10:00:00Z\",\"date\":\"2026-04-07T12:30:00Z\",\"issuer_type\":\"issuing\",\"type\":\"P\",\"status\":\"valid\",\"payment_form\":\"03\",\"payment_method\":\"PUE\",\"cancellation_status\":\"none\",\"complements\":[" +
      "{\"type\":\"pago\",\"data\":[{\"payment_form\":\"03\",\"date\":\"2026-04-07T13:45:00Z\",\"currency\":\"MXN\",\"exchange\":1,\"related_documents\":[{\"uuid\":\"f03d5c3f-a93b-443f-927f-e89db2f7f58a\",\"amount\":100,\"installment\":1,\"last_balance\":100,\"currency\":\"MXN\",\"exchange\":1,\"taxability\":\"02\",\"taxes\":[{\"base\":100,\"rate\":0.16,\"type\":\"IVA\",\"factor\":\"Tasa\",\"withholding\":false}]}]}]}," +
      "{\"type\":\"nomina\",\"data\":{\"tipo_nomina\":\"O\",\"fecha_pago\":\"2026-04-01\",\"fecha_inicial_pago\":\"2026-03-16\",\"fecha_final_pago\":\"2026-03-31\",\"num_dias_pagados\":15,\"receptor\":{\"curp\":\"TEST900101HDFABC01\",\"tipo_contrato\":\"01\",\"tipo_regimen\":\"02\",\"num_empleado\":\"EMP-1\",\"periodicidad_pago\":\"04\",\"clave_ent_fed\":\"CMX\",\"fecha_inicio_rel_laboral\":\"2026-01-01\"},\"percepciones\":{\"percepcion\":[{\"tipo_percepcion\":\"001\",\"clave\":\"P001\",\"importe_gravado\":1000,\"importe_exento\":0}]},\"deducciones\":[{\"tipo_deduccion\":\"002\",\"clave\":\"D001\",\"importe\":100}]}}," +
      "{\"type\":\"custom\",\"data\":\"<my:Complement xmlns:my=\\\"https://example.com\\\"/>\"}," +
      "{\"type\":\"carta_porte\",\"data\":{\"IdCCP\":\"CPC2026040700001\",\"TranspInternac\":\"No\",\"TotalDistRec\":15.4,\"Ubicaciones\":[],\"Mercancias\":{\"Mercancia\":[]}}}," +
      "{\"type\":\"comercio_exterior\",\"data\":{\"Version\":\"2.0\",\"ClaveDePedimento\":\"A1\",\"CertificadoOrigen\":0,\"TipoCambioUSD\":16.9,\"TotalUSD\":100.5,\"Emisor\":true,\"Propietario\":[{\"id\":\"cus_owner_1\"}],\"Receptor\":{\"NumRegIdTrib\":\"EXT12345\"},\"Destinatario\":[{\"Nombre\":\"Receiver Inc\",\"Domicilio\":[{\"Calle\":\"Main\",\"Estado\":\"TX\",\"Pais\":\"USA\",\"CodigoPostal\":\"77001\"}]}],\"Mercancias\":{\"Mercancia\":[{\"NoIdentificacion\":\"SKU-1\",\"ValorDolares\":100.5}]}}}" +
      "]}"
    );

    Facturapi sdk = new Facturapi(
      FacturapiConfig.builder("sk_test")
        .httpClient(httpClient)
        .build()
    );

    var invoice = sdk.invoices().retrieve("inv_1");
    assertEquals(Instant.parse("2026-04-07T10:00:00Z"), invoice.getCreatedAt());
    assertEquals(Instant.parse("2026-04-07T12:30:00Z"), invoice.getDate());
    assertEquals(IssuingType.ISSUING, invoice.getIssuerType());
    assertEquals(InvoiceType.PAGO, invoice.getType());
    assertEquals(InvoiceStatus.VALID, invoice.getStatus());
    assertEquals(PaymentForm.TRANSFERENCIA_ELECTRONICA_DE_FONDOS, invoice.getPaymentForm());
    assertEquals(PaymentMethod.PUE, invoice.getPaymentMethod());
    assertEquals(CancellationStatus.NONE, invoice.getCancellationStatus());
    assertEquals(5, invoice.getComplements().size());

    var pago = invoice.getComplements().get(0);
    assertEquals("pago", pago.getType());
    assertNotNull(pago.getPagoData());
    assertEquals(1, pago.getPagoData().size());
    assertEquals(PaymentForm.TRANSFERENCIA_ELECTRONICA_DE_FONDOS, pago.getPagoData().get(0).getPaymentForm());
    assertEquals(Instant.parse("2026-04-07T13:45:00Z"), pago.getPagoData().get(0).getDate());
    assertEquals("f03d5c3f-a93b-443f-927f-e89db2f7f58a", pago.getPagoData().get(0).getRelatedDocuments().get(0).getUuid());
    assertEquals(Taxability.SUBJECT_TO_TAX, pago.getPagoData().get(0).getRelatedDocuments().get(0).getTaxability());
    assertEquals(TaxType.IVA, pago.getPagoData().get(0).getRelatedDocuments().get(0).getTaxes().get(0).getType());
    assertEquals(TaxFactor.TASA, pago.getPagoData().get(0).getRelatedDocuments().get(0).getTaxes().get(0).getFactor());
    assertInstanceOf(java.util.List.class, pago.getData());

    var nomina = invoice.getComplements().get(1);
    assertEquals("nomina", nomina.getType());
    assertNotNull(nomina.getNominaData());
    assertEquals("O", nomina.getNominaData().getTipoNomina());
    assertEquals("EMP-1", nomina.getNominaData().getReceptor().getNumEmpleado());
    assertEquals(LocalDate.parse("2026-01-01"), nomina.getNominaData().getReceptor().getFechaInicioRelLaboral());
    assertEquals(LocalDate.parse("2026-04-01"), nomina.getNominaData().getFechaPago());
    assertEquals(LocalDate.parse("2026-03-16"), nomina.getNominaData().getFechaInicialPago());
    assertEquals(LocalDate.parse("2026-03-31"), nomina.getNominaData().getFechaFinalPago());
    assertEquals("001", nomina.getNominaData().getPercepciones().getPercepcion().get(0).getTipoPercepcion());

    var custom = invoice.getComplements().get(2);
    assertEquals("custom", custom.getType());
    assertNotNull(custom.getCustomData());
    assertEquals("<my:Complement xmlns:my=\"https://example.com\"/>", custom.getCustomData());
    assertInstanceOf(String.class, custom.getData());

    var cartaPorte = invoice.getComplements().get(3);
    assertEquals("carta_porte", cartaPorte.getType());
    assertNotNull(cartaPorte.getCartaPorteData());
    assertEquals("CPC2026040700001", cartaPorte.getCartaPorteData().getIdCcp());
    assertEquals("No", cartaPorte.getCartaPorteData().getTranspInternac());
    assertNotNull(cartaPorte.getCartaPorteData().getMercancias());
    assertEquals(0, cartaPorte.getCartaPorteData().getMercancias().getMercancia().size());

    var comercioExterior = invoice.getComplements().get(4);
    assertEquals("comercio_exterior", comercioExterior.getType());
    assertNotNull(comercioExterior.getComercioExteriorData());
    assertEquals("A1", comercioExterior.getComercioExteriorData().getClaveDePedimento());
    assertEquals(100.5, comercioExterior.getComercioExteriorData().getTotalUsd(), 0.0001);
    assertEquals(Boolean.TRUE, comercioExterior.getComercioExteriorData().getEmisorFromOrganization());
    assertEquals("cus_owner_1", comercioExterior.getComercioExteriorData().getPropietario().get(0).getId());
    assertEquals("SKU-1", comercioExterior.getComercioExteriorData().getMercancias().getMercancia().get(0).getNoIdentificacion());
  }

  @Test
  void objectMapperDeserializesJavaTimeTypes() throws Exception {
    var mapper = FacturapiConfig.builder("sk_test").build().getObjectMapper();

    var customer = mapper.readValue(
      "{\"created_at\":\"2026-04-07T10:11:12Z\",\"sat_validated_at\":\"2026-04-07T11:11:12Z\",\"edit_link_expires_at\":\"2026-04-08T00:00:00Z\"}",
      Customer.class
    );

    assertEquals(Instant.parse("2026-04-07T10:11:12Z"), customer.getCreatedAt());
    assertEquals(Instant.parse("2026-04-07T11:11:12Z"), customer.getSatValidatedAt());
    assertEquals(Instant.parse("2026-04-08T00:00:00Z"), customer.getEditLinkExpiresAt());
  }

  @Test
  void objectMapperDeserializesCodeEnums() throws Exception {
    var mapper = FacturapiConfig.builder("sk_test").build().getObjectMapper();

    var tax = mapper.readValue("{\"type\":\"IEPS\",\"factor\":\"Exento\"}", io.facturapi.models.Tax.class);
    assertEquals(TaxType.IEPS, tax.getType());
    assertEquals(TaxFactor.EXENTO, tax.getFactor());
  }
}
