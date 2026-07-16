package io.facturapi.constants;

/**
 * Documented Facturapi API error codes.
 *
 * <p>External PAC and SAT codes are returned in an error's {@code errors} detail array and are
 * intentionally not included in this catalog.</p>
 */
public final class ApiErrorCodes {
  private ApiErrorCodes() {
  }

  public static final class CommonErrorCode {
    public static final String CONFLICT = "conflict";
    public static final String FORBIDDEN = "forbidden";
    public static final String INTERNAL_ERROR = "internal_error";
    public static final String NOT_FOUND = "not_found";
    public static final String UNAUTHORIZED = "unauthorized";
    private CommonErrorCode() { }
  }

  public static final class AuthErrorCode {
    public static final String API_KEY_INVALID = "api_key_invalid";
    public static final String API_KEY_NOT_ALLOWED = "api_key_not_allowed";
    public static final String FEATURE_NOT_AVAILABLE = "feature_not_available";
    public static final String LIVE_API_KEY_REQUIRED = "live_api_key_required";
    public static final String MCP_PERMISSION_DENIED = "mcp_permission_denied";
    public static final String MISSING_CREDENTIALS = "missing_credentials";
    public static final String ORGANIZATION_INCOMPLETE = "organization_incomplete";
    public static final String SUBSCRIPTION_REQUIRED = "subscription_required";
    public static final String SUBSCRIPTION_LIVE_ACCESS_REQUIRED = "subscription_live_access_required";
    public static final String USER_KEY_INVALID = "user_key_invalid";
    public static final String USER_SUSPENDED = "user_suspended";
    private AuthErrorCode() { }
  }

  public static final class RequestErrorCode {
    public static final String IDEMPOTENCY_KEY_IN_USE = "idempotency_key_in_use";
    public static final String RATE_LIMIT_EXCEEDED = "rate_limit_exceeded";
    public static final String DATE_RANGE_TOO_LARGE = "date_range_too_large";
    public static final String IMAGE_FILE_REQUIRED = "image_file_required";
    public static final String INVALID_COUNTRY_CODE = "invalid_country_code";
    public static final String INVALID_DATE = "invalid_date";
    public static final String INVALID_DATE_RANGE = "invalid_date_range";
    public static final String INVALID_IMAGE_FILE = "invalid_image_file";
    public static final String INVALID_JSON = "invalid_json";
    public static final String INVALID_REQUEST = "invalid_request";
    public static final String INVALID_MULTIPART_FORM_DATA = "invalid_multipart_form_data";
    public static final String INVALID_STATE_CODE = "invalid_state_code";
    public static final String INVALID_TIMEZONE = "invalid_timezone";
    public static final String MULTIPART_LIMIT_EXCEEDED = "multipart_limit_exceeded";
    public static final String PAGE_TOO_LARGE = "page_too_large";
    public static final String PAYLOAD_TOO_LARGE = "payload_too_large";
    private RequestErrorCode() { }
  }

  public static final class CustomerErrorCode {
    public static final String CUSTOMER_COULD_NOT_BE_RESOLVED = "customer_could_not_be_resolved";
    public static final String CUSTOMER_EDIT_LINK_NOT_FOUND = "customer_edit_link_not_found";
    public static final String CUSTOMER_EDIT_LINK_UNAVAILABLE = "customer_edit_link_unavailable";
    public static final String CUSTOMER_EMAIL_REQUIRED = "customer_email_required";
    public static final String CUSTOMER_HAS_INVOICES = "customer_has_invoices";
    public static final String CUSTOMER_NOT_FOUND = "customer_not_found";
    public static final String CUSTOMER_TAX_INFO_UNAVAILABLE = "customer_tax_info_unavailable";
    private CustomerErrorCode() { }
  }

  public static final class TaxInfoValidationCode {
    public static final String LEGAL_NAME_MISMATCH = "legal_name_mismatch";
    public static final String TAX_ADDRESS_ZIP_MISMATCH = "tax_address_zip_mismatch";
    public static final String TAX_ID_NOT_FOUND = "tax_id_not_found";
    public static final String TAX_SYSTEM_NOT_ALLOWED_FOR_TAX_ID = "tax_system_not_allowed_for_tax_id";
    public static final String TAX_SYSTEM_NOT_IN_CATALOG = "tax_system_not_in_catalog";
    private TaxInfoValidationCode() { }
  }

  public static final class ProductErrorCode {
    public static final String PRODUCT_NOT_FOUND = "product_not_found";
    private ProductErrorCode() { }
  }

