package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class XmlNamespace {
  private String prefix;
  private String uri;
  @JsonProperty("schema_location")
  private String schemaLocation;

  public String getPrefix() { return prefix; }
  public void setPrefix(String prefix) { this.prefix = prefix; }
  public String getUri() { return uri; }
  public void setUri(String uri) { this.uri = uri; }
  public String getSchemaLocation() { return schemaLocation; }
  public void setSchemaLocation(String schemaLocation) { this.schemaLocation = schemaLocation; }
}
