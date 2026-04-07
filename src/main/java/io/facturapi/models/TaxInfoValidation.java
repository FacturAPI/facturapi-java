package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxInfoValidation {
  @JsonAlias({"valid"})
  private Boolean isValid;
  private List<TaxInfoValidationError> errors = new ArrayList<>();
  private String status;

  public Boolean getIsValid() { return isValid; }
  public void setIsValid(Boolean isValid) { this.isValid = isValid; }
  public List<TaxInfoValidationError> getErrors() { return errors; }
  public void setErrors(List<TaxInfoValidationError> errors) { this.errors = errors; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
}
