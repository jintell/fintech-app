package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.jade.fintech.model.OBActiveOrHistoricCurrencyAndAmount10;
import com.jade.fintech.model.OBActiveOrHistoricCurrencyAndAmount9;
import com.jade.fintech.model.OBBankTransactionCodeStructure1;
import com.jade.fintech.model.OBBranchAndFinancialInstitutionIdentification61;
import com.jade.fintech.model.OBBranchAndFinancialInstitutionIdentification62;
import com.jade.fintech.model.OBCashAccount60;
import com.jade.fintech.model.OBCashAccount61;
import com.jade.fintech.model.OBCreditDebitCode1;
import com.jade.fintech.model.OBCurrencyExchange5;
import com.jade.fintech.model.OBEntryStatus1Code;
import com.jade.fintech.model.OBMerchantDetails1;
import com.jade.fintech.model.OBTransactionCardInstrument1;
import com.jade.fintech.model.OBTransactionCashBalance;
import com.jade.fintech.model.OBTransactionMutability1Code;
import com.jade.fintech.model.ProprietaryBankTransactionCodeStructure1;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Provides further details on an entry in the report.
 */

@Schema(name = "OBTransaction6Detail", description = "Provides further details on an entry in the report.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T22:38:36.269814+01:00[Africa/Lagos]")
public class OBTransaction6Detail {

  @JsonProperty("AccountId")
  private String accountId;

  @JsonProperty("TransactionId")
  private String transactionId;

  @JsonProperty("TransactionReference")
  private String transactionReference;

  @JsonProperty("StatementReference")
  @Valid
  private List<String> statementReference = null;

  @JsonProperty("CreditDebitIndicator")
  private OBCreditDebitCode1 creditDebitIndicator;

  @JsonProperty("Status")
  private OBEntryStatus1Code status;

  @JsonProperty("TransactionMutability")
  private OBTransactionMutability1Code transactionMutability;

  @JsonProperty("BookingDateTime")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date bookingDateTime;

  @JsonProperty("ValueDateTime")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date valueDateTime;

  @JsonProperty("TransactionInformation")
  private String transactionInformation;

  @JsonProperty("AddressLine")
  private String addressLine;

  @JsonProperty("Amount")
  private OBActiveOrHistoricCurrencyAndAmount9 amount;

  @JsonProperty("ChargeAmount")
  private OBActiveOrHistoricCurrencyAndAmount10 chargeAmount;

  @JsonProperty("CurrencyExchange")
  private OBCurrencyExchange5 currencyExchange;

  @JsonProperty("BankTransactionCode")
  private OBBankTransactionCodeStructure1 bankTransactionCode;

  @JsonProperty("ProprietaryBankTransactionCode")
  private ProprietaryBankTransactionCodeStructure1 proprietaryBankTransactionCode;

  @JsonProperty("Balance")
  private OBTransactionCashBalance balance;

  @JsonProperty("MerchantDetails")
  private OBMerchantDetails1 merchantDetails;

  @JsonProperty("CreditorAgent")
  private OBBranchAndFinancialInstitutionIdentification61 creditorAgent;

  @JsonProperty("CreditorAccount")
  private OBCashAccount60 creditorAccount;

  @JsonProperty("DebtorAgent")
  private OBBranchAndFinancialInstitutionIdentification62 debtorAgent;

  @JsonProperty("DebtorAccount")
  private OBCashAccount61 debtorAccount;

  @JsonProperty("CardInstrument")
  private OBTransactionCardInstrument1 cardInstrument;

  @JsonProperty("SupplementaryData")
  @Valid
  private Map<String, Object> supplementaryData = null;

