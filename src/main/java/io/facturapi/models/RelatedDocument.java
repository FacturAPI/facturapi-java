package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelatedDocument {
  private String relationship;
  private String uuid;

  public String getRelationship() { return relationship; }
  public void setRelationship(String relationship) { this.relationship = relationship; }
  public String getUuid() { return uuid; }
  public void setUuid(String uuid) { this.uuid = uuid; }
}
