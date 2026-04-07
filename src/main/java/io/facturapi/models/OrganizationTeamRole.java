package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationTeamRole {
  private String id;
  private String name;
  @JsonProperty("template_code")
  private String templateCode;
  private String scope;
  private String organization;
  private List<String> operations = new ArrayList<>();
  @JsonProperty("used_by")
  private Integer usedBy;
  @JsonProperty("created_at")
  private String createdAt;
  @JsonProperty("updated_at")
  private String updatedAt;
  @JsonProperty("created_by")
  private Map<String, Object> createdBy;
  @JsonProperty("updated_by")
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
  public String getCreatedAt() { return createdAt; }
  public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
  public String getUpdatedAt() { return updatedAt; }
  public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
  public Map<String, Object> getCreatedBy() { return createdBy; }
  public void setCreatedBy(Map<String, Object> createdBy) { this.createdBy = createdBy; }
  public Map<String, Object> getUpdatedBy() { return updatedBy; }
  public void setUpdatedBy(Map<String, Object> updatedBy) { this.updatedBy = updatedBy; }
}