  public OBTransaction6Detail accountId(String accountId) {
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

  public OBTransaction6Detail transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * Unique identifier for the transaction within an servicing institution. This identifier is both unique and immutable.
   * @return transactionId
  */
  @Size(min = 1, max = 210) 
  @Schema(name = "TransactionId", description = "Unique identifier for the transaction within an servicing institution. This identifier is both unique and immutable.", required = false)
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public OBTransaction6Detail transactionReference(String transactionReference) {
    this.transactionReference = transactionReference;
    return this;
  }

  /**
   * Unique reference for the transaction. This reference is optionally populated, and may as an example be the FPID in the Faster Payments context.
   * @return transactionReference
  */
  @Size(min = 1, max = 210) 
  @Schema(name = "TransactionReference", description = "Unique reference for the transaction. This reference is optionally populated, and may as an example be the FPID in the Faster Payments context.", required = false)
  public String getTransactionReference() {
    return transactionReference;
  }

  public void setTransactionReference(String transactionReference) {
    this.transactionReference = transactionReference;
  }

  public OBTransaction6Detail statementReference(List<String> statementReference) {
    this.statementReference = statementReference;
    return this;
  }

  public OBTransaction6Detail addStatementReferenceItem(String statementReferenceItem) {
    if (this.statementReference == null) {
      this.statementReference = new ArrayList<>();
    }
    this.statementReference.add(statementReferenceItem);
    return this;
  }

  /**
   * Get statementReference
   * @return statementReference
  */
  
  @Schema(name = "StatementReference", required = false)
  public List<String> getStatementReference() {
    return statementReference;
  }

  public void setStatementReference(List<String> statementReference) {
    this.statementReference = statementReference;
  }

  public OBTransaction6Detail creditDebitIndicator(OBCreditDebitCode1 creditDebitIndicator) {
    this.creditDebitIndicator = creditDebitIndicator;
    return this;
  }

  /**
   * Get creditDebitIndicator
   * @return creditDebitIndicator
  */
  @NotNull @Valid 
  @Schema(name = "CreditDebitIndicator", required = true)
  public OBCreditDebitCode1 getCreditDebitIndicator() {
    return creditDebitIndicator;
  }

  public void setCreditDebitIndicator(OBCreditDebitCode1 creditDebitIndicator) {
    this.creditDebitIndicator = creditDebitIndicator;
  }

  public OBTransaction6Detail status(OBEntryStatus1Code status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull @Valid 
  @Schema(name = "Status", required = true)
  public OBEntryStatus1Code getStatus() {
    return status;
  }

  public void setStatus(OBEntryStatus1Code status) {
    this.status = status;
  }

  public OBTransaction6Detail transactionMutability(OBTransactionMutability1Code transactionMutability) {
    this.transactionMutability = transactionMutability;
    return this;
  }

  /**
   * Get transactionMutability
   * @return transactionMutability
  */
  @Valid 
  @Schema(name = "TransactionMutability", required = false)
  public OBTransactionMutability1Code getTransactionMutability() {
    return transactionMutability;
  }

  public void setTransactionMutability(OBTransactionMutability1Code transactionMutability) {
    this.transactionMutability = transactionMutability;
  }

  public OBTransaction6Detail bookingDateTime(Date bookingDateTime) {
    this.bookingDateTime = bookingDateTime;
    return this;
  }

  /**
   * Date and time when a transaction entry is posted to an account on the account servicer's books. Usage: Booking date is the expected booking date, unless the status is booked, in which case it is the actual booking date.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
   * @return bookingDateTime
  */
  @NotNull @Valid 
  @Schema(name = "BookingDateTime", description = "Date and time when a transaction entry is posted to an account on the account servicer's books. Usage: Booking date is the expected booking date, unless the status is booked, in which case it is the actual booking date.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00", required = true)
  public Date getBookingDateTime() {
    return bookingDateTime;
  }

  public void setBookingDateTime(Date bookingDateTime) {
    this.bookingDateTime = bookingDateTime;
  }

  public OBTransaction6Detail valueDateTime(Date valueDateTime) {
    this.valueDateTime = valueDateTime;
    return this;
  }

  /**
   * Date and time at which assets become available to the account owner in case of a credit entry, or cease to be available to the account owner in case of a debit transaction entry. Usage: If transaction entry status is pending and value date is present, then the value date refers to an expected/requested value date. For transaction entries subject to availability/float and for which availability information is provided, the value date must not be used. In this case the availability component identifies the number of availability days.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
   * @return valueDateTime
  */
  @Valid 
  @Schema(name = "ValueDateTime", description = "Date and time at which assets become available to the account owner in case of a credit entry, or cease to be available to the account owner in case of a debit transaction entry. Usage: If transaction entry status is pending and value date is present, then the value date refers to an expected/requested value date. For transaction entries subject to availability/float and for which availability information is provided, the value date must not be used. In this case the availability component identifies the number of availability days.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00", required = false)
  public Date getValueDateTime() {
    return valueDateTime;
  }

  public void setValueDateTime(Date valueDateTime) {
    this.valueDateTime = valueDateTime;
  }

  public OBTransaction6Detail transactionInformation(String transactionInformation) {
    this.transactionInformation = transactionInformation;
    return this;
  }

  /**
   * Further details of the transaction.  This is the transaction narrative, which is unstructured text.
   * @return transactionInformation
  */
  @Size(min = 1, max = 500) 
  @Schema(name = "TransactionInformation", description = "Further details of the transaction.  This is the transaction narrative, which is unstructured text.", required = false)
  public String getTransactionInformation() {
    return transactionInformation;
  }

  public void setTransactionInformation(String transactionInformation) {
    this.transactionInformation = transactionInformation;
  }

  public OBTransaction6Detail addressLine(String addressLine) {
    this.addressLine = addressLine;
    return this;
  }

  /**
   * Information that locates and identifies a specific address for a transaction entry, that is presented in free format text.
   * @return addressLine
  */
  @Size(min = 1, max = 70) 
  @Schema(name = "AddressLine", description = "Information that locates and identifies a specific address for a transaction entry, that is presented in free format text.", required = false)
  public String getAddressLine() {
    return addressLine;
  }

  public void setAddressLine(String addressLine) {
    this.addressLine = addressLine;
  }

  public OBTransaction6Detail amount(OBActiveOrHistoricCurrencyAndAmount9 amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @NotNull @Valid 
  @Schema(name = "Amount", required = true)
  public OBActiveOrHistoricCurrencyAndAmount9 getAmount() {
    return amount;
  }

  public void setAmount(OBActiveOrHistoricCurrencyAndAmount9 amount) {
    this.amount = amount;
  }

  public OBTransaction6Detail chargeAmount(OBActiveOrHistoricCurrencyAndAmount10 chargeAmount) {
    this.chargeAmount = chargeAmount;
    return this;
  }

  /**
   * Get chargeAmount
   * @return chargeAmount
  */
  @Valid 
  @Schema(name = "ChargeAmount", required = false)
  public OBActiveOrHistoricCurrencyAndAmount10 getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(OBActiveOrHistoricCurrencyAndAmount10 chargeAmount) {
    this.chargeAmount = chargeAmount;
  }

  public OBTransaction6Detail currencyExchange(OBCurrencyExchange5 currencyExchange) {
    this.currencyExchange = currencyExchange;
    return this;
  }

  /**
   * Get currencyExchange
   * @return currencyExchange
  */
  @Valid 
  @Schema(name = "CurrencyExchange", required = false)
  public OBCurrencyExchange5 getCurrencyExchange() {
    return currencyExchange;
  }

  public void setCurrencyExchange(OBCurrencyExchange5 currencyExchange) {
    this.currencyExchange = currencyExchange;
  }

  public OBTransaction6Detail bankTransactionCode(OBBankTransactionCodeStructure1 bankTransactionCode) {
    this.bankTransactionCode = bankTransactionCode;
    return this;
  }

  /**
   * Get bankTransactionCode
   * @return bankTransactionCode
  */
  @Valid 
  @Schema(name = "BankTransactionCode", required = false)
  public OBBankTransactionCodeStructure1 getBankTransactionCode() {
    return bankTransactionCode;
  }

  public void setBankTransactionCode(OBBankTransactionCodeStructure1 bankTransactionCode) {
    this.bankTransactionCode = bankTransactionCode;
  }

  public OBTransaction6Detail proprietaryBankTransactionCode(ProprietaryBankTransactionCodeStructure1 proprietaryBankTransactionCode) {
    this.proprietaryBankTransactionCode = proprietaryBankTransactionCode;
    return this;
  }

  /**
   * Get proprietaryBankTransactionCode
   * @return proprietaryBankTransactionCode
  */
  @Valid 
  @Schema(name = "ProprietaryBankTransactionCode", required = false)
  public ProprietaryBankTransactionCodeStructure1 getProprietaryBankTransactionCode() {
    return proprietaryBankTransactionCode;
  }

  public void setProprietaryBankTransactionCode(ProprietaryBankTransactionCodeStructure1 proprietaryBankTransactionCode) {
    this.proprietaryBankTransactionCode = proprietaryBankTransactionCode;
  }

  public OBTransaction6Detail balance(OBTransactionCashBalance balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Get balance
   * @return balance
  */
  @Valid 
  @Schema(name = "Balance", required = false)
  public OBTransactionCashBalance getBalance() {
    return balance;
  }

  public void setBalance(OBTransactionCashBalance balance) {
    this.balance = balance;
  }

  public OBTransaction6Detail merchantDetails(OBMerchantDetails1 merchantDetails) {
    this.merchantDetails = merchantDetails;
    return this;
  }

  /**
   * Get merchantDetails
   * @return merchantDetails
  */
  @Valid 
  @Schema(name = "MerchantDetails", required = false)
  public OBMerchantDetails1 getMerchantDetails() {
    return merchantDetails;
  }

  public void setMerchantDetails(OBMerchantDetails1 merchantDetails) {
    this.merchantDetails = merchantDetails;
  }

  public OBTransaction6Detail creditorAgent(OBBranchAndFinancialInstitutionIdentification61 creditorAgent) {
    this.creditorAgent = creditorAgent;
    return this;
  }

  /**
   * Get creditorAgent
   * @return creditorAgent
  */
  @Valid 
  @Schema(name = "CreditorAgent", required = false)
  public OBBranchAndFinancialInstitutionIdentification61 getCreditorAgent() {
    return creditorAgent;
  }

  public void setCreditorAgent(OBBranchAndFinancialInstitutionIdentification61 creditorAgent) {
    this.creditorAgent = creditorAgent;
  }

  public OBTransaction6Detail creditorAccount(OBCashAccount60 creditorAccount) {
    this.creditorAccount = creditorAccount;
    return this;
  }

  /**
   * Get creditorAccount
   * @return creditorAccount
  */
  @Valid 
  @Schema(name = "CreditorAccount", required = false)
  public OBCashAccount60 getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(OBCashAccount60 creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

  public OBTransaction6Detail debtorAgent(OBBranchAndFinancialInstitutionIdentification62 debtorAgent) {
    this.debtorAgent = debtorAgent;
    return this;
  }

  /**
   * Get debtorAgent
   * @return debtorAgent
  */
  @Valid 
  @Schema(name = "DebtorAgent", required = false)
  public OBBranchAndFinancialInstitutionIdentification62 getDebtorAgent() {
    return debtorAgent;
  }

  public void setDebtorAgent(OBBranchAndFinancialInstitutionIdentification62 debtorAgent) {
    this.debtorAgent = debtorAgent;
  }

  public OBTransaction6Detail debtorAccount(OBCashAccount61 debtorAccount) {
    this.debtorAccount = debtorAccount;
    return this;
  }

  /**
   * Get debtorAccount
   * @return debtorAccount
  */
  @Valid 
  @Schema(name = "DebtorAccount", required = false)
  public OBCashAccount61 getDebtorAccount() {
    return debtorAccount;
  }

  public void setDebtorAccount(OBCashAccount61 debtorAccount) {
    this.debtorAccount = debtorAccount;
  }

  public OBTransaction6Detail cardInstrument(OBTransactionCardInstrument1 cardInstrument) {
    this.cardInstrument = cardInstrument;
    return this;
  }

  /**
   * Get cardInstrument
   * @return cardInstrument
  */
  @Valid 
  @Schema(name = "CardInstrument", required = false)
  public OBTransactionCardInstrument1 getCardInstrument() {
    return cardInstrument;
  }

  public void setCardInstrument(OBTransactionCardInstrument1 cardInstrument) {
    this.cardInstrument = cardInstrument;
  }

  public OBTransaction6Detail supplementaryData(Map<String, Object> supplementaryData) {
    this.supplementaryData = supplementaryData;
    return this;
  }

  public OBTransaction6Detail putSupplementaryDataItem(String key, Object supplementaryDataItem) {
    if (this.supplementaryData == null) {
      this.supplementaryData = new HashMap<>();
    }
    this.supplementaryData.put(key, supplementaryDataItem);
    return this;
  }

  /**
   * Additional information that can not be captured in the structured fields and/or any other specific block.
   * @return supplementaryData
  */
  
  @Schema(name = "SupplementaryData", description = "Additional information that can not be captured in the structured fields and/or any other specific block.", required = false)
  public Map<String, Object> getSupplementaryData() {
    return supplementaryData;
  }

  public void setSupplementaryData(Map<String, Object> supplementaryData) {
    this.supplementaryData = supplementaryData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBTransaction6Detail obTransaction6Detail = (OBTransaction6Detail) o;
    return Objects.equals(this.accountId, obTransaction6Detail.accountId) &&
        Objects.equals(this.transactionId, obTransaction6Detail.transactionId) &&
        Objects.equals(this.transactionReference, obTransaction6Detail.transactionReference) &&
        Objects.equals(this.statementReference, obTransaction6Detail.statementReference) &&
        Objects.equals(this.creditDebitIndicator, obTransaction6Detail.creditDebitIndicator) &&
        Objects.equals(this.status, obTransaction6Detail.status) &&
        Objects.equals(this.transactionMutability, obTransaction6Detail.transactionMutability) &&
        Objects.equals(this.bookingDateTime, obTransaction6Detail.bookingDateTime) &&
        Objects.equals(this.valueDateTime, obTransaction6Detail.valueDateTime) &&
        Objects.equals(this.transactionInformation, obTransaction6Detail.transactionInformation) &&
        Objects.equals(this.addressLine, obTransaction6Detail.addressLine) &&
        Objects.equals(this.amount, obTransaction6Detail.amount) &&
        Objects.equals(this.chargeAmount, obTransaction6Detail.chargeAmount) &&
        Objects.equals(this.currencyExchange, obTransaction6Detail.currencyExchange) &&
        Objects.equals(this.bankTransactionCode, obTransaction6Detail.bankTransactionCode) &&
        Objects.equals(this.proprietaryBankTransactionCode, obTransaction6Detail.proprietaryBankTransactionCode) &&
        Objects.equals(this.balance, obTransaction6Detail.balance) &&
        Objects.equals(this.merchantDetails, obTransaction6Detail.merchantDetails) &&
        Objects.equals(this.creditorAgent, obTransaction6Detail.creditorAgent) &&
        Objects.equals(this.creditorAccount, obTransaction6Detail.creditorAccount) &&
        Objects.equals(this.debtorAgent, obTransaction6Detail.debtorAgent) &&
        Objects.equals(this.debtorAccount, obTransaction6Detail.debtorAccount) &&
        Objects.equals(this.cardInstrument, obTransaction6Detail.cardInstrument) &&
        Objects.equals(this.supplementaryData, obTransaction6Detail.supplementaryData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, transactionId, transactionReference, statementReference, creditDebitIndicator, status, transactionMutability, bookingDateTime, valueDateTime, transactionInformation, addressLine, amount, chargeAmount, currencyExchange, bankTransactionCode, proprietaryBankTransactionCode, balance, merchantDetails, creditorAgent, creditorAccount, debtorAgent, debtorAccount, cardInstrument, supplementaryData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBTransaction6Detail {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    transactionReference: ").append(toIndentedString(transactionReference)).append("\n");
    sb.append("    statementReference: ").append(toIndentedString(statementReference)).append("\n");
    sb.append("    creditDebitIndicator: ").append(toIndentedString(creditDebitIndicator)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    transactionMutability: ").append(toIndentedString(transactionMutability)).append("\n");
    sb.append("    bookingDateTime: ").append(toIndentedString(bookingDateTime)).append("\n");
    sb.append("    valueDateTime: ").append(toIndentedString(valueDateTime)).append("\n");
    sb.append("    transactionInformation: ").append(toIndentedString(transactionInformation)).append("\n");
    sb.append("    addressLine: ").append(toIndentedString(addressLine)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    chargeAmount: ").append(toIndentedString(chargeAmount)).append("\n");
    sb.append("    currencyExchange: ").append(toIndentedString(currencyExchange)).append("\n");
    sb.append("    bankTransactionCode: ").append(toIndentedString(bankTransactionCode)).append("\n");
    sb.append("    proprietaryBankTransactionCode: ").append(toIndentedString(proprietaryBankTransactionCode)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    merchantDetails: ").append(toIndentedString(merchantDetails)).append("\n");
    sb.append("    creditorAgent: ").append(toIndentedString(creditorAgent)).append("\n");
    sb.append("    creditorAccount: ").append(toIndentedString(creditorAccount)).append("\n");
    sb.append("    debtorAgent: ").append(toIndentedString(debtorAgent)).append("\n");
    sb.append("    debtorAccount: ").append(toIndentedString(debtorAccount)).append("\n");
    sb.append("    cardInstrument: ").append(toIndentedString(cardInstrument)).append("\n");
    sb.append("    supplementaryData: ").append(toIndentedString(supplementaryData)).append("\n");
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

