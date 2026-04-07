package io.facturapi;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

final class StubHttpClient {
  static final class QueuedResponse {
    final int statusCode;
    final byte[] body;
    final Map<String, List<String>> headers;

    QueuedResponse(int statusCode, byte[] body, Map<String, List<String>> headers) {
      this.statusCode = statusCode;
      this.body = body;
      this.headers = headers;
    }
  }

  static final class RecordedHeaders {
    private final Headers headers;

    RecordedHeaders(Headers headers) {
      this.headers = headers;
    }

    Optional<String> firstValue(String name) {
      return Optional.ofNullable(headers.values(name).stream().findFirst().orElse(null));
    }
  }

  static final class RecordedRequest {
    private final Request request;

    RecordedRequest(Request request) {
      this.request = request;
    }

    String method() {
      return request.method();
    }

    URI uri() {
      return request.url().uri();
    }

    RecordedHeaders headers() {
      return new RecordedHeaders(request.headers());
    }

    String bodyUtf8() {
      RequestBody body = request.body();
      if (body == null) {
        return "";
      }
      Buffer buffer = new Buffer();
      try {
        body.writeTo(buffer);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      return buffer.readString(StandardCharsets.UTF_8);
    }
  }

  private final Deque<QueuedResponse> queue = new ArrayDeque<>();
  private final List<RecordedRequest> requests = new ArrayList<>();
  private final OkHttpClient client;

  StubHttpClient() {
    this.client = new OkHttpClient.Builder()
      .addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
          Request request = chain.request();
          requests.add(new RecordedRequest(request));
          QueuedResponse queued = queue.poll();
          if (queued == null) {
            throw new IOException("No queued response");
          }
          return buildResponse(request, queued);
        }
      })
      .build();
  }

  OkHttpClient client() {
    return client;
  }

  void enqueueJson(int statusCode, String json) {
    queue.add(
      new QueuedResponse(
        statusCode,
        json.getBytes(StandardCharsets.UTF_8),
        Map.of("Content-Type", List.of("application/json"))
      )
    );
  }

  void enqueueBinary(int statusCode, byte[] bytes, String contentType) {
    queue.add(new QueuedResponse(statusCode, bytes, Map.of("Content-Type", List.of(contentType))));
  }

  List<RecordedRequest> requests() {
    return requests;
  }

  private static Response buildResponse(Request request, QueuedResponse queued) {
    Headers headers = toHeaders(queued.headers);
    MediaType mediaType = headers.get("Content-Type") == null ? null : MediaType.get(headers.get("Content-Type"));
    ResponseBody body = ResponseBody.create(queued.body, mediaType);
    return new Response.Builder()
      .request(request)
      .protocol(Protocol.HTTP_1_1)
      .code(queued.statusCode)
      .message(queued.statusCode >= 200 && queued.statusCode < 300 ? "OK" : "ERROR")
      .headers(headers)
      .body(body)
      .build();
  }

  private static Headers toHeaders(Map<String, List<String>> headers) {
    Headers.Builder builder = new Headers.Builder();
    for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
      for (String value : entry.getValue()) {
        builder.add(entry.getKey(), value);
      }
    }
    return builder.build();
  }
}
