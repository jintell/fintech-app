package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.jade.fintech.model.OBActiveOrHistoricCurrencyAndAmount7;
import com.jade.fintech.model.OBCreditDebitCode0;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Set of elements used to provide details of a generic interest amount related to the statement resource.
 */

@Schema(name = "OBStatement2_StatementInterest_inner", description = "Set of elements used to provide details of a generic interest amount related to the statement resource.")
@JsonTypeName("OBStatement2_StatementInterest_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T22:38:36.269814+01:00[Africa/Lagos]")
public class OBStatement2StatementInterestInner {

  @JsonProperty("Description")
  private String description;

  @JsonProperty("CreditDebitIndicator")
  private OBCreditDebitCode0 creditDebitIndicator;

  @JsonProperty("Type")
  private String type;

  @JsonProperty("Rate")
  private BigDecimal rate;

  @JsonProperty("RateType")
  private String rateType;

  @JsonProperty("Frequency")
  private String frequency;

  @JsonProperty("Amount")
  private OBActiveOrHistoricCurrencyAndAmount7 amount;

  public OBStatement2StatementInterestInner description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description that may be available for the statement interest.
   * @return description
  */
  @Size(min = 1, max = 128) 
  @Schema(name = "Description", description = "Description that may be available for the statement interest.", required = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OBStatement2StatementInterestInner creditDebitIndicator(OBCreditDebitCode0 creditDebitIndicator) {
    this.creditDebitIndicator = creditDebitIndicator;
    return this;
  }

  /**
   * Get creditDebitIndicator
   * @return creditDebitIndicator
  */
  @NotNull @Valid 
  @Schema(name = "CreditDebitIndicator", required = true)
  public OBCreditDebitCode0 getCreditDebitIndicator() {
    return creditDebitIndicator;
  }

  public void setCreditDebitIndicator(OBCreditDebitCode0 creditDebitIndicator) {
    this.creditDebitIndicator = creditDebitIndicator;
  }

  public OBStatement2StatementInterestInner type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Interest amount type, in a coded form.
   * @return type
  */
  @NotNull 
  @Schema(name = "Type", description = "Interest amount type, in a coded form.", required = true)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public OBStatement2StatementInterestInner rate(BigDecimal rate) {
    this.rate = rate;
    return this;
  }

  /**
   * field representing a percentage (e.g. 0.05 represents 5% and 0.9525 represents 95.25%). Note the number of decimal places may vary.
   * @return rate
  */
  @Valid 
  @Schema(name = "Rate", description = "field representing a percentage (e.g. 0.05 represents 5% and 0.9525 represents 95.25%). Note the number of decimal places may vary.", required = false)
  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public OBStatement2StatementInterestInner rateType(String rateType) {
    this.rateType = rateType;
    return this;
  }

  /**
   * Description that may be available for the statement Interest rate type.
   * @return rateType
  */
  
  @Schema(name = "RateType", description = "Description that may be available for the statement Interest rate type.", required = false)
  public String getRateType() {
    return rateType;
  }

  public void setRateType(String rateType) {
    this.rateType = rateType;
  }

  public OBStatement2StatementInterestInner frequency(String frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * Specifies the statement fee type requested
   * @return frequency
  */
  
  @Schema(name = "Frequency", description = "Specifies the statement fee type requested", required = false)
  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public OBStatement2StatementInterestInner amount(OBActiveOrHistoricCurrencyAndAmount7 amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @NotNull @Valid 
  @Schema(name = "Amount", required = true)
  public OBActiveOrHistoricCurrencyAndAmount7 getAmount() {
    return amount;
  }

  public void setAmount(OBActiveOrHistoricCurrencyAndAmount7 amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBStatement2StatementInterestInner obStatement2StatementInterestInner = (OBStatement2StatementInterestInner) o;
    return Objects.equals(this.description, obStatement2StatementInterestInner.description) &&
        Objects.equals(this.creditDebitIndicator, obStatement2StatementInterestInner.creditDebitIndicator) &&
        Objects.equals(this.type, obStatement2StatementInterestInner.type) &&
        Objects.equals(this.rate, obStatement2StatementInterestInner.rate) &&
        Objects.equals(this.rateType, obStatement2StatementInterestInner.rateType) &&
        Objects.equals(this.frequency, obStatement2StatementInterestInner.frequency) &&
        Objects.equals(this.amount, obStatement2StatementInterestInner.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, creditDebitIndicator, type, rate, rateType, frequency, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBStatement2StatementInterestInner {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    creditDebitIndicator: ").append(toIndentedString(creditDebitIndicator)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    rateType: ").append(toIndentedString(rateType)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

