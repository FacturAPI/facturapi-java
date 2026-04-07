package io.facturapi.http;

import okhttp3.RequestBody;

public final class MultipartBody {
  private final RequestBody body;
  private final String contentType;

  public MultipartBody(RequestBody body, String contentType) {
    this.body = body;
    this.contentType = contentType;
  }

  public RequestBody getBody() {
    return body;
  }

  public String getContentType() {
    return contentType;
  }
}