  public static final class SupplierErrorCode {
    public static final String SUPPLIER_NOT_FOUND = "supplier_not_found";
    private SupplierErrorCode() { }
  }

  public static final class CatalogErrorCode {
    public static final String PRODUCT_KEY_NOT_FOUND = "product_key_not_found";
    public static final String TARIFF_CODE_NOT_FOUND = "tariff_code_not_found";
    public static final String UNIT_KEY_NOT_FOUND = "unit_key_not_found";
    private CatalogErrorCode() { }
  }

  public static final class InvoiceErrorCode {
    public static final String INVOICE_ALREADY_STAMPED = "invoice_already_stamped";
    public static final String INVOICE_NOT_DRAFT = "invoice_not_draft";
    public static final String INVOICE_NOT_FOUND = "invoice_not_found";
    public static final String INVOICE_NOT_STAMPED = "invoice_not_stamped";
    private InvoiceErrorCode() { }
  }

  public static final class InvoiceDraftErrorCode {
    public static final String DRAFT_NOT_READY_TO_STAMP = "draft_not_ready_to_stamp";
    public static final String DRAFT_UPDATE_IN_PROGRESS = "draft_update_in_progress";
    private InvoiceDraftErrorCode() { }
  }

  public static final class InvoiceStampingErrorCode {
    public static final String INVOICE_STAMPING_FAILED = "invoice_stamping_failed";
    public static final String INVOICE_STAMPING_SERVICE_UNAVAILABLE = "invoice_stamping_service_unavailable";
    public static final String INVOICE_STAMPING_VALIDATION_ERROR = "invoice_stamping_validation_error";
    public static final String MANIFESTO_SIGNATURE_FAILED = "manifesto_signature_failed";
    public static final String STAMPING_IN_PROGRESS = "stamping_in_progress";
    private InvoiceStampingErrorCode() { }
  }

  public static final class InvoiceDeliveryErrorCode {
    public static final String INVOICE_EMAIL_DELIVERY_FAILED = "invoice_email_delivery_failed";
    public static final String INVOICE_EMAIL_RECIPIENT_REQUIRED = "invoice_email_recipient_required";
    public static final String INVOICE_EMAIL_STATUS_NOT_ALLOWED = "invoice_email_status_not_allowed";
    private InvoiceDeliveryErrorCode() { }
  }

  public static final class InvoiceCancellationErrorCode {
    public static final String INVOICE_CANCELLATION_IN_PROGRESS = "invoice_cancellation_in_progress";
    public static final String INVOICE_CANCELLATION_RECEIPT_UNAVAILABLE = "invoice_cancellation_receipt_unavailable";
    public static final String INVOICE_CANCELLATION_FAILED = "invoice_cancellation_failed";
    public static final String INVOICE_CANCELLATION_NOT_ALLOWED = "invoice_cancellation_not_allowed";
    public static final String INVOICE_CANCELLATION_NOT_FOUND = "invoice_cancellation_not_found";
    public static final String INVOICE_CANCELLATION_RFC_MISMATCH = "invoice_cancellation_rfc_mismatch";
    public static final String INVOICE_CANCELLATION_SERVICE_UNAVAILABLE = "invoice_cancellation_service_unavailable";
    public static final String INVOICE_NOT_CANCELABLE = "invoice_not_cancelable";
    public static final String INVOICE_NOT_CANCELABLE_BY_SAT = "invoice_not_cancelable_by_sat";
    public static final String SUBSTITUTION_INVOICE_CANCELED = "substitution_invoice_canceled";
    public static final String SUBSTITUTION_INVOICE_NOT_FOUND = "substitution_invoice_not_found";
    public static final String SUBSTITUTION_INVOICE_REQUIRED = "substitution_invoice_required";
    public static final String SUBSTITUTION_INVOICE_STATUS_NOT_ALLOWED = "substitution_invoice_status_not_allowed";
    private InvoiceCancellationErrorCode() { }
  }

  public static final class ReceiptErrorCode {
    public static final String RECEIPT_EXPIRED = "receipt_expired";
    public static final String RECEIPT_NOT_FOUND = "receipt_not_found";
    public static final String RECEIPT_NOT_OPEN = "receipt_not_open";
    private ReceiptErrorCode() { }
  }

