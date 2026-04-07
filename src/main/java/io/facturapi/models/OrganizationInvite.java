package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationInvite {
  private String id;
  @JsonProperty("created_at")
  private Instant createdAt;
  private String email;
  @JsonProperty("organization_name")
  private String organizationName;
  private String role;
  @JsonProperty("role_name")
  private String roleName;
  private List<String> roles = new ArrayList<>();
  @JsonProperty("expires_at")
  private Instant expiresAt;
  private String status;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getOrganizationName() { return organizationName; }
  public void setOrganizationName(String organizationName) { this.organizationName = organizationName; }
  public String getRole() { return role; }
  public void setRole(String role) { this.role = role; }
  public String getRoleName() { return roleName; }
  public void setRoleName(String roleName) { this.roleName = roleName; }
  public List<String> getRoles() { return roles; }
  public void setRoles(List<String> roles) { this.roles = roles; }
  public Instant getExpiresAt() { return expiresAt; }
  public void setExpiresAt(Instant expiresAt) { this.expiresAt = expiresAt; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
}
