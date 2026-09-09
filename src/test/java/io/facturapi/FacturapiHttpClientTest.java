package io.facturapi;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.facturapi.http.FacturapiConfig;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.models.GenericResponse;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FacturapiHttpClientTest {
  @Test
  void sendsBearerAuthAndParsesTypedJson() throws Exception {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueJson(200, "{\"ok\":true}");

    FacturapiHttpClient client = new FacturapiHttpClient(
      FacturapiConfig.builder("sk_test_123")
        .httpClient(httpClient.client())
        .build()
    );

    GenericResponse response = client.post("/invoices", Map.of("foo", "bar"), Map.of("page", 1), GenericResponse.class);
    assertTrue(response.isOk());

    var request = httpClient.requests().get(0);
    assertEquals("Bearer sk_test_123", request.headers().firstValue("Authorization").orElse(""));
    assertEquals("POST", request.method());
    assertEquals("/v2/invoices?page=1", request.uri().getPath() + "?" + request.uri().getQuery());
  }

  @Test
  void returnsBinaryBytesForPdf() {
    StubHttpClient httpClient = new StubHttpClient();
    byte[] payload = "PDF-CONTENT".getBytes();
    httpClient.enqueueBinary(200, payload, "application/pdf");

    FacturapiHttpClient client = new FacturapiHttpClient(
      FacturapiConfig.builder("sk_test_123")
        .httpClient(httpClient.client())
        .build()
    );

    assertArrayEquals(payload, client.getBytes("/invoices/inv_1/pdf"));
  }

  @Test
  void throwsFacturapiExceptionWithApiMessage() {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueJson(
      400,
      "{\"message\":\"Invalid customer\",\"status\":\"400\",\"code\":\"validation_error\",\"path\":\"customer.tax_id\",\"location\":\"body\",\"errors\":[{\"code\":\"required\",\"message\":\"tax id is required\",\"path\":\"customer.tax_id\",\"location\":\"body\"}]}",
      Map.of("Retry-After", java.util.List.of("3"), "x-facturapi-log-id", java.util.List.of("log_123"))
    );

    FacturapiHttpClient client = new FacturapiHttpClient(
      FacturapiConfig.builder("sk_test_123")
        .httpClient(httpClient.client())
        .build()
    );

    FacturapiException ex = assertThrows(
      FacturapiException.class,
      () -> client.get("/customers/cus_1", null, GenericResponse.class)
    );

    assertEquals(400, ex.getStatusCode());
    assertTrue(ex.getMessage().contains("Invalid customer"));
    assertEquals("validation_error", ex.getErrorCode());
    assertEquals("customer.tax_id", ex.getErrorPath());
    assertEquals("body", ex.getErrorLocation());
    assertEquals("log_123", ex.getLogId());
    assertEquals("required", ex.getErrors().get(0).get("code").asText());
    assertEquals("3", ex.getHeaders().get("Retry-After").get(0));
    assertEquals("log_123", ex.getHeaders().get("x-facturapi-log-id").get(0));
  }

  @Test
  void serializesNestedDateRangeQueryWithBracketNotation() throws Exception {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueJson(200, "{\"data\":[]}");

    FacturapiHttpClient client = new FacturapiHttpClient(
      FacturapiConfig.builder("sk_test_123")
        .httpClient(httpClient.client())
        .build()
    );

    client.get(
      "/invoices",
      Map.of("limit", 100, "date", Map.of("gte", "2026-01-01", "lt", "2026-02-01")),
      GenericResponse.class
    );

    var request = httpClient.requests().get(0);
    String query = request.uri().getQuery();
    assertTrue(query.contains("limit=100"));
    assertTrue(query.contains("date[gte]=2026-01-01"));
    assertTrue(query.contains("date[lt]=2026-02-01"));
    assertFalse(query.contains("{gte"));
  }

  @Test
  void convertsNumericApiErrorCodesToStrings() {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueJson(400, "{\"message\":\"Invalid customer\",\"code\":400}");

    FacturapiHttpClient client = new FacturapiHttpClient(
      FacturapiConfig.builder("sk_test_123")
        .httpClient(httpClient.client())
        .build()
    );

    FacturapiException ex = assertThrows(
      FacturapiException.class,
      () -> client.get("/customers/cus_1", null, GenericResponse.class)
    );

    assertEquals("400", ex.getErrorCode());
  }
}
