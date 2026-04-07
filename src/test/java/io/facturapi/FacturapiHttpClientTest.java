package io.facturapi;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        .httpClient(httpClient)
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
        .httpClient(httpClient)
        .build()
    );

    assertArrayEquals(payload, client.getBytes("/invoices/inv_1/pdf"));
  }

  @Test
  void throwsFacturapiExceptionWithApiMessage() {
    StubHttpClient httpClient = new StubHttpClient();
    httpClient.enqueueJson(400, "{\"message\":\"Invalid customer\",\"status\":\"400\",\"ok\":false,\"code\":\"validation_error\",\"path\":\"customer.tax_id\"}");

    FacturapiHttpClient client = new FacturapiHttpClient(
      FacturapiConfig.builder("sk_test_123")
        .httpClient(httpClient)
        .build()
    );

    FacturapiException ex = assertThrows(
      FacturapiException.class,
      () -> client.get("/customers/cus_1", null, GenericResponse.class)
    );

    assertEquals(400, ex.getStatusCode());
    assertTrue(ex.getMessage().contains("Invalid customer"));
    assertNotNull(ex.getApiError());
    assertEquals("Invalid customer", ex.getApiError().getMessage());
    assertEquals(400, ex.getApiError().getStatus());
    assertFalse(ex.getApiError().isOk());
    assertEquals("validation_error", ex.getApiError().getCode());
    assertEquals("customer.tax_id", ex.getApiError().getPath());
  }
}
