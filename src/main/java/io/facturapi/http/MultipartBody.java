package io.facturapi.http;

import java.net.http.HttpRequest;

public final class MultipartBody {
  private final HttpRequest.BodyPublisher publisher;
  private final String contentType;

  public MultipartBody(HttpRequest.BodyPublisher publisher, String contentType) {
    this.publisher = publisher;
    this.contentType = contentType;
  }

  public HttpRequest.BodyPublisher getPublisher() {
    return publisher;
  }

  public String getContentType() {
    return contentType;
  }
}
