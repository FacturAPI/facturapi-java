package com.facturapi;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.facturapi.http.FacturapiConfig;
import com.facturapi.http.FacturapiHttpClient;
import java.io.IOException;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacturapiHttpClientTest {
  private MockWebServer server;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();
  }

  @AfterEach
  void tearDown() throws IOException {
    server.shutdown();
  }

  @Test
  void sendsBearerAuthAndParsesJson() throws Exception {
    server.enqueue(new MockResponse()
      .setHeader("Content-Type", "application/json")
      .setBody("{\"ok\":true}"));

    FacturapiHttpClient client = new FacturapiHttpClient(
      FacturapiConfig.builder("sk_test_123")
        .baseUrl(server.url("/").toString())
        .build()
    );

    var response = client.postJson("/invoices", Map.of("foo", "bar"), Map.of("page", 1));
    assertTrue(response.get("ok").asBoolean());

    RecordedRequest request = server.takeRequest();
    assertEquals("Bearer sk_test_123", request.getHeader("Authorization"));
    assertEquals("POST", request.getMethod());
    assertEquals("/invoices?page=1", request.getPath());
  }

  @Test
  void returnsBinaryBytesForPdf() {
    byte[] payload = "PDF-CONTENT".getBytes();
    server.enqueue(new MockResponse()
      .setHeader("Content-Type", "application/pdf")
      .setBody(new okio.Buffer().write(payload)));

    FacturapiHttpClient client = new FacturapiHttpClient(
      FacturapiConfig.builder("sk_test_123")
        .baseUrl(server.url("/").toString())
        .build()
    );

    assertArrayEquals(payload, client.getBytes("/invoices/inv_1/pdf"));
  }

  @Test
  void throwsFacturapiExceptionWithApiMessage() {
    server.enqueue(new MockResponse()
      .setResponseCode(400)
      .setHeader("Content-Type", "application/json")
      .setBody("{\"message\":\"Invalid customer\"}"));

    FacturapiHttpClient client = new FacturapiHttpClient(
      FacturapiConfig.builder("sk_test_123")
        .baseUrl(server.url("/").toString())
        .build()
    );

    FacturapiException ex = assertThrows(
      FacturapiException.class,
      () -> client.getJson("/customers/cus_1", null)
    );

    assertEquals(400, ex.getStatusCode());
    assertTrue(ex.getMessage().contains("Invalid customer"));
  }
}
