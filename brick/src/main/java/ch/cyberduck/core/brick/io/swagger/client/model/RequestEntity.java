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
 * List Requests
 */
@Schema(description = "List Requests")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class RequestEntity {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("source")
  private String source = null;

  @JsonProperty("destination")
  private String destination = null;

  @JsonProperty("automation_id")
  private String automationId = null;

  @JsonProperty("user_display_name")
  private String userDisplayName = null;

  public RequestEntity id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Request ID
   * @return id
  **/
  @Schema(example = "1", description = "Request ID")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RequestEntity path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Folder path
   * @return path
  **/
  @Schema(description = "Folder path")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public RequestEntity source(String source) {
    this.source = source;
    return this;
  }

   /**
   * Source filename, if applicable
   * @return source
  **/
  @Schema(description = "Source filename, if applicable")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public RequestEntity destination(String destination) {
    this.destination = destination;
    return this;
  }

   /**
   * Destination filename
   * @return destination
  **/
  @Schema(description = "Destination filename")
  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public RequestEntity automationId(String automationId) {
    this.automationId = automationId;
    return this;
  }

   /**
   * ID of automation that created request
   * @return automationId
  **/
  @Schema(description = "ID of automation that created request")
  public String getAutomationId() {
    return automationId;
  }

  public void setAutomationId(String automationId) {
    this.automationId = automationId;
  }

  public RequestEntity userDisplayName(String userDisplayName) {
    this.userDisplayName = userDisplayName;
    return this;
  }

   /**
   * User making the request (if applicable)
   * @return userDisplayName
  **/
  @Schema(description = "User making the request (if applicable)")
  public String getUserDisplayName() {
    return userDisplayName;
  }

  public void setUserDisplayName(String userDisplayName) {
    this.userDisplayName = userDisplayName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestEntity requestEntity = (RequestEntity) o;
    return Objects.equals(this.id, requestEntity.id) &&
        Objects.equals(this.path, requestEntity.path) &&
        Objects.equals(this.source, requestEntity.source) &&
        Objects.equals(this.destination, requestEntity.destination) &&
        Objects.equals(this.automationId, requestEntity.automationId) &&
        Objects.equals(this.userDisplayName, requestEntity.userDisplayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, path, source, destination, automationId, userDisplayName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestEntity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    automationId: ").append(toIndentedString(automationId)).append("\n");
    sb.append("    userDisplayName: ").append(toIndentedString(userDisplayName)).append("\n");
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
