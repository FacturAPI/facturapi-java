package io.facturapi;

import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

final class StubHttpClient extends HttpClient {
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

  private final Deque<QueuedResponse> queue = new ArrayDeque<>();
  private final List<HttpRequest> requests = new ArrayList<>();

  void enqueueJson(int statusCode, String json) {
    queue.add(new QueuedResponse(statusCode, json.getBytes(), Map.of("Content-Type", List.of("application/json"))));
  }

  void enqueueBinary(int statusCode, byte[] bytes, String contentType) {
    queue.add(new QueuedResponse(statusCode, bytes, Map.of("Content-Type", List.of(contentType))));
  }

  List<HttpRequest> requests() {
    return requests;
  }

  @Override
  public Optional<CookieHandler> cookieHandler() {
    return Optional.empty();
  }

  @Override
  public Optional<Duration> connectTimeout() {
    return Optional.empty();
  }

  @Override
  public Redirect followRedirects() {
    return Redirect.NEVER;
  }

  @Override
  public Optional<ProxySelector> proxy() {
    return Optional.empty();
  }

  @Override
  public SSLContext sslContext() {
    try {
      return SSLContext.getDefault();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public SSLParameters sslParameters() {
    return new SSLParameters();
  }

  @Override
  public Optional<Authenticator> authenticator() {
    return Optional.empty();
  }

  @Override
  public Version version() {
    return Version.HTTP_1_1;
  }

  @Override
  public Optional<Executor> executor() {
    return Optional.empty();
  }

  @Override
  public <T> HttpResponse<T> send(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler)
    throws IOException, InterruptedException {
    requests.add(request);
    QueuedResponse queued = queue.poll();
    if (queued == null) {
      throw new IOException("No queued response");
    }
    @SuppressWarnings("unchecked")
    T body = (T) queued.body;
    return new StubHttpResponse<>(request, queued.statusCode, body, queued.headers);
  }

  @Override
  public <T> CompletableFuture<HttpResponse<T>> sendAsync(
    HttpRequest request,
    HttpResponse.BodyHandler<T> responseBodyHandler
  ) {
    try {
      return CompletableFuture.completedFuture(send(request, responseBodyHandler));
    } catch (IOException | InterruptedException e) {
      CompletableFuture<HttpResponse<T>> future = new CompletableFuture<>();
      future.completeExceptionally(e);
      return future;
    }
  }

  @Override
  public <T> CompletableFuture<HttpResponse<T>> sendAsync(
    HttpRequest request,
    HttpResponse.BodyHandler<T> responseBodyHandler,
    HttpResponse.PushPromiseHandler<T> pushPromiseHandler
  ) {
    return sendAsync(request, responseBodyHandler);
  }

  private static final class StubHttpResponse<T> implements HttpResponse<T> {
    private final HttpRequest request;
    private final int statusCode;
    private final T body;
    private final HttpHeaders headers;

    StubHttpResponse(HttpRequest request, int statusCode, T body, Map<String, List<String>> headers) {
      this.request = request;
      this.statusCode = statusCode;
      this.body = body;
      this.headers = HttpHeaders.of(headers, (k, v) -> true);
    }

    @Override
    public int statusCode() {
      return statusCode;
    }

    @Override
    public HttpRequest request() {
      return request;
    }

    @Override
    public Optional<HttpResponse<T>> previousResponse() {
      return Optional.empty();
    }

    @Override
    public HttpHeaders headers() {
      return headers;
    }

    @Override
    public T body() {
      return body;
    }

    @Override
    public Optional<SSLSession> sslSession() {
      return Optional.empty();
    }

    @Override
    public URI uri() {
      return request.uri();
    }

    @Override
    public Version version() {
      return Version.HTTP_1_1;
    }
  }
}
