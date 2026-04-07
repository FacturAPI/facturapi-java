package io.facturapi.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.facturapi.http.FacturapiHttpClient;
import io.facturapi.http.MultipartBody;
import io.facturapi.http.MultipartBodyBuilder;
import io.facturapi.models.ApiKey;
import io.facturapi.models.DomainAvailability;
import io.facturapi.models.GenericResponse;
import io.facturapi.models.Organization;
import io.facturapi.models.OrganizationInvite;
import io.facturapi.models.OrganizationTeamRole;
import io.facturapi.models.OrganizationTeamRoleTemplate;
import io.facturapi.models.OrganizationUserAccess;
import io.facturapi.models.SearchResult;
import io.facturapi.models.Series;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class OrganizationsResource extends BaseResource {
  /**
   * Organization endpoints.
   *
   * @see <a href="https://docs.facturapi.io/api#tag/Organizations">API reference</a>
   */
  public OrganizationsResource(FacturapiHttpClient client) {
    super(client);
  }

  /**
   * Creates a new organization for your account.
   */
  public Organization create(Map<String, Object> data) {
    return post("/organizations", data, null, Organization.class);
  }

  /**
   * Gets a paginated list of organizations for your account.
   */
  public SearchResult<Organization> list(Map<String, ?> params) {
    return get("/organizations", params, new TypeReference<SearchResult<Organization>>() {});
  }

  /**
   * Gets a single organization by id.
   */
  public Organization retrieve(String id) {
    return get("/organizations/" + id, null, Organization.class);
  }

  /**
   * Updates the organization's legal information.
   */
  public Organization updateLegal(String id, Map<String, Object> data) {
    return put("/organizations/" + id + "/legal", data, null, Organization.class);
  }

  /**
   * Updates the organization's customization settings.
   */
  public Organization updateCustomization(String id, Map<String, Object> data) {
    return put("/organizations/" + id + "/customization", data, null, Organization.class);
  }

  /**
   * Updates receipt settings for an organization.
   */
  public Organization updateReceiptSettings(String id, Map<String, Object> data) {
    return put("/organizations/" + id + "/receipts", data, null, Organization.class);
  }

  /**
   * Updates domain settings for self-invoice.
   */
  public Organization updateDomain(String id, Map<String, Object> data) {
    return put("/organizations/" + id + "/domain", data, null, Organization.class);
  }

  /**
   * Checks whether a domain is available.
   */
  public DomainAvailability checkDomainAvailability(Map<String, ?> query) {
    return get("/organizations/domain-check", query, DomainAvailability.class);
  }

  /**
   * Uploads organization logo file.
   */
  public Organization uploadLogo(String id, Path filePath) throws IOException {
    byte[] fileBytes = Files.readAllBytes(filePath);
    MultipartBody multipartBody = new MultipartBodyBuilder()
      .addFile("file", filePath.getFileName().toString(), fileBytes, "application/octet-stream")
      .build();
    return client.putMultipart("/organizations/" + id + "/logo", multipartBody, Organization.class);
  }

  /**
   * Uploads organization CSD certificate files.
   */
  public Organization uploadCertificate(String id, Path cerFile, Path keyFile, String password) throws IOException {
    MultipartBody multipartBody = new MultipartBodyBuilder()
      .addFile("cer", cerFile.getFileName().toString(), Files.readAllBytes(cerFile), "application/octet-stream")
      .addFile("key", keyFile.getFileName().toString(), Files.readAllBytes(keyFile), "application/octet-stream")
      .addField("password", password)
      .build();
    return client.putMultipart("/organizations/" + id + "/certificate", multipartBody, Organization.class);
  }

  /**
   * Deletes organization CSD certificate.
   */
  public Organization deleteCertificate(String id) {
    return delete("/organizations/" + id + "/certificate", null, Organization.class);
  }

  /**
   * Permanently removes an organization.
   */
  public Organization delete(String id) {
    return delete("/organizations/" + id, null, Organization.class);
  }

  /**
   * Gets test API key for an organization.
   */
  public String getTestApiKey(String id) {
    return get("/organizations/" + id + "/apikeys/test", null, String.class);
  }

  /**
   * Renews test API key for an organization.
   */
  public String renewTestApiKey(String id) {
    return put("/organizations/" + id + "/apikeys/test", null, null, String.class);
  }

  /**
   * Lists live API keys for an organization.
   */
  public List<ApiKey> listLiveApiKeys(String id) {
    return get("/organizations/" + id + "/apikeys/live", null, new TypeReference<List<ApiKey>>() {});
  }

  /**
   * Renews live API key for an organization.
   */
  public String renewLiveApiKey(String id) {
    return put("/organizations/" + id + "/apikeys/live", null, null, String.class);
  }

  /**
   * Deletes one live API key by id.
   */
  public List<ApiKey> deleteLiveApiKey(String organizationId, String apiKeyId) {
    return delete(
      "/organizations/" + organizationId + "/apikeys/live/" + apiKeyId,
      null,
      new TypeReference<List<ApiKey>>() {}
    );
  }

  /**
   * Lists invoice series configured in the organization.
   */
  public List<Series> listSeriesGroup(String organizationId) {
    return get("/organizations/" + organizationId + "/series-group", null, new TypeReference<List<Series>>() {});
  }

  /**
   * Creates a new invoice series in the organization.
   */
  public Series createSeriesGroup(String organizationId, Map<String, Object> seriesData) {
    return post("/organizations/" + organizationId + "/series-group", seriesData, null, Series.class);
  }

  /**
   * Updates an existing invoice series.
   */
  public Series updateSeriesGroup(String organizationId, String seriesName, Map<String, Object> data) {
    return put("/organizations/" + organizationId + "/series-group/" + seriesName, data, null, Series.class);
  }

  /**
   * Deletes an invoice series.
   */
  public Series deleteSeriesGroup(String organizationId, String seriesName) {
    return delete("/organizations/" + organizationId + "/series-group/" + seriesName, null, Series.class);
  }

  /**
   * Gets the organization associated with the current API key.
   */
  public Organization me() {
    return get("/organizations/me", null, Organization.class);
  }

  /**
   * Updates self-invoice settings.
   */
  public Organization updateSelfInvoiceSettings(String id, Map<String, Object> data) {
    return put("/organizations/" + id + "/self-invoice", data, null, Organization.class);
  }

  /**
   * Lists users with organization access.
   */
  public List<OrganizationUserAccess> listTeamAccess(String organizationId) {
    return get("/organizations/" + organizationId + "/team", null, new TypeReference<List<OrganizationUserAccess>>() {});
  }

  /**
   * Retrieves one organization access record.
   */
  public OrganizationUserAccess retrieveTeamAccess(String organizationId, String accessId) {
    return get("/organizations/" + organizationId + "/team/" + accessId, null, OrganizationUserAccess.class);
  }

  /**
   * Updates role assignment for a team access.
   */
  public OrganizationUserAccess updateTeamAccessRole(String organizationId, String accessId, String role) {
    return put(
      "/organizations/" + organizationId + "/team/" + accessId + "/role",
      Map.of("role", role),
      null,
      OrganizationUserAccess.class
    );
  }

  /**
   * Removes user access from the organization.
   */
  public GenericResponse removeTeamAccess(String organizationId, String accessId) {
    return delete("/organizations/" + organizationId + "/team/" + accessId, null, GenericResponse.class);
  }

  /**
   * Lists invites sent by an organization.
   */
  public List<OrganizationInvite> listSentTeamInvites(String organizationId) {
    return get("/organizations/" + organizationId + "/team/invites", null, new TypeReference<List<OrganizationInvite>>() {});
  }

  /**
   * Creates or updates a team invite.
   */
  public OrganizationInvite inviteUserToTeam(String organizationId, Map<String, Object> data) {
    return post("/organizations/" + organizationId + "/team/invites", data, null, OrganizationInvite.class);
  }

  /**
   * Cancels a sent team invite.
   */
  public GenericResponse cancelTeamInvite(String organizationId, String inviteKey) {
    return delete(
      "/organizations/" + organizationId + "/team/invites/" + inviteKey,
      null,
      GenericResponse.class
    );
  }

  /**
   * Lists invites pending response for current user.
   */
  public List<OrganizationInvite> listReceivedTeamInvites() {
    return get("/organizations/invites/pending", null, new TypeReference<List<OrganizationInvite>>() {});
  }

  /**
   * Accepts or rejects a pending invite.
   */
  public GenericResponse respondTeamInvite(String inviteKey, Map<String, Object> data) {
    return post("/organizations/invites/" + inviteKey + "/response", data, null, GenericResponse.class);
  }

  /**
   * Lists custom roles configured for an organization.
   */
  public List<OrganizationTeamRole> listTeamRoles(String organizationId) {
    return get("/organizations/" + organizationId + "/team/roles", null, new TypeReference<List<OrganizationTeamRole>>() {});
  }

  /**
   * Lists role templates available for an organization.
   */
  public List<OrganizationTeamRoleTemplate> listTeamRoleTemplates(String organizationId) {
    return get(
      "/organizations/" + organizationId + "/team/roles/templates",
      null,
      new TypeReference<List<OrganizationTeamRoleTemplate>>() {}
    );
  }

  /**
   * Lists operation codes available for role permissions.
   */
  public List<String> listTeamRoleOperations(String organizationId) {
    return get("/organizations/" + organizationId + "/team/roles/operations", null, new TypeReference<List<String>>() {});
  }

  /**
   * Retrieves a team role by id.
   */
  public OrganizationTeamRole retrieveTeamRole(String organizationId, String roleId) {
    return get("/organizations/" + organizationId + "/team/roles/" + roleId, null, OrganizationTeamRole.class);
  }

  /**
   * Creates a team role.
   */
  public OrganizationTeamRole createTeamRole(String organizationId, Map<String, Object> data) {
    return post("/organizations/" + organizationId + "/team/roles", data, null, OrganizationTeamRole.class);
  }

  /**
   * Updates a team role.
   */
  public OrganizationTeamRole updateTeamRole(String organizationId, String roleId, Map<String, Object> data) {
    return put("/organizations/" + organizationId + "/team/roles/" + roleId, data, null, OrganizationTeamRole.class);
  }

  /**
   * Deletes a team role.
   */
  public GenericResponse deleteTeamRole(String organizationId, String roleId) {
    return delete("/organizations/" + organizationId + "/team/roles/" + roleId, null, GenericResponse.class);
  }
}
