package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Transaction charges to be paid by the charge bearer.
 */

@Schema(name = "OBActiveOrHistoricCurrencyAndAmount_10", description = "Transaction charges to be paid by the charge bearer.")
@JsonTypeName("OBActiveOrHistoricCurrencyAndAmount_10")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T22:38:36.269814+01:00[Africa/Lagos]")
public class OBActiveOrHistoricCurrencyAndAmount10 {

  @JsonProperty("Amount")
  private String amount;

  @JsonProperty("Currency")
  private String currency;

  public OBActiveOrHistoricCurrencyAndAmount10 amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * A number of monetary units specified in an active currency where the unit of currency is explicit and compliant with ISO 4217.
   * @return amount
  */
  @NotNull @Pattern(regexp = "^\\d{1,13}$|^\\d{1,13}\\.\\d{1,5}$") 
  @Schema(name = "Amount", description = "A number of monetary units specified in an active currency where the unit of currency is explicit and compliant with ISO 4217.", required = true)
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public OBActiveOrHistoricCurrencyAndAmount10 currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * A code allocated to a currency by a Maintenance Agency under an international identification scheme, as described in the latest edition of the international standard ISO 4217 \"Codes for the representation of currencies and funds\".
   * @return currency
  */
  @NotNull @Pattern(regexp = "^[A-Z]{3,3}$") 
  @Schema(name = "Currency", description = "A code allocated to a currency by a Maintenance Agency under an international identification scheme, as described in the latest edition of the international standard ISO 4217 \"Codes for the representation of currencies and funds\".", required = true)
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBActiveOrHistoricCurrencyAndAmount10 obActiveOrHistoricCurrencyAndAmount10 = (OBActiveOrHistoricCurrencyAndAmount10) o;
    return Objects.equals(this.amount, obActiveOrHistoricCurrencyAndAmount10.amount) &&
        Objects.equals(this.currency, obActiveOrHistoricCurrencyAndAmount10.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBActiveOrHistoricCurrencyAndAmount10 {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

