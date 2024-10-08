/*
 * DeepBox
 * DeepBox API Documentation
 *
 * OpenAPI spec version: 1.0
 * Contact: info@deepcloud.swiss
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.deepbox.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.deepbox.io.swagger.client.model.DetailNode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * Event
 */



public class Event {
  /**
   * Gets or Sets eventType
   */
  public enum EventTypeEnum {
    FILES_ADDED("files-added"),
    FILES_REMOVED("files-removed"),
    FOLDERS_ADDED("folders-added"),
    FOLDERS_REMOVED("folders-removed");

    private String value;

    EventTypeEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static EventTypeEnum fromValue(String input) {
      for (EventTypeEnum b : EventTypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("eventType")
  private EventTypeEnum eventType = null;

  @JsonProperty("parentNodeId")
  private String parentNodeId = null;

  @JsonProperty("details")
  private List<DetailNode> details = null;

  public Event eventType(EventTypeEnum eventType) {
    this.eventType = eventType;
    return this;
  }

   /**
   * Get eventType
   * @return eventType
  **/
  @Schema(description = "")
  public EventTypeEnum getEventType() {
    return eventType;
  }

  public void setEventType(EventTypeEnum eventType) {
    this.eventType = eventType;
  }

  public Event parentNodeId(String parentNodeId) {
    this.parentNodeId = parentNodeId;
    return this;
  }

   /**
   * Get parentNodeId
   * @return parentNodeId
  **/
  @Schema(description = "")
  public String getParentNodeId() {
    return parentNodeId;
  }

  public void setParentNodeId(String parentNodeId) {
    this.parentNodeId = parentNodeId;
  }

  public Event details(List<DetailNode> details) {
    this.details = details;
    return this;
  }

  public Event addDetailsItem(DetailNode detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<>();
    }
    this.details.add(detailsItem);
    return this;
  }

   /**
   * Get details
   * @return details
  **/
  @Schema(description = "")
  public List<DetailNode> getDetails() {
    return details;
  }

  public void setDetails(List<DetailNode> details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.eventType, event.eventType) &&
        Objects.equals(this.parentNodeId, event.parentNodeId) &&
        Objects.equals(this.details, event.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventType, parentNodeId, details);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    parentNodeId: ").append(toIndentedString(parentNodeId)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
