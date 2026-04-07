package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationTeamRole {
  private String id;
  private String name;
  private String templateCode;
  private String scope;
  private String organization;
  private List<String> operations = new ArrayList<>();
  private Integer usedBy;
  private Instant createdAt;
  private Instant updatedAt;
  private Map<String, Object> createdBy;
  private Map<String, Object> updatedBy;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getTemplateCode() { return templateCode; }
  public void setTemplateCode(String templateCode) { this.templateCode = templateCode; }
  public String getScope() { return scope; }
  public void setScope(String scope) { this.scope = scope; }
  public String getOrganization() { return organization; }
  public void setOrganization(String organization) { this.organization = organization; }
  public List<String> getOperations() { return operations; }
  public void setOperations(List<String> operations) { this.operations = operations; }
  public Integer getUsedBy() { return usedBy; }
  public void setUsedBy(Integer usedBy) { this.usedBy = usedBy; }
  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
  public Instant getUpdatedAt() { return updatedAt; }
  public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
  public Map<String, Object> getCreatedBy() { return createdBy; }
  public void setCreatedBy(Map<String, Object> createdBy) { this.createdBy = createdBy; }
  public Map<String, Object> getUpdatedBy() { return updatedBy; }
  public void setUpdatedBy(Map<String, Object> updatedBy) { this.updatedBy = updatedBy; }
}
