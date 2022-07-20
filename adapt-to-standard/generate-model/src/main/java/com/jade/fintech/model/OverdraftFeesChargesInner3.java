package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.jade.fintech.model.OverdraftFeeChargeCapInner1;
import com.jade.fintech.model.OverdraftFeeChargeDetailInner1;
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
 * Overdraft fees and charges details
 */

@Schema(name = "OverdraftFeesCharges_inner_3", description = "Overdraft fees and charges details")
@JsonTypeName("OverdraftFeesCharges_inner_3")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-20T22:20:45.412805+01:00[Africa/Lagos]")
public class OverdraftFeesChargesInner3 {

  @JsonProperty("OverdraftFeeChargeCap")
  @Valid
  private List<OverdraftFeeChargeCapInner1> overdraftFeeChargeCap = null;

  @JsonProperty("OverdraftFeeChargeDetail")
  @Valid
  private List<OverdraftFeeChargeDetailInner1> overdraftFeeChargeDetail = new ArrayList<>();

  public OverdraftFeesChargesInner3 overdraftFeeChargeCap(List<OverdraftFeeChargeCapInner1> overdraftFeeChargeCap) {
    this.overdraftFeeChargeCap = overdraftFeeChargeCap;
    return this;
  }

  public OverdraftFeesChargesInner3 addOverdraftFeeChargeCapItem(OverdraftFeeChargeCapInner1 overdraftFeeChargeCapItem) {
    if (this.overdraftFeeChargeCap == null) {
      this.overdraftFeeChargeCap = new ArrayList<>();
    }
    this.overdraftFeeChargeCap.add(overdraftFeeChargeCapItem);
    return this;
  }

  /**
   * Details about any caps (maximum charges) that apply to a particular fee/charge
   * @return overdraftFeeChargeCap
  */
  @Valid 
  @Schema(name = "OverdraftFeeChargeCap", description = "Details about any caps (maximum charges) that apply to a particular fee/charge", required = false)
  public List<OverdraftFeeChargeCapInner1> getOverdraftFeeChargeCap() {
    return overdraftFeeChargeCap;
  }

  public void setOverdraftFeeChargeCap(List<OverdraftFeeChargeCapInner1> overdraftFeeChargeCap) {
    this.overdraftFeeChargeCap = overdraftFeeChargeCap;
  }

  public OverdraftFeesChargesInner3 overdraftFeeChargeDetail(List<OverdraftFeeChargeDetailInner1> overdraftFeeChargeDetail) {
    this.overdraftFeeChargeDetail = overdraftFeeChargeDetail;
    return this;
  }

  public OverdraftFeesChargesInner3 addOverdraftFeeChargeDetailItem(OverdraftFeeChargeDetailInner1 overdraftFeeChargeDetailItem) {
    this.overdraftFeeChargeDetail.add(overdraftFeeChargeDetailItem);
    return this;
  }

  /**
   * Details about the fees/charges
   * @return overdraftFeeChargeDetail
  */
  @NotNull @Valid @Size(min = 1) 
  @Schema(name = "OverdraftFeeChargeDetail", description = "Details about the fees/charges", required = true)
  public List<OverdraftFeeChargeDetailInner1> getOverdraftFeeChargeDetail() {
    return overdraftFeeChargeDetail;
  }

  public void setOverdraftFeeChargeDetail(List<OverdraftFeeChargeDetailInner1> overdraftFeeChargeDetail) {
    this.overdraftFeeChargeDetail = overdraftFeeChargeDetail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OverdraftFeesChargesInner3 overdraftFeesChargesInner3 = (OverdraftFeesChargesInner3) o;
    return Objects.equals(this.overdraftFeeChargeCap, overdraftFeesChargesInner3.overdraftFeeChargeCap) &&
        Objects.equals(this.overdraftFeeChargeDetail, overdraftFeesChargesInner3.overdraftFeeChargeDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(overdraftFeeChargeCap, overdraftFeeChargeDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OverdraftFeesChargesInner3 {\n");
    sb.append("    overdraftFeeChargeCap: ").append(toIndentedString(overdraftFeeChargeCap)).append("\n");
    sb.append("    overdraftFeeChargeDetail: ").append(toIndentedString(overdraftFeeChargeDetail)).append("\n");
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

