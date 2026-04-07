package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationTeamRoleTemplate {
  private String code;
  private String name;
  private String description;
  private List<String> operations = new ArrayList<>();

  public String getCode() { return code; }
  public void setCode(String code) { this.code = code; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public List<String> getOperations() { return operations; }
  public void setOperations(List<String> operations) { this.operations = operations; }
}
