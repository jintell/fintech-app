package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Date;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Set of elements used to provide details of a generic date time for the statement resource.
 */

@Schema(name = "OBStatement2_StatementDateTime_inner", description = "Set of elements used to provide details of a generic date time for the statement resource.")
@JsonTypeName("OBStatement2_StatementDateTime_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T22:38:36.269814+01:00[Africa/Lagos]")
public class OBStatement2StatementDateTimeInner {

  @JsonProperty("DateTime")
  private Date dateTime;

  @JsonProperty("Type")
  private String type;

  public OBStatement2StatementDateTimeInner dateTime(Date dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * Get dateTime
   * @return dateTime
  */
  @NotNull @Valid 
  @Schema(name = "DateTime", required = true)
  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public OBStatement2StatementDateTimeInner type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Date time type, in a coded form.
   * @return type
  */
  @NotNull 
  @Schema(name = "Type", description = "Date time type, in a coded form.", required = true)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBStatement2StatementDateTimeInner obStatement2StatementDateTimeInner = (OBStatement2StatementDateTimeInner) o;
    return Objects.equals(this.dateTime, obStatement2StatementDateTimeInner.dateTime) &&
        Objects.equals(this.type, obStatement2StatementDateTimeInner.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateTime, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBStatement2StatementDateTimeInner {\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