  public static final class ReceiptInvoicingErrorCode {
    public static final String RECEIPT_INVOICING_ADDRESS_MISMATCH = "receipt_invoicing_address_mismatch";
    public static final String RECEIPT_INVOICING_CUSTOMER_MISMATCH = "receipt_invoicing_customer_mismatch";
    public static final String RECEIPT_INVOICING_TOO_MANY_ITEMS = "receipt_invoicing_too_many_items";
    public static final String RECEIPT_KEYS_NOT_FOUND = "receipt_keys_not_found";
    private ReceiptInvoicingErrorCode() { }
  }

  public static final class ReceiptGlobalInvoiceErrorCode {
    public static final String GLOBAL_INVOICE_TOO_MANY_ITEMS = "global_invoice_too_many_items";
    public static final String INVALID_GLOBAL_INVOICE_PERIOD = "invalid_global_invoice_period";
    private ReceiptGlobalInvoiceErrorCode() { }
  }

  public static final class RetentionErrorCode {
    public static final String INVALID_RETENTION_COMPLEMENT = "invalid_retention_complement";
    public static final String RETENTION_NOT_FOUND = "retention_not_found";
    public static final String RETENTION_NOT_STAMPED = "retention_not_stamped";
    public static final String RETENTION_NOT_CANCELABLE = "retention_not_cancelable";
    private RetentionErrorCode() { }
  }

  public static final class RetentionDeliveryErrorCode {
    public static final String RETENTION_EMAIL_DELIVERY_FAILED = "retention_email_delivery_failed";
    public static final String RETENTION_EMAIL_RECIPIENT_REQUIRED = "retention_email_recipient_required";
    public static final String RETENTION_EMAIL_STATUS_NOT_ALLOWED = "retention_email_status_not_allowed";
    private RetentionDeliveryErrorCode() { }
  }

  public static final class RetentionCancellationErrorCode {
    public static final String RETENTION_CANCELLATION_FAILED = "retention_cancellation_failed";
    public static final String RETENTION_CANCELLATION_SERVICE_UNAVAILABLE = "retention_cancellation_service_unavailable";
    private RetentionCancellationErrorCode() { }
  }

  public static final class RetentionStampingErrorCode {
    public static final String RETENTION_STAMPING_FAILED = "retention_stamping_failed";
    public static final String RETENTION_STAMPING_SERVICE_UNAVAILABLE = "retention_stamping_service_unavailable";
    public static final String RETENTION_STAMPING_VALIDATION_ERROR = "retention_stamping_validation_error";
    private RetentionStampingErrorCode() { }
  }

  public static final class OrganizationErrorCode {
    public static final String INVALID_OPERATION = "invalid_operation";
    public static final String INVALID_USER_ID = "invalid_user_id";
    public static final String ORGANIZATION_NOT_FOUND = "organization_not_found";
    public static final String SUBSCRIPTION_ACTIVE_REQUIRED = "subscription_active_required";
    private OrganizationErrorCode() { }
  }

  public static final class OrganizationSettingsErrorCode {
    public static final String CERTIFICATE_EXPIRED = "certificate_expired";
    public static final String CERTIFICATE_FILE_REQUIRED = "certificate_file_required";
    public static final String CERTIFICATE_FILES_INVALID = "certificate_files_invalid";
    public static final String CERTIFICATE_FILES_REQUIRED = "certificate_files_required";
    public static final String CERTIFICATE_FIEL_RFC_MISMATCH = "certificate_fiel_rfc_mismatch";
    public static final String CERTIFICATE_INVALID = "certificate_invalid";
    public static final String CERTIFICATE_NOT_YET_VALID = "certificate_not_yet_valid";
    public static final String CERTIFICATE_PREVIOUS_RFC_MISMATCH = "certificate_previous_rfc_mismatch";
    public static final String CSD_REQUIRED = "csd_required";
    public static final String FIEL_INVALID = "fiel_invalid";
    public static final String FIEL_RFC_MISMATCH = "fiel_rfc_mismatch";
    public static final String FIEL_REQUIRED = "fiel_required";
    public static final String ORGANIZATION_DOMAIN_CHANGE_NOT_ALLOWED = "organization_domain_change_not_allowed";
    public static final String ORGANIZATION_DOMAIN_UNAVAILABLE = "organization_domain_unavailable";
    public static final String ORGANIZATION_SETTINGS_INVALID = "organization_settings_invalid";
    public static final String ORGANIZATION_SUPPORT_EMAIL_REQUIRED = "organization_support_email_required";
    public static final String ORGANIZATION_TAX_INFO_INVALID = "organization_tax_info_invalid";
    public static final String PRIVATE_KEY_CERTIFICATE_MISMATCH = "private_key_certificate_mismatch";
    public static final String PRIVATE_KEY_FILE_REQUIRED = "private_key_file_required";
    public static final String PRIVATE_KEY_PASSWORD_INCORRECT = "private_key_password_incorrect";
    private OrganizationSettingsErrorCode() { }
  }

