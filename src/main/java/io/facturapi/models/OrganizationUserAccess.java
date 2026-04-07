package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationUserAccess {
  private String id;
  @JsonProperty("full_name")
  private String fullName;
  private String email;
  private String role;
  @JsonProperty("role_name")
  private String roleName;
  private String organization;
  private List<String> operations = new ArrayList<>();
  @JsonProperty("created_at")
  private Instant createdAt;
  @JsonProperty("updated_at")
  private Instant updatedAt;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getFullName() { return fullName; }
  public void setFullName(String fullName) { this.fullName = fullName; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getRole() { return role; }
  public void setRole(String role) { this.role = role; }
  public String getRoleName() { return roleName; }
  public void setRoleName(String roleName) { this.roleName = roleName; }
  public String getOrganization() { return organization; }
  public void setOrganization(String organization) { this.organization = organization; }
  public List<String> getOperations() { return operations; }
  public void setOperations(List<String> operations) { this.operations = operations; }
  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
  public Instant getUpdatedAt() { return updatedAt; }
  public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
