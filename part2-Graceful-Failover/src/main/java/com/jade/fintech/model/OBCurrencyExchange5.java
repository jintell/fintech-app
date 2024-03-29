package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.jade.fintech.model.OBCurrencyExchange5InstructedAmount;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Set of elements used to provide details on the currency exchange.
 */

@Schema(name = "OBCurrencyExchange5", description = "Set of elements used to provide details on the currency exchange.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T22:38:36.269814+01:00[Africa/Lagos]")
public class OBCurrencyExchange5 {

  @JsonProperty("SourceCurrency")
  private String sourceCurrency;

  @JsonProperty("TargetCurrency")
  private String targetCurrency;

  @JsonProperty("UnitCurrency")
  private String unitCurrency;

  @JsonProperty("ExchangeRate")
  private BigDecimal exchangeRate;

  @JsonProperty("ContractIdentification")
  private String contractIdentification;

  @JsonProperty("QuotationDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date quotationDate;

  @JsonProperty("InstructedAmount")
  private OBCurrencyExchange5InstructedAmount instructedAmount;

  public OBCurrencyExchange5 sourceCurrency(String sourceCurrency) {
    this.sourceCurrency = sourceCurrency;
    return this;
  }

  /**
   * Currency from which an amount is to be converted in a currency conversion.
   * @return sourceCurrency
  */
  @NotNull @Pattern(regexp = "^[A-Z]{3,3}$") 
  @Schema(name = "SourceCurrency", description = "Currency from which an amount is to be converted in a currency conversion.", required = true)
  public String getSourceCurrency() {
    return sourceCurrency;
  }

  public void setSourceCurrency(String sourceCurrency) {
    this.sourceCurrency = sourceCurrency;
  }

  public OBCurrencyExchange5 targetCurrency(String targetCurrency) {
    this.targetCurrency = targetCurrency;
    return this;
  }

  /**
   * Currency into which an amount is to be converted in a currency conversion.
   * @return targetCurrency
  */
  @Pattern(regexp = "^[A-Z]{3,3}$") 
  @Schema(name = "TargetCurrency", description = "Currency into which an amount is to be converted in a currency conversion.", required = false)
  public String getTargetCurrency() {
    return targetCurrency;
  }

  public void setTargetCurrency(String targetCurrency) {
    this.targetCurrency = targetCurrency;
  }

  public OBCurrencyExchange5 unitCurrency(String unitCurrency) {
    this.unitCurrency = unitCurrency;
    return this;
  }

  /**
   * Currency in which the rate of exchange is expressed in a currency exchange. In the example 1GBP = xxxCUR, the unit currency is GBP.
   * @return unitCurrency
  */
  @Pattern(regexp = "^[A-Z]{3,3}$") 
  @Schema(name = "UnitCurrency", description = "Currency in which the rate of exchange is expressed in a currency exchange. In the example 1GBP = xxxCUR, the unit currency is GBP.", required = false)
  public String getUnitCurrency() {
    return unitCurrency;
  }

  public void setUnitCurrency(String unitCurrency) {
    this.unitCurrency = unitCurrency;
  }

  public OBCurrencyExchange5 exchangeRate(BigDecimal exchangeRate) {
    this.exchangeRate = exchangeRate;
    return this;
  }

  /**
   * Factor used to convert an amount from one currency into another. This reflects the price at which one currency was bought with another currency. Usage: ExchangeRate expresses the ratio between UnitCurrency and QuotedCurrency (ExchangeRate = UnitCurrency/QuotedCurrency).
   * @return exchangeRate
  */
  @NotNull @Valid 
  @Schema(name = "ExchangeRate", description = "Factor used to convert an amount from one currency into another. This reflects the price at which one currency was bought with another currency. Usage: ExchangeRate expresses the ratio between UnitCurrency and QuotedCurrency (ExchangeRate = UnitCurrency/QuotedCurrency).", required = true)
  public BigDecimal getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(BigDecimal exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  public OBCurrencyExchange5 contractIdentification(String contractIdentification) {
    this.contractIdentification = contractIdentification;
    return this;
  }

  /**
   * Unique identification to unambiguously identify the foreign exchange contract.
   * @return contractIdentification
  */
  @Size(min = 1, max = 35) 
  @Schema(name = "ContractIdentification", description = "Unique identification to unambiguously identify the foreign exchange contract.", required = false)
  public String getContractIdentification() {
    return contractIdentification;
  }

  public void setContractIdentification(String contractIdentification) {
    this.contractIdentification = contractIdentification;
  }

  public OBCurrencyExchange5 quotationDate(Date quotationDate) {
    this.quotationDate = quotationDate;
    return this;
  }

  /**
   * Date and time at which an exchange rate is quoted.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
   * @return quotationDate
  */
  @Valid 
  @Schema(name = "QuotationDate", description = "Date and time at which an exchange rate is quoted.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00", required = false)
  public Date getQuotationDate() {
    return quotationDate;
  }

  public void setQuotationDate(Date quotationDate) {
    this.quotationDate = quotationDate;
  }

  public OBCurrencyExchange5 instructedAmount(OBCurrencyExchange5InstructedAmount instructedAmount) {
    this.instructedAmount = instructedAmount;
    return this;
  }

  /**
   * Get instructedAmount
   * @return instructedAmount
  */
  @Valid 
  @Schema(name = "InstructedAmount", required = false)
  public OBCurrencyExchange5InstructedAmount getInstructedAmount() {
    return instructedAmount;
  }

  public void setInstructedAmount(OBCurrencyExchange5InstructedAmount instructedAmount) {
    this.instructedAmount = instructedAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBCurrencyExchange5 obCurrencyExchange5 = (OBCurrencyExchange5) o;
    return Objects.equals(this.sourceCurrency, obCurrencyExchange5.sourceCurrency) &&
        Objects.equals(this.targetCurrency, obCurrencyExchange5.targetCurrency) &&
        Objects.equals(this.unitCurrency, obCurrencyExchange5.unitCurrency) &&
        Objects.equals(this.exchangeRate, obCurrencyExchange5.exchangeRate) &&
        Objects.equals(this.contractIdentification, obCurrencyExchange5.contractIdentification) &&
        Objects.equals(this.quotationDate, obCurrencyExchange5.quotationDate) &&
        Objects.equals(this.instructedAmount, obCurrencyExchange5.instructedAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceCurrency, targetCurrency, unitCurrency, exchangeRate, contractIdentification, quotationDate, instructedAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBCurrencyExchange5 {\n");
    sb.append("    sourceCurrency: ").append(toIndentedString(sourceCurrency)).append("\n");
    sb.append("    targetCurrency: ").append(toIndentedString(targetCurrency)).append("\n");
    sb.append("    unitCurrency: ").append(toIndentedString(unitCurrency)).append("\n");
    sb.append("    exchangeRate: ").append(toIndentedString(exchangeRate)).append("\n");
    sb.append("    contractIdentification: ").append(toIndentedString(contractIdentification)).append("\n");
    sb.append("    quotationDate: ").append(toIndentedString(quotationDate)).append("\n");
    sb.append("    instructedAmount: ").append(toIndentedString(instructedAmount)).append("\n");
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

