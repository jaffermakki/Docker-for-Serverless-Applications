/*
 * OpenWhisk REST API
 * API for OpenWhisk
 *
 * OpenAPI spec version: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.KeyValue;
import io.swagger.client.model.TriggerLimits;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Trigger
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-24T21:18:05.110+07:00")
public class Trigger {
  @SerializedName("namespace")
  private String namespace = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("version")
  private String version = null;

  @SerializedName("publish")
  private Boolean publish = null;

  @SerializedName("annotations")
  private List<KeyValue> annotations = null;

  @SerializedName("parameters")
  private List<KeyValue> parameters = new ArrayList<KeyValue>();

  @SerializedName("limits")
  private TriggerLimits limits = null;

  public Trigger namespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

   /**
   * Namespace of the item
   * @return namespace
  **/
  @ApiModelProperty(required = true, value = "Namespace of the item")
  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public Trigger name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the item
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the item")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Trigger version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Semantic version of the item
   * @return version
  **/
  @ApiModelProperty(required = true, value = "Semantic version of the item")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Trigger publish(Boolean publish) {
    this.publish = publish;
    return this;
  }

   /**
   * Whether to publish the item or not
   * @return publish
  **/
  @ApiModelProperty(required = true, value = "Whether to publish the item or not")
  public Boolean getPublish() {
    return publish;
  }

  public void setPublish(Boolean publish) {
    this.publish = publish;
  }

  public Trigger annotations(List<KeyValue> annotations) {
    this.annotations = annotations;
    return this;
  }

  public Trigger addAnnotationsItem(KeyValue annotationsItem) {
    if (this.annotations == null) {
      this.annotations = new ArrayList<KeyValue>();
    }
    this.annotations.add(annotationsItem);
    return this;
  }

   /**
   * annotations on the item
   * @return annotations
  **/
  @ApiModelProperty(value = "annotations on the item")
  public List<KeyValue> getAnnotations() {
    return annotations;
  }

  public void setAnnotations(List<KeyValue> annotations) {
    this.annotations = annotations;
  }

  public Trigger parameters(List<KeyValue> parameters) {
    this.parameters = parameters;
    return this;
  }

  public Trigger addParametersItem(KeyValue parametersItem) {
    this.parameters.add(parametersItem);
    return this;
  }

   /**
   * parameter bindings for the trigger
   * @return parameters
  **/
  @ApiModelProperty(required = true, value = "parameter bindings for the trigger")
  public List<KeyValue> getParameters() {
    return parameters;
  }

  public void setParameters(List<KeyValue> parameters) {
    this.parameters = parameters;
  }

  public Trigger limits(TriggerLimits limits) {
    this.limits = limits;
    return this;
  }

   /**
   * Get limits
   * @return limits
  **/
  @ApiModelProperty(required = true, value = "")
  public TriggerLimits getLimits() {
    return limits;
  }

  public void setLimits(TriggerLimits limits) {
    this.limits = limits;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trigger trigger = (Trigger) o;
    return Objects.equals(this.namespace, trigger.namespace) &&
        Objects.equals(this.name, trigger.name) &&
        Objects.equals(this.version, trigger.version) &&
        Objects.equals(this.publish, trigger.publish) &&
        Objects.equals(this.annotations, trigger.annotations) &&
        Objects.equals(this.parameters, trigger.parameters) &&
        Objects.equals(this.limits, trigger.limits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace, name, version, publish, annotations, parameters, limits);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Trigger {\n");
    
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    publish: ").append(toIndentedString(publish)).append("\n");
    sb.append("    annotations: ").append(toIndentedString(annotations)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    limits: ").append(toIndentedString(limits)).append("\n");
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

