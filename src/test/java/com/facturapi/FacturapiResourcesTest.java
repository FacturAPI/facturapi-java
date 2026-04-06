package com.facturapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacturapiResourcesTest {
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
  void invoiceCreateUsesExpectedPathAndBody() throws Exception {
    server.enqueue(new MockResponse()
      .setHeader("Content-Type", "application/json")
      .setBody("{\"id\":\"inv_1\"}"));

    Facturapi sdk = Facturapi.builder("sk_test").baseUrl(server.url("/").toString()).build();
    var response = sdk.invoices.create(Map.of("customer", "cus_1"), Map.of("test", true));

    assertEquals("inv_1", response.get("id").asText());

    RecordedRequest request = server.takeRequest();
    assertEquals("POST", request.getMethod());
    assertEquals("/invoices?test=true", request.getPath());
    assertTrue(request.getBody().readUtf8().contains("\"customer\":\"cus_1\""));
  }

  @Test
  void organizationBackwardCompatibleAliasWorks() throws Exception {
    server.enqueue(new MockResponse()
      .setHeader("Content-Type", "application/json")
      .setBody("[{\"id\":\"live_1\"}]"));

    Facturapi sdk = Facturapi.builder("sk_test").baseUrl(server.url("/").toString()).build();
    var response = sdk.organizations.lisLiveApiKeys("org_1");

    assertTrue(response.isArray());
    RecordedRequest request = server.takeRequest();
    assertEquals("/organizations/org_1/apikeys/live", request.getPath());
  }
}
