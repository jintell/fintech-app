package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.jade.fintech.model.OBActiveOrHistoricCurrencyAndAmount1;
import com.jade.fintech.model.OBBranchAndFinancialInstitutionIdentification51;
import com.jade.fintech.model.OBCashAccount51;
import com.jade.fintech.model.OBExternalScheduleType1Code;
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
 * OBScheduledPayment3Detail
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T22:38:36.269814+01:00[Africa/Lagos]")
public class OBScheduledPayment3Detail {

  @JsonProperty("AccountId")
  private String accountId;

  @JsonProperty("ScheduledPaymentId")
  private String scheduledPaymentId;

  @JsonProperty("ScheduledPaymentDateTime")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date scheduledPaymentDateTime;

  @JsonProperty("ScheduledType")
  private OBExternalScheduleType1Code scheduledType;

  @JsonProperty("Reference")
  private String reference;

  @JsonProperty("DebtorReference")
  private String debtorReference;

  @JsonProperty("InstructedAmount")
  private OBActiveOrHistoricCurrencyAndAmount1 instructedAmount;

  @JsonProperty("CreditorAgent")
  private OBBranchAndFinancialInstitutionIdentification51 creditorAgent;

  @JsonProperty("CreditorAccount")
  private OBCashAccount51 creditorAccount;

  public OBScheduledPayment3Detail accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * A unique and immutable identifier used to identify the account resource. This identifier has no meaning to the account owner.
   * @return accountId
  */
  @NotNull @Size(min = 1, max = 40) 
  @Schema(name = "AccountId", description = "A unique and immutable identifier used to identify the account resource. This identifier has no meaning to the account owner.", required = true)
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public OBScheduledPayment3Detail scheduledPaymentId(String scheduledPaymentId) {
    this.scheduledPaymentId = scheduledPaymentId;
    return this;
  }

  /**
   * A unique and immutable identifier used to identify the scheduled payment resource. This identifier has no meaning to the account owner.
   * @return scheduledPaymentId
  */
  @Size(min = 1, max = 40) 
  @Schema(name = "ScheduledPaymentId", description = "A unique and immutable identifier used to identify the scheduled payment resource. This identifier has no meaning to the account owner.", required = false)
  public String getScheduledPaymentId() {
    return scheduledPaymentId;
  }

  public void setScheduledPaymentId(String scheduledPaymentId) {
    this.scheduledPaymentId = scheduledPaymentId;
  }

  public OBScheduledPayment3Detail scheduledPaymentDateTime(Date scheduledPaymentDateTime) {
    this.scheduledPaymentDateTime = scheduledPaymentDateTime;
    return this;
  }

  /**
   * The date on which the scheduled payment will be made.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
   * @return scheduledPaymentDateTime
  */
  @NotNull @Valid 
  @Schema(name = "ScheduledPaymentDateTime", description = "The date on which the scheduled payment will be made.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00", required = true)
  public Date getScheduledPaymentDateTime() {
    return scheduledPaymentDateTime;
  }

  public void setScheduledPaymentDateTime(Date scheduledPaymentDateTime) {
    this.scheduledPaymentDateTime = scheduledPaymentDateTime;
  }

  public OBScheduledPayment3Detail scheduledType(OBExternalScheduleType1Code scheduledType) {
    this.scheduledType = scheduledType;
    return this;
  }

  /**
   * Get scheduledType
   * @return scheduledType
  */
  @NotNull @Valid 
  @Schema(name = "ScheduledType", required = true)
  public OBExternalScheduleType1Code getScheduledType() {
    return scheduledType;
  }

  public void setScheduledType(OBExternalScheduleType1Code scheduledType) {
    this.scheduledType = scheduledType;
  }

  public OBScheduledPayment3Detail reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Unique reference, as assigned by the creditor, to unambiguously refer to the payment transaction. Usage: If available, the initiating party should provide this reference in the structured remittance information, to enable reconciliation by the creditor upon receipt of the amount of money. If the business context requires the use of a creditor reference or a payment remit identification, and only one identifier can be passed through the end-to-end chain, the creditor's reference or payment remittance identification should be quoted in the end-to-end transaction identification.
   * @return reference
  */
  @Size(min = 1, max = 35) 
  @Schema(name = "Reference", description = "Unique reference, as assigned by the creditor, to unambiguously refer to the payment transaction. Usage: If available, the initiating party should provide this reference in the structured remittance information, to enable reconciliation by the creditor upon receipt of the amount of money. If the business context requires the use of a creditor reference or a payment remit identification, and only one identifier can be passed through the end-to-end chain, the creditor's reference or payment remittance identification should be quoted in the end-to-end transaction identification.", required = false)
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public OBScheduledPayment3Detail debtorReference(String debtorReference) {
    this.debtorReference = debtorReference;
    return this;
  }

