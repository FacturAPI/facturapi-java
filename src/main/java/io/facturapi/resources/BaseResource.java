package io.facturapi.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import java.util.Map;

public abstract class BaseResource {
  protected final FacturapiHttpClient client;

  protected BaseResource(FacturapiHttpClient client) {
    this.client = client;
  }

  protected <T> T get(String path, Map<String, ?> params, Class<T> responseType) {
    return client.get(path, params, responseType);
  }

  protected <T> T get(String path, Map<String, ?> params, TypeReference<T> typeReference) {
    return client.get(path, params, typeReference);
  }

  protected <T> T post(String path, Object body, Map<String, ?> params, Class<T> responseType) {
    return client.post(path, body, params, responseType);
  }

  protected <T> T post(String path, Object body, Map<String, ?> params, TypeReference<T> typeReference) {
    return client.post(path, body, params, typeReference);
  }

  protected <T> T put(String path, Object body, Map<String, ?> params, Class<T> responseType) {
    return client.put(path, body, params, responseType);
  }

  protected <T> T put(String path, Object body, Map<String, ?> params, TypeReference<T> typeReference) {
    return client.put(path, body, params, typeReference);
  }

  protected <T> T delete(String path, Map<String, ?> params, Class<T> responseType) {
    return client.delete(path, params, responseType);
  }

  protected <T> T delete(String path, Map<String, ?> params, TypeReference<T> typeReference) {
    return client.delete(path, params, typeReference);
  }
}
