package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Details of capital repayment holiday if any
 */

@Schema(name = "OBReadProduct2_Data_Product_inner_OtherProductType_Repayment_RepaymentHoliday_inner", description = "Details of capital repayment holiday if any")
@JsonTypeName("OBReadProduct2_Data_Product_inner_OtherProductType_Repayment_RepaymentHoliday_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-20T22:20:45.412805+01:00[Africa/Lagos]")
public class OBReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner {

  @JsonProperty("MaxHolidayLength")
  private Integer maxHolidayLength;

  /**
   * The unit of period (days, weeks, months etc.) of the repayment holiday
   */
  public enum MaxHolidayPeriodEnum {
    PACT("PACT"),
    
    PDAY("PDAY"),
    
    PHYR("PHYR"),
    
    PMTH("PMTH"),
    
    PQTR("PQTR"),
    
    PWEK("PWEK"),
    
    PYER("PYER");

    private String value;

    MaxHolidayPeriodEnum(String value) {
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
    public static MaxHolidayPeriodEnum fromValue(String value) {
      for (MaxHolidayPeriodEnum b : MaxHolidayPeriodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("MaxHolidayPeriod")
  private MaxHolidayPeriodEnum maxHolidayPeriod;

  @JsonProperty("Notes")
  @Valid
  private List<String> notes = null;

  public OBReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner maxHolidayLength(Integer maxHolidayLength) {
    this.maxHolidayLength = maxHolidayLength;
    return this;
  }

  /**
   * The maximum length/duration of a Repayment Holiday
   * @return maxHolidayLength
  */
  
  @Schema(name = "MaxHolidayLength", description = "The maximum length/duration of a Repayment Holiday", required = false)
  public Integer getMaxHolidayLength() {
    return maxHolidayLength;
  }

  public void setMaxHolidayLength(Integer maxHolidayLength) {
    this.maxHolidayLength = maxHolidayLength;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner maxHolidayPeriod(MaxHolidayPeriodEnum maxHolidayPeriod) {
    this.maxHolidayPeriod = maxHolidayPeriod;
    return this;
  }

  /**
   * The unit of period (days, weeks, months etc.) of the repayment holiday
   * @return maxHolidayPeriod
  */
  
  @Schema(name = "MaxHolidayPeriod", description = "The unit of period (days, weeks, months etc.) of the repayment holiday", required = false)
  public MaxHolidayPeriodEnum getMaxHolidayPeriod() {
    return maxHolidayPeriod;
  }

  public void setMaxHolidayPeriod(MaxHolidayPeriodEnum maxHolidayPeriod) {
    this.maxHolidayPeriod = maxHolidayPeriod;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner notes(List<String> notes) {
    this.notes = notes;
    return this;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner addNotesItem(String notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * Get notes
   * @return notes
  */
  
  @Schema(name = "Notes", required = false)
  public List<String> getNotes() {
    return notes;
  }

  public void setNotes(List<String> notes) {
    this.notes = notes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner obReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner = (OBReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner) o;
    return Objects.equals(this.maxHolidayLength, obReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner.maxHolidayLength) &&
        Objects.equals(this.maxHolidayPeriod, obReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner.maxHolidayPeriod) &&
        Objects.equals(this.notes, obReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxHolidayLength, maxHolidayPeriod, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadProduct2DataProductInnerOtherProductTypeRepaymentRepaymentHolidayInner {\n");
    sb.append("    maxHolidayLength: ").append(toIndentedString(maxHolidayLength)).append("\n");
    sb.append("    maxHolidayPeriod: ").append(toIndentedString(maxHolidayPeriod)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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

