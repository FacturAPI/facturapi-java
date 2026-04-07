package io.facturapi.http;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public final class MultipartBodyBuilder {
  private static final MediaType OCTET_STREAM = MediaType.get("application/octet-stream");
  private final okhttp3.MultipartBody.Builder builder = new okhttp3.MultipartBody.Builder()
    .setType(okhttp3.MultipartBody.FORM);

  public MultipartBodyBuilder addField(String name, String value) {
    builder.addFormDataPart(name, value == null ? "" : value);
    return this;
  }

  public MultipartBodyBuilder addFile(String fieldName, String fileName, byte[] content, String contentType) {
    MediaType mediaType = contentType == null ? OCTET_STREAM : MediaType.get(contentType);
    builder.addFormDataPart(fieldName, fileName, RequestBody.create(content, mediaType));
    return this;
  }

  public MultipartBody build() {
    okhttp3.MultipartBody multipartBody = builder.build();
    return new MultipartBody(multipartBody, multipartBody.contentType().toString());
  }
}
