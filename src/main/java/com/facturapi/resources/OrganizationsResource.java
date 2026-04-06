package com.facturapi.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.facturapi.http.FacturapiHttpClient;
import com.facturapi.http.MultipartBody;
import com.facturapi.http.MultipartBodyBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class OrganizationsResource extends BaseResource {
  public OrganizationsResource(FacturapiHttpClient client) {
    super(client);
  }

  public JsonNode create(Object data) {
    return post("/organizations", data, null);
  }

  public JsonNode list(Map<String, ?> params) {
    return get("/organizations", params);
  }

  public JsonNode all(Map<String, ?> params) {
    return list(params);
  }

  public JsonNode retrieve(String id) {
    return get("/organizations/" + id, null);
  }

  public JsonNode updateLegal(String id, Object data) {
    return put("/organizations/" + id + "/legal", data, null);
  }

  public JsonNode updateCustomization(String id, Object data) {
    return put("/organizations/" + id + "/customization", data, null);
  }

  public JsonNode updateReceiptSettings(String id, Object data) {
    return put("/organizations/" + id + "/receipts", data, null);
  }

  public JsonNode updateDomain(String id, Object data) {
    return put("/organizations/" + id + "/domain", data, null);
  }

  public JsonNode checkDomainAvailability(Map<String, ?> query) {
    return get("/organizations/domain-check", query);
  }

  @Deprecated
  public JsonNode checkDomainIsAvailable(Map<String, ?> query) {
    return checkDomainAvailability(query);
  }

  public JsonNode uploadLogo(String id, Path filePath) throws IOException {
    byte[] fileBytes = Files.readAllBytes(filePath);
    MultipartBody multipartBody = new MultipartBodyBuilder()
      .addFile("file", filePath.getFileName().toString(), fileBytes, "application/octet-stream")
      .build();
    return client.putMultipart("/organizations/" + id + "/logo", multipartBody);
  }

  public JsonNode uploadCertificate(String id, Path cerFile, Path keyFile, String password) throws IOException {
    MultipartBody multipartBody = new MultipartBodyBuilder()
      .addFile("cer", cerFile.getFileName().toString(), Files.readAllBytes(cerFile), "application/octet-stream")
      .addFile("key", keyFile.getFileName().toString(), Files.readAllBytes(keyFile), "application/octet-stream")
      .addField("password", password)
      .build();
    return client.putMultipart("/organizations/" + id + "/certificate", multipartBody);
  }

  public JsonNode deleteCertificate(String id) {
    return delete("/organizations/" + id + "/certificate", null);
  }

  public JsonNode delete(String id) {
    return delete("/organizations/" + id, null);
  }

  public JsonNode del(String id) {
    return delete(id);
  }

  public JsonNode getTestApiKey(String id) {
    return get("/organizations/" + id + "/apikeys/test", null);
  }

  public JsonNode renewTestApiKey(String id) {
    return put("/organizations/" + id + "/apikeys/test", null, null);
  }

  public JsonNode listLiveApiKeys(String id) {
    return get("/organizations/" + id + "/apikeys/live", null);
  }

  @Deprecated
  public JsonNode lisLiveApiKeys(String id) {
    return listLiveApiKeys(id);
  }

  public JsonNode renewLiveApiKey(String id) {
    return put("/organizations/" + id + "/apikeys/live", null, null);
  }

  public JsonNode deleteLiveApiKey(String organizationId, String apiKeyId) {
    return delete("/organizations/" + organizationId + "/apikeys/live/" + apiKeyId, null);
  }

  public JsonNode listSeriesGroup(String organizationId) {
    return get("/organizations/" + organizationId + "/series-group", null);
  }

  public JsonNode createSeriesGroup(String organizationId, Object seriesData) {
    return post("/organizations/" + organizationId + "/series-group", seriesData, null);
  }

  public JsonNode updateSeriesGroup(String organizationId, String seriesName, Object data) {
    return put("/organizations/" + organizationId + "/series-group/" + seriesName, data, null);
  }

  public JsonNode deleteSeriesGroup(String organizationId, String seriesName) {
    return delete("/organizations/" + organizationId + "/series-group/" + seriesName, null);
  }

  public JsonNode me() {
    return get("/organizations/me", null);
  }

  public JsonNode updateSelfInvoiceSettings(String id, Object data) {
    return put("/organizations/" + id + "/self-invoice", data, null);
  }

  public JsonNode listTeamAccess(String organizationId) {
    return get("/organizations/" + organizationId + "/team", null);
  }

  public JsonNode retrieveTeamAccess(String organizationId, String accessId) {
    return get("/organizations/" + organizationId + "/team/" + accessId, null);
  }

  public JsonNode updateTeamAccessRole(String organizationId, String accessId, String role) {
    return put("/organizations/" + organizationId + "/team/" + accessId + "/role", Map.of("role", role), null);
  }

  public JsonNode removeTeamAccess(String organizationId, String accessId) {
    return delete("/organizations/" + organizationId + "/team/" + accessId, null);
  }

  public JsonNode listSentTeamInvites(String organizationId) {
    return get("/organizations/" + organizationId + "/team/invites", null);
  }

  public JsonNode inviteUserToTeam(String organizationId, Object data) {
    return post("/organizations/" + organizationId + "/team/invites", data, null);
  }

  public JsonNode cancelTeamInvite(String organizationId, String inviteKey) {
    return delete("/organizations/" + organizationId + "/team/invites/" + inviteKey, null);
  }

  public JsonNode listReceivedTeamInvites() {
    return get("/organizations/invites/pending", null);
  }

  public JsonNode respondTeamInvite(String inviteKey, Object data) {
    return post("/organizations/invites/" + inviteKey + "/response", data, null);
  }

  public JsonNode listTeamRoles(String organizationId) {
    return get("/organizations/" + organizationId + "/team/roles", null);
  }

  public JsonNode listTeamRoleTemplates(String organizationId) {
    return get("/organizations/" + organizationId + "/team/roles/templates", null);
  }

  public JsonNode listTeamRoleOperations(String organizationId) {
    return get("/organizations/" + organizationId + "/team/roles/operations", null);
  }

  public JsonNode retrieveTeamRole(String organizationId, String roleId) {
    return get("/organizations/" + organizationId + "/team/roles/" + roleId, null);
  }

  public JsonNode createTeamRole(String organizationId, Object data) {
    return post("/organizations/" + organizationId + "/team/roles", data, null);
  }

  public JsonNode updateTeamRole(String organizationId, String roleId, Object data) {
    return put("/organizations/" + organizationId + "/team/roles/" + roleId, data, null);
  }

  public JsonNode deleteTeamRole(String organizationId, String roleId) {
    return delete("/organizations/" + organizationId + "/team/roles/" + roleId, null);
  }
}