  public static final class OrganizationInviteErrorCode {
    public static final String INVITE_EMAIL_DELIVERY_FAILED = "invite_email_delivery_failed";
    public static final String INVITE_EMAIL_MISMATCH = "invite_email_mismatch";
    public static final String INVITE_EXPIRED = "invite_expired";
    public static final String INVITE_NOT_FOUND = "invite_not_found";
    public static final String INVITE_ROLE_UNAVAILABLE = "invite_role_unavailable";
    public static final String USER_ALREADY_IN_ORGANIZATION = "user_already_in_organization";
    private OrganizationInviteErrorCode() { }
  }

  public static final class OrganizationAccessErrorCode {
    public static final String ORGANIZATION_ADMIN_ACCESS_CANNOT_BE_REMOVED = "organization_admin_access_cannot_be_removed";
    public static final String ORGANIZATION_ADMIN_ASSIGNMENT_CANNOT_BE_EDITED = "organization_admin_assignment_cannot_be_edited";
    public static final String ORGANIZATION_ADMIN_ROLE_CANNOT_BE_DELETED = "organization_admin_role_cannot_be_deleted";
    public static final String ORGANIZATION_ADMIN_ROLE_CANNOT_BE_EDITED = "organization_admin_role_cannot_be_edited";
    public static final String ORGANIZATION_ADMIN_ROLE_REQUIRED = "organization_admin_role_required";
    public static final String ORGANIZATION_ID_NOT_ALLOWED = "organization_id_not_allowed";
    public static final String ORGANIZATION_ID_REQUIRED = "organization_id_required";
    public static final String OWNER_ACCESS_CANNOT_BE_REASSIGNED = "owner_access_cannot_be_reassigned";
    public static final String OWNER_ACCESS_CANNOT_BE_REMOVED = "owner_access_cannot_be_removed";
    public static final String ROLE_HAS_ASSIGNED_USERS = "role_has_assigned_users";
    public static final String ROLE_TEMPLATE_NOT_FOUND = "role_template_not_found";
    public static final String ROLE_NOT_FOUND = "role_not_found";
    public static final String USER_ACCESS_NOT_FOUND = "user_access_not_found";
    private OrganizationAccessErrorCode() { }
  }

  public static final class OrganizationSeriesErrorCode {
    public static final String SERIES_ALREADY_EXISTS = "series_already_exists";
    public static final String SERIES_NOT_FOUND = "series_not_found";
    private OrganizationSeriesErrorCode() { }
  }

  public static final class WebhookErrorCode {
    public static final String WEBHOOK_DELIVERY_ATTEMPT_NOT_FOUND = "webhook_delivery_attempt_not_found";
    public static final String WEBHOOK_NOT_FOUND = "webhook_not_found";
    public static final String WEBHOOK_SIGNATURE_INVALID = "webhook_signature_invalid";
    private WebhookErrorCode() { }
  }

  public static final class ToolErrorCode {
    public static final String TAX_ID_VALIDATION_FAILED = "tax_id_validation_failed";
    public static final String TAX_ID_VALIDATION_SERVICE_UNAVAILABLE = "tax_id_validation_service_unavailable";
    private ToolErrorCode() { }
  }

  /** Facturapi-owned values for {@code errors[].code} validation details. */
  public static final class ValidationErrorCode {
    public static final String AMOUNT_EXCEEDS_RELATED_DOCUMENT_BALANCE = "amount_exceeds_related_document_balance";
    public static final String EXCHANGE_RATE_TOO_LARGE = "exchange_rate_too_large";
    public static final String EXCHANGE_RATE_TOO_SMALL = "exchange_rate_too_small";
    public static final String INVALID_FORMAT = "invalid_format";
    public static final String INVALID_LENGTH = "invalid_length";
    public static final String INVALID_TYPE = "invalid_type";
    public static final String NOT_FOUND = "not_found";
    public static final String NOT_ALLOWED = "not_allowed";
    public static final String REQUIRED = "required";
    public static final String TOO_LARGE = "too_large";
    public static final String TOO_SMALL = "too_small";
    public static final String UNKNOWN_FIELD = "unknown_field";
    public static final String INVALID_VALUE = "invalid_value";
    private ValidationErrorCode() { }
  }
}
