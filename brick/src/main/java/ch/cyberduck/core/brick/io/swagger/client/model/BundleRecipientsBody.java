/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * BundleRecipientsBody
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class BundleRecipientsBody {
  @JsonProperty("user_id")
  private Integer userId = null;

  @JsonProperty("bundle_id")
  private Integer bundleId = null;

  @JsonProperty("recipient")
  private String recipient = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("company")
  private String company = null;

  @JsonProperty("note")
  private String note = null;

  @JsonProperty("share_after_create")
  private Boolean shareAfterCreate = null;

  public BundleRecipientsBody userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * User ID.  Provide a value of &#x60;0&#x60; to operate the current session&#x27;s user.
   * @return userId
  **/
  @Schema(description = "User ID.  Provide a value of `0` to operate the current session's user.")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public BundleRecipientsBody bundleId(Integer bundleId) {
    this.bundleId = bundleId;
    return this;
  }

   /**
   * Bundle to share.
   * @return bundleId
  **/
  @Schema(required = true, description = "Bundle to share.")
  public Integer getBundleId() {
    return bundleId;
  }

  public void setBundleId(Integer bundleId) {
    this.bundleId = bundleId;
  }

  public BundleRecipientsBody recipient(String recipient) {
    this.recipient = recipient;
    return this;
  }

   /**
   * Email addresses to share this bundle with.
   * @return recipient
  **/
  @Schema(example = "johndoe@gmail.com", required = true, description = "Email addresses to share this bundle with.")
  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public BundleRecipientsBody name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of recipient.
   * @return name
  **/
  @Schema(example = "John Smith", description = "Name of recipient.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BundleRecipientsBody company(String company) {
    this.company = company;
    return this;
  }

   /**
   * Company of recipient.
   * @return company
  **/
  @Schema(example = "Acme Ltd", description = "Company of recipient.")
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public BundleRecipientsBody note(String note) {
    this.note = note;
    return this;
  }

   /**
   * Note to include in email.
   * @return note
  **/
  @Schema(example = "Just a note.", description = "Note to include in email.")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public BundleRecipientsBody shareAfterCreate(Boolean shareAfterCreate) {
    this.shareAfterCreate = shareAfterCreate;
    return this;
  }

   /**
   * Set to true to share the link with the recipient upon creation.
   * @return shareAfterCreate
  **/
  @Schema(description = "Set to true to share the link with the recipient upon creation.")
  public Boolean isShareAfterCreate() {
    return shareAfterCreate;
  }

  public void setShareAfterCreate(Boolean shareAfterCreate) {
    this.shareAfterCreate = shareAfterCreate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BundleRecipientsBody bundleRecipientsBody = (BundleRecipientsBody) o;
    return Objects.equals(this.userId, bundleRecipientsBody.userId) &&
        Objects.equals(this.bundleId, bundleRecipientsBody.bundleId) &&
        Objects.equals(this.recipient, bundleRecipientsBody.recipient) &&
        Objects.equals(this.name, bundleRecipientsBody.name) &&
        Objects.equals(this.company, bundleRecipientsBody.company) &&
        Objects.equals(this.note, bundleRecipientsBody.note) &&
        Objects.equals(this.shareAfterCreate, bundleRecipientsBody.shareAfterCreate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, bundleId, recipient, name, company, note, shareAfterCreate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BundleRecipientsBody {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    bundleId: ").append(toIndentedString(bundleId)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    shareAfterCreate: ").append(toIndentedString(shareAfterCreate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
