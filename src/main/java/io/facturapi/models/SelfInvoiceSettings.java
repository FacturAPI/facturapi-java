package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SelfInvoiceSettings {
  @JsonProperty("allowed_cfdi_uses")
  private List<String> allowedCfdiUses = new ArrayList<>();
  @JsonProperty("apply_resico_isr")
  private Boolean applyResicoIsr;
  @JsonProperty("support_email")
  private String supportEmail;
  @JsonProperty("support_email_verified")
  private Boolean supportEmailVerified;

  public List<String> getAllowedCfdiUses() { return allowedCfdiUses; }
  public void setAllowedCfdiUses(List<String> allowedCfdiUses) { this.allowedCfdiUses = allowedCfdiUses; }
  public Boolean getApplyResicoIsr() { return applyResicoIsr; }
  public void setApplyResicoIsr(Boolean applyResicoIsr) { this.applyResicoIsr = applyResicoIsr; }
  public String getSupportEmail() { return supportEmail; }
  public void setSupportEmail(String supportEmail) { this.supportEmail = supportEmail; }
  public Boolean getSupportEmailVerified() { return supportEmailVerified; }
  public void setSupportEmailVerified(Boolean supportEmailVerified) { this.supportEmailVerified = supportEmailVerified; }
}
