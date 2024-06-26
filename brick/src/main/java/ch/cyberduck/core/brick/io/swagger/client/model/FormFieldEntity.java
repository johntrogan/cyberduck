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
 * FormFieldEntity
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class FormFieldEntity {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("label")
  private String label = null;

  @JsonProperty("required")
  private Boolean required = null;

  @JsonProperty("help_text")
  private String helpText = null;

  /**
   * Type of Field
   */
  public enum FieldTypeEnum {
    TEXT("text"),
    TEXT_AREA("text_area"),
    DROPDOWN("dropdown"),
    RADIO("radio");

    private String value;

    FieldTypeEnum(String value) {
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
    public static FieldTypeEnum fromValue(String text) {
      for (FieldTypeEnum b : FieldTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("field_type")
  private FieldTypeEnum fieldType = null;

  @JsonProperty("options_for_select")
  private String optionsForSelect = null;

  @JsonProperty("default_option")
  private String defaultOption = null;

  @JsonProperty("form_field_set_id")
  private Integer formFieldSetId = null;

  public FormFieldEntity id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Form field id
   * @return id
  **/
  @Schema(example = "1", description = "Form field id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public FormFieldEntity label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Label to be displayed
   * @return label
  **/
  @Schema(example = "Sample Label", description = "Label to be displayed")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public FormFieldEntity required(Boolean required) {
    this.required = required;
    return this;
  }

   /**
   * Is this a required field?
   * @return required
  **/
  @Schema(example = "true", description = "Is this a required field?")
  public Boolean isRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public FormFieldEntity helpText(String helpText) {
    this.helpText = helpText;
    return this;
  }

   /**
   * Help text to be displayed
   * @return helpText
  **/
  @Schema(example = "Help Text", description = "Help text to be displayed")
  public String getHelpText() {
    return helpText;
  }

  public void setHelpText(String helpText) {
    this.helpText = helpText;
  }

  public FormFieldEntity fieldType(FieldTypeEnum fieldType) {
    this.fieldType = fieldType;
    return this;
  }

   /**
   * Type of Field
   * @return fieldType
  **/
  @Schema(example = "text", description = "Type of Field")
  public FieldTypeEnum getFieldType() {
    return fieldType;
  }

  public void setFieldType(FieldTypeEnum fieldType) {
    this.fieldType = fieldType;
  }

  public FormFieldEntity optionsForSelect(String optionsForSelect) {
    this.optionsForSelect = optionsForSelect;
    return this;
  }

   /**
   * Options to display for radio and dropdown
   * @return optionsForSelect
  **/
  @Schema(description = "Options to display for radio and dropdown")
  public String getOptionsForSelect() {
    return optionsForSelect;
  }

  public void setOptionsForSelect(String optionsForSelect) {
    this.optionsForSelect = optionsForSelect;
  }

  public FormFieldEntity defaultOption(String defaultOption) {
    this.defaultOption = defaultOption;
    return this;
  }

   /**
   * Default option for radio and dropdown
   * @return defaultOption
  **/
  @Schema(example = "red", description = "Default option for radio and dropdown")
  public String getDefaultOption() {
    return defaultOption;
  }

  public void setDefaultOption(String defaultOption) {
    this.defaultOption = defaultOption;
  }

  public FormFieldEntity formFieldSetId(Integer formFieldSetId) {
    this.formFieldSetId = formFieldSetId;
    return this;
  }

   /**
   * Form field set id
   * @return formFieldSetId
  **/
  @Schema(example = "1", description = "Form field set id")
  public Integer getFormFieldSetId() {
    return formFieldSetId;
  }

  public void setFormFieldSetId(Integer formFieldSetId) {
    this.formFieldSetId = formFieldSetId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormFieldEntity formFieldEntity = (FormFieldEntity) o;
    return Objects.equals(this.id, formFieldEntity.id) &&
        Objects.equals(this.label, formFieldEntity.label) &&
        Objects.equals(this.required, formFieldEntity.required) &&
        Objects.equals(this.helpText, formFieldEntity.helpText) &&
        Objects.equals(this.fieldType, formFieldEntity.fieldType) &&
        Objects.equals(this.optionsForSelect, formFieldEntity.optionsForSelect) &&
        Objects.equals(this.defaultOption, formFieldEntity.defaultOption) &&
        Objects.equals(this.formFieldSetId, formFieldEntity.formFieldSetId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, label, required, helpText, fieldType, optionsForSelect, defaultOption, formFieldSetId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormFieldEntity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    helpText: ").append(toIndentedString(helpText)).append("\n");
    sb.append("    fieldType: ").append(toIndentedString(fieldType)).append("\n");
    sb.append("    optionsForSelect: ").append(toIndentedString(optionsForSelect)).append("\n");
    sb.append("    defaultOption: ").append(toIndentedString(defaultOption)).append("\n");
    sb.append("    formFieldSetId: ").append(toIndentedString(formFieldSetId)).append("\n");
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
