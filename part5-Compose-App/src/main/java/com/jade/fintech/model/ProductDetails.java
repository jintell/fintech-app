package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * ProductDetails
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T22:38:36.269814+01:00[Africa/Lagos]")
public class ProductDetails {

  /**
   * Market segmentation is a marketing term referring to the aggregating of prospective buyers into groups, or segments, that have common needs and respond similarly to a marketing action. Market segmentation enables companies to target different categories of consumers who perceive the full value of certain products and services differently from one another.  Read more: Market Segmentation http://www.investopedia.com/terms/m/marketsegmentation.asp#ixzz4gfEEalTd  With respect to BCA products, they are segmented in relation to different markets that they wish to focus on. 
   */
  public enum SegmentEnum {
    CLIENTACCOUNT("ClientAccount"),
    
    STANDARD("Standard"),
    
    NONCOMMERCIALCHAITIESCLBSOC("NonCommercialChaitiesClbSoc"),
    
    NONCOMMERCIALPUBLICAUTHGOVT("NonCommercialPublicAuthGovt"),
    
    RELIGIOUS("Religious"),
    
    SECTORSPECIFIC("SectorSpecific"),
    
    STARTUP("Startup"),
    
    SWITCHER("Switcher");

    private String value;

    SegmentEnum(String value) {
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
    public static SegmentEnum fromValue(String value) {
      for (SegmentEnum b : SegmentEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("Segment")
  @Valid
  private List<SegmentEnum> segment = null;

  @JsonProperty("FeeFreeLength")
  private Float feeFreeLength;

  /**
   * The unit of period (days, weeks, months etc.) of the promotional length
   */
  public enum FeeFreeLengthPeriodEnum {
    DAY("Day"),
    
    HALF_YEAR("Half Year"),
    
    MONTH("Month"),
    
    QUARTER("Quarter"),
    
    WEEK("Week"),
    
    YEAR("Year");

    private String value;

    FeeFreeLengthPeriodEnum(String value) {
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
    public static FeeFreeLengthPeriodEnum fromValue(String value) {
      for (FeeFreeLengthPeriodEnum b : FeeFreeLengthPeriodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("FeeFreeLengthPeriod")
  private FeeFreeLengthPeriodEnum feeFreeLengthPeriod;

  @JsonProperty("Notes")
  @Valid
  private List<String> notes = null;

  public ProductDetails segment(List<SegmentEnum> segment) {
    this.segment = segment;
    return this;
  }

  public ProductDetails addSegmentItem(SegmentEnum segmentItem) {
    if (this.segment == null) {
      this.segment = new ArrayList<>();
    }
    this.segment.add(segmentItem);
    return this;
  }

  /**
   * Market segmentation is a marketing term referring to the aggregating of prospective buyers into groups, or segments, that have common needs and respond similarly to a marketing action. Market segmentation enables companies to target different categories of consumers who perceive the full value of certain products and services differently from one another.  Read more: Market Segmentation http://www.investopedia.com/terms/m/marketsegmentation.asp#ixzz4gfEEalTd  With respect to BCA products, they are segmented in relation to different markets that they wish to focus on. 
   * @return segment
  */
  
  @Schema(name = "Segment", description = "Market segmentation is a marketing term referring to the aggregating of prospective buyers into groups, or segments, that have common needs and respond similarly to a marketing action. Market segmentation enables companies to target different categories of consumers who perceive the full value of certain products and services differently from one another.  Read more: Market Segmentation http://www.investopedia.com/terms/m/marketsegmentation.asp#ixzz4gfEEalTd  With respect to BCA products, they are segmented in relation to different markets that they wish to focus on. ", required = false)
  public List<SegmentEnum> getSegment() {
    return segment;
  }

  public void setSegment(List<SegmentEnum> segment) {
    this.segment = segment;
  }

  public ProductDetails feeFreeLength(Float feeFreeLength) {
    this.feeFreeLength = feeFreeLength;
    return this;
  }

  /**
   * The length/duration of the fee free period
   * @return feeFreeLength
  */
  
  @Schema(name = "FeeFreeLength", description = "The length/duration of the fee free period", required = false)
  public Float getFeeFreeLength() {
    return feeFreeLength;
  }

  public void setFeeFreeLength(Float feeFreeLength) {
    this.feeFreeLength = feeFreeLength;
  }

  public ProductDetails feeFreeLengthPeriod(FeeFreeLengthPeriodEnum feeFreeLengthPeriod) {
    this.feeFreeLengthPeriod = feeFreeLengthPeriod;
    return this;
  }

  /**
   * The unit of period (days, weeks, months etc.) of the promotional length
   * @return feeFreeLengthPeriod
  */
  
  @Schema(name = "FeeFreeLengthPeriod", description = "The unit of period (days, weeks, months etc.) of the promotional length", required = false)
  public FeeFreeLengthPeriodEnum getFeeFreeLengthPeriod() {
    return feeFreeLengthPeriod;
  }

  public void setFeeFreeLengthPeriod(FeeFreeLengthPeriodEnum feeFreeLengthPeriod) {
    this.feeFreeLengthPeriod = feeFreeLengthPeriod;
  }

  public ProductDetails notes(List<String> notes) {
    this.notes = notes;
    return this;
  }

  public ProductDetails addNotesItem(String notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * Optional additional notes to supplement the Core product details
   * @return notes
  */
  
  @Schema(name = "Notes", description = "Optional additional notes to supplement the Core product details", required = false)
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
    ProductDetails productDetails = (ProductDetails) o;
    return Objects.equals(this.segment, productDetails.segment) &&
        Objects.equals(this.feeFreeLength, productDetails.feeFreeLength) &&
        Objects.equals(this.feeFreeLengthPeriod, productDetails.feeFreeLengthPeriod) &&
        Objects.equals(this.notes, productDetails.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(segment, feeFreeLength, feeFreeLengthPeriod, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDetails {\n");
    sb.append("    segment: ").append(toIndentedString(segment)).append("\n");
    sb.append("    feeFreeLength: ").append(toIndentedString(feeFreeLength)).append("\n");
    sb.append("    feeFreeLengthPeriod: ").append(toIndentedString(feeFreeLengthPeriod)).append("\n");
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

