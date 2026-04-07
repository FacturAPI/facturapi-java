package io.facturapi.http;

import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class MultipartBodyBuilder {
  private static final String CRLF = "\r\n";
  private final String boundary = "----FacturapiJava" + UUID.randomUUID();
  private final List<byte[]> parts = new ArrayList<>();

  public MultipartBodyBuilder addField(String name, String value) {
    StringBuilder builder = new StringBuilder();
    builder.append("--").append(boundary).append(CRLF);
    builder.append("Content-Disposition: form-data; name=\"").append(name).append("\"").append(CRLF);
    builder.append(CRLF);
    builder.append(value == null ? "" : value).append(CRLF);
    parts.add(builder.toString().getBytes(StandardCharsets.UTF_8));
    return this;
  }

  public MultipartBodyBuilder addFile(String fieldName, String fileName, byte[] content, String contentType) {
    StringBuilder builder = new StringBuilder();
    builder.append("--").append(boundary).append(CRLF);
    builder.append("Content-Disposition: form-data; name=\"").append(fieldName)
      .append("\"; filename=\"").append(fileName).append("\"").append(CRLF);
    builder.append("Content-Type: ").append(contentType).append(CRLF);
    builder.append(CRLF);
    parts.add(builder.toString().getBytes(StandardCharsets.UTF_8));
    parts.add(content);
    parts.add(CRLF.getBytes(StandardCharsets.UTF_8));
    return this;
  }

  public MultipartBody build() {
    String ending = "--" + boundary + "--" + CRLF;
    parts.add(ending.getBytes(StandardCharsets.UTF_8));
    HttpRequest.BodyPublisher publisher = HttpRequest.BodyPublishers.ofByteArrays(parts);
    return new MultipartBody(publisher, "multipart/form-data; boundary=" + boundary);
  }
}