  /**
   * A reference value provided by the PSU to the PISP while setting up the scheduled payment.
   * @return debtorReference
  */
  @Size(min = 1, max = 35) 
  @Schema(name = "DebtorReference", description = "A reference value provided by the PSU to the PISP while setting up the scheduled payment.", required = false)
  public String getDebtorReference() {
    return debtorReference;
  }

  public void setDebtorReference(String debtorReference) {
    this.debtorReference = debtorReference;
  }

  public OBScheduledPayment3Detail instructedAmount(OBActiveOrHistoricCurrencyAndAmount1 instructedAmount) {
    this.instructedAmount = instructedAmount;
    return this;
  }

  /**
   * Get instructedAmount
   * @return instructedAmount
  */
  @NotNull @Valid 
  @Schema(name = "InstructedAmount", required = true)
  public OBActiveOrHistoricCurrencyAndAmount1 getInstructedAmount() {
    return instructedAmount;
  }

  public void setInstructedAmount(OBActiveOrHistoricCurrencyAndAmount1 instructedAmount) {
    this.instructedAmount = instructedAmount;
  }

  public OBScheduledPayment3Detail creditorAgent(OBBranchAndFinancialInstitutionIdentification51 creditorAgent) {
    this.creditorAgent = creditorAgent;
    return this;
  }

  /**
   * Get creditorAgent
   * @return creditorAgent
  */
  @Valid 
  @Schema(name = "CreditorAgent", required = false)
  public OBBranchAndFinancialInstitutionIdentification51 getCreditorAgent() {
    return creditorAgent;
  }

  public void setCreditorAgent(OBBranchAndFinancialInstitutionIdentification51 creditorAgent) {
    this.creditorAgent = creditorAgent;
  }

  public OBScheduledPayment3Detail creditorAccount(OBCashAccount51 creditorAccount) {
    this.creditorAccount = creditorAccount;
    return this;
  }

  /**
   * Get creditorAccount
   * @return creditorAccount
  */
  @NotNull @Valid 
  @Schema(name = "CreditorAccount", required = true)
  public OBCashAccount51 getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(OBCashAccount51 creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBScheduledPayment3Detail obScheduledPayment3Detail = (OBScheduledPayment3Detail) o;
    return Objects.equals(this.accountId, obScheduledPayment3Detail.accountId) &&
        Objects.equals(this.scheduledPaymentId, obScheduledPayment3Detail.scheduledPaymentId) &&
        Objects.equals(this.scheduledPaymentDateTime, obScheduledPayment3Detail.scheduledPaymentDateTime) &&
        Objects.equals(this.scheduledType, obScheduledPayment3Detail.scheduledType) &&
        Objects.equals(this.reference, obScheduledPayment3Detail.reference) &&
        Objects.equals(this.debtorReference, obScheduledPayment3Detail.debtorReference) &&
        Objects.equals(this.instructedAmount, obScheduledPayment3Detail.instructedAmount) &&
        Objects.equals(this.creditorAgent, obScheduledPayment3Detail.creditorAgent) &&
        Objects.equals(this.creditorAccount, obScheduledPayment3Detail.creditorAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, scheduledPaymentId, scheduledPaymentDateTime, scheduledType, reference, debtorReference, instructedAmount, creditorAgent, creditorAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBScheduledPayment3Detail {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    scheduledPaymentId: ").append(toIndentedString(scheduledPaymentId)).append("\n");
    sb.append("    scheduledPaymentDateTime: ").append(toIndentedString(scheduledPaymentDateTime)).append("\n");
    sb.append("    scheduledType: ").append(toIndentedString(scheduledType)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    debtorReference: ").append(toIndentedString(debtorReference)).append("\n");
    sb.append("    instructedAmount: ").append(toIndentedString(instructedAmount)).append("\n");
    sb.append("    creditorAgent: ").append(toIndentedString(creditorAgent)).append("\n");
    sb.append("    creditorAccount: ").append(toIndentedString(creditorAccount)).append("\n");
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

