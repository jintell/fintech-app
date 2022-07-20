package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.jade.fintech.model.OBInterestFixedVariableType1Code;
import com.jade.fintech.model.OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerLoanInterestFeesChargesInner;
import com.jade.fintech.model.OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerOtherLoanProviderInterestRateType;
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
 * Tier Band Details
 */

@Schema(name = "OBReadProduct2_Data_Product_inner_OtherProductType_LoanInterest_LoanInterestTierBandSet_inner_LoanInterestTierBand_inner", description = "Tier Band Details")
@JsonTypeName("OBReadProduct2_Data_Product_inner_OtherProductType_LoanInterest_LoanInterestTierBandSet_inner_LoanInterestTierBand_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-20T22:20:45.412805+01:00[Africa/Lagos]")
public class OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner {

  @JsonProperty("Identification")
  private String identification;

  @JsonProperty("TierValueMinimum")
  private String tierValueMinimum;

  @JsonProperty("TierValueMaximum")
  private String tierValueMaximum;

  @JsonProperty("TierValueMinTerm")
  private Integer tierValueMinTerm;

  /**
   * The unit of period (days, weeks, months etc.) of the Minimum Term
   */
  public enum MinTermPeriodEnum {
    PACT("PACT"),
    
    PDAY("PDAY"),
    
    PHYR("PHYR"),
    
    PMTH("PMTH"),
    
    PQTR("PQTR"),
    
    PWEK("PWEK"),
    
    PYER("PYER");

    private String value;

    MinTermPeriodEnum(String value) {
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
    public static MinTermPeriodEnum fromValue(String value) {
      for (MinTermPeriodEnum b : MinTermPeriodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("MinTermPeriod")
  private MinTermPeriodEnum minTermPeriod;

  @JsonProperty("TierValueMaxTerm")
  private Integer tierValueMaxTerm;

  /**
   * The unit of period (days, weeks, months etc.) of the Maximum Term
   */
  public enum MaxTermPeriodEnum {
    PACT("PACT"),
    
    PDAY("PDAY"),
    
    PHYR("PHYR"),
    
    PMTH("PMTH"),
    
    PQTR("PQTR"),
    
    PWEK("PWEK"),
    
    PYER("PYER");

    private String value;

    MaxTermPeriodEnum(String value) {
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
    public static MaxTermPeriodEnum fromValue(String value) {
      for (MaxTermPeriodEnum b : MaxTermPeriodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("MaxTermPeriod")
  private MaxTermPeriodEnum maxTermPeriod;

  @JsonProperty("FixedVariableInterestRateType")
  private OBInterestFixedVariableType1Code fixedVariableInterestRateType;

  @JsonProperty("RepAPR")
  private String repAPR;

  /**
   * Interest rate types, other than APR, which financial institutions may use to describe the annual interest rate payable for the SME Loan.
   */
  public enum LoanProviderInterestRateTypeEnum {
    INBB("INBB"),
    
    INFR("INFR"),
    
    INGR("INGR"),
    
    INLR("INLR"),
    
    INNE("INNE"),
    
    INOT("INOT");

    private String value;

    LoanProviderInterestRateTypeEnum(String value) {
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
    public static LoanProviderInterestRateTypeEnum fromValue(String value) {
      for (LoanProviderInterestRateTypeEnum b : LoanProviderInterestRateTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("LoanProviderInterestRateType")
  private LoanProviderInterestRateTypeEnum loanProviderInterestRateType;

  @JsonProperty("LoanProviderInterestRate")
  private String loanProviderInterestRate;

  @JsonProperty("Notes")
  @Valid
  private List<String> notes = null;

  @JsonProperty("OtherLoanProviderInterestRateType")
  private OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerOtherLoanProviderInterestRateType otherLoanProviderInterestRateType;

  @JsonProperty("LoanInterestFeesCharges")
  @Valid
  private List<OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerLoanInterestFeesChargesInner> loanInterestFeesCharges = null;

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * Unique and unambiguous identification of a  Tier Band for a SME Loan.
   * @return identification
  */
  @Size(min = 1, max = 35) 
  @Schema(name = "Identification", description = "Unique and unambiguous identification of a  Tier Band for a SME Loan.", required = false)
  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner tierValueMinimum(String tierValueMinimum) {
    this.tierValueMinimum = tierValueMinimum;
    return this;
  }

  /**
   * Minimum loan value for which the loan interest tier applies.
   * @return tierValueMinimum
  */
  @NotNull @Pattern(regexp = "^(-?\\d{1,14}){1}(\\.\\d{1,4}){0,1}$") 
  @Schema(name = "TierValueMinimum", description = "Minimum loan value for which the loan interest tier applies.", required = true)
  public String getTierValueMinimum() {
    return tierValueMinimum;
  }

  public void setTierValueMinimum(String tierValueMinimum) {
    this.tierValueMinimum = tierValueMinimum;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner tierValueMaximum(String tierValueMaximum) {
    this.tierValueMaximum = tierValueMaximum;
    return this;
  }

  /**
   * Maximum loan value for which the loan interest tier applies.
   * @return tierValueMaximum
  */
  @Pattern(regexp = "^(-?\\d{1,14}){1}(\\.\\d{1,4}){0,1}$") 
  @Schema(name = "TierValueMaximum", description = "Maximum loan value for which the loan interest tier applies.", required = false)
  public String getTierValueMaximum() {
    return tierValueMaximum;
  }

  public void setTierValueMaximum(String tierValueMaximum) {
    this.tierValueMaximum = tierValueMaximum;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner tierValueMinTerm(Integer tierValueMinTerm) {
    this.tierValueMinTerm = tierValueMinTerm;
    return this;
  }

  /**
   * Minimum loan term for which the loan interest tier applies.
   * @return tierValueMinTerm
  */
  @NotNull 
  @Schema(name = "TierValueMinTerm", description = "Minimum loan term for which the loan interest tier applies.", required = true)
  public Integer getTierValueMinTerm() {
    return tierValueMinTerm;
  }

  public void setTierValueMinTerm(Integer tierValueMinTerm) {
    this.tierValueMinTerm = tierValueMinTerm;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner minTermPeriod(MinTermPeriodEnum minTermPeriod) {
    this.minTermPeriod = minTermPeriod;
    return this;
  }

  /**
   * The unit of period (days, weeks, months etc.) of the Minimum Term
   * @return minTermPeriod
  */
  @NotNull 
  @Schema(name = "MinTermPeriod", description = "The unit of period (days, weeks, months etc.) of the Minimum Term", required = true)
  public MinTermPeriodEnum getMinTermPeriod() {
    return minTermPeriod;
  }

  public void setMinTermPeriod(MinTermPeriodEnum minTermPeriod) {
    this.minTermPeriod = minTermPeriod;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner tierValueMaxTerm(Integer tierValueMaxTerm) {
    this.tierValueMaxTerm = tierValueMaxTerm;
    return this;
  }

  /**
   * Maximum loan term for which the loan interest tier applies.
   * @return tierValueMaxTerm
  */
  
  @Schema(name = "TierValueMaxTerm", description = "Maximum loan term for which the loan interest tier applies.", required = false)
  public Integer getTierValueMaxTerm() {
    return tierValueMaxTerm;
  }

  public void setTierValueMaxTerm(Integer tierValueMaxTerm) {
    this.tierValueMaxTerm = tierValueMaxTerm;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner maxTermPeriod(MaxTermPeriodEnum maxTermPeriod) {
    this.maxTermPeriod = maxTermPeriod;
    return this;
  }

  /**
   * The unit of period (days, weeks, months etc.) of the Maximum Term
   * @return maxTermPeriod
  */
  
  @Schema(name = "MaxTermPeriod", description = "The unit of period (days, weeks, months etc.) of the Maximum Term", required = false)
  public MaxTermPeriodEnum getMaxTermPeriod() {
    return maxTermPeriod;
  }

  public void setMaxTermPeriod(MaxTermPeriodEnum maxTermPeriod) {
    this.maxTermPeriod = maxTermPeriod;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner fixedVariableInterestRateType(OBInterestFixedVariableType1Code fixedVariableInterestRateType) {
    this.fixedVariableInterestRateType = fixedVariableInterestRateType;
    return this;
  }

  /**
   * Get fixedVariableInterestRateType
   * @return fixedVariableInterestRateType
  */
  @NotNull @Valid 
  @Schema(name = "FixedVariableInterestRateType", required = true)
  public OBInterestFixedVariableType1Code getFixedVariableInterestRateType() {
    return fixedVariableInterestRateType;
  }

  public void setFixedVariableInterestRateType(OBInterestFixedVariableType1Code fixedVariableInterestRateType) {
    this.fixedVariableInterestRateType = fixedVariableInterestRateType;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner repAPR(String repAPR) {
    this.repAPR = repAPR;
    return this;
  }

  /**
   * The annual equivalent rate (AER) is interest that is calculated under the assumption that any interest paid is combined with the original balance and the next interest payment will be based on the slightly higher account balance. Overall, this means that interest can be compounded several times in a year depending on the number of times that interest payments are made.  For SME Loan, this APR is the representative APR which includes any account fees.
   * @return repAPR
  */
  @NotNull @Pattern(regexp = "^(-?\\d{1,3}){1}(\\.\\d{1,4}){0,1}$") 
  @Schema(name = "RepAPR", description = "The annual equivalent rate (AER) is interest that is calculated under the assumption that any interest paid is combined with the original balance and the next interest payment will be based on the slightly higher account balance. Overall, this means that interest can be compounded several times in a year depending on the number of times that interest payments are made.  For SME Loan, this APR is the representative APR which includes any account fees.", required = true)
  public String getRepAPR() {
    return repAPR;
  }

  public void setRepAPR(String repAPR) {
    this.repAPR = repAPR;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner loanProviderInterestRateType(LoanProviderInterestRateTypeEnum loanProviderInterestRateType) {
    this.loanProviderInterestRateType = loanProviderInterestRateType;
    return this;
  }

  /**
   * Interest rate types, other than APR, which financial institutions may use to describe the annual interest rate payable for the SME Loan.
   * @return loanProviderInterestRateType
  */
  
  @Schema(name = "LoanProviderInterestRateType", description = "Interest rate types, other than APR, which financial institutions may use to describe the annual interest rate payable for the SME Loan.", required = false)
  public LoanProviderInterestRateTypeEnum getLoanProviderInterestRateType() {
    return loanProviderInterestRateType;
  }

  public void setLoanProviderInterestRateType(LoanProviderInterestRateTypeEnum loanProviderInterestRateType) {
    this.loanProviderInterestRateType = loanProviderInterestRateType;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner loanProviderInterestRate(String loanProviderInterestRate) {
    this.loanProviderInterestRate = loanProviderInterestRate;
    return this;
  }

  /**
   * Loan provider Interest for the SME Loan product
   * @return loanProviderInterestRate
  */
  @Pattern(regexp = "^(-?\\d{1,3}){1}(\\.\\d{1,4}){0,1}$") 
  @Schema(name = "LoanProviderInterestRate", description = "Loan provider Interest for the SME Loan product", required = false)
  public String getLoanProviderInterestRate() {
    return loanProviderInterestRate;
  }

  public void setLoanProviderInterestRate(String loanProviderInterestRate) {
    this.loanProviderInterestRate = loanProviderInterestRate;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner notes(List<String> notes) {
    this.notes = notes;
    return this;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner addNotesItem(String notesItem) {
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

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner otherLoanProviderInterestRateType(OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerOtherLoanProviderInterestRateType otherLoanProviderInterestRateType) {
    this.otherLoanProviderInterestRateType = otherLoanProviderInterestRateType;
    return this;
  }

  /**
   * Get otherLoanProviderInterestRateType
   * @return otherLoanProviderInterestRateType
  */
  @Valid 
  @Schema(name = "OtherLoanProviderInterestRateType", required = false)
  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerOtherLoanProviderInterestRateType getOtherLoanProviderInterestRateType() {
    return otherLoanProviderInterestRateType;
  }

  public void setOtherLoanProviderInterestRateType(OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerOtherLoanProviderInterestRateType otherLoanProviderInterestRateType) {
    this.otherLoanProviderInterestRateType = otherLoanProviderInterestRateType;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner loanInterestFeesCharges(List<OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerLoanInterestFeesChargesInner> loanInterestFeesCharges) {
    this.loanInterestFeesCharges = loanInterestFeesCharges;
    return this;
  }

  public OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner addLoanInterestFeesChargesItem(OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerLoanInterestFeesChargesInner loanInterestFeesChargesItem) {
    if (this.loanInterestFeesCharges == null) {
      this.loanInterestFeesCharges = new ArrayList<>();
    }
    this.loanInterestFeesCharges.add(loanInterestFeesChargesItem);
    return this;
  }

  /**
   * Get loanInterestFeesCharges
   * @return loanInterestFeesCharges
  */
  @Valid 
  @Schema(name = "LoanInterestFeesCharges", required = false)
  public List<OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerLoanInterestFeesChargesInner> getLoanInterestFeesCharges() {
    return loanInterestFeesCharges;
  }

  public void setLoanInterestFeesCharges(List<OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInnerLoanInterestFeesChargesInner> loanInterestFeesCharges) {
    this.loanInterestFeesCharges = loanInterestFeesCharges;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner = (OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner) o;
    return Objects.equals(this.identification, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.identification) &&
        Objects.equals(this.tierValueMinimum, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.tierValueMinimum) &&
        Objects.equals(this.tierValueMaximum, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.tierValueMaximum) &&
        Objects.equals(this.tierValueMinTerm, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.tierValueMinTerm) &&
        Objects.equals(this.minTermPeriod, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.minTermPeriod) &&
        Objects.equals(this.tierValueMaxTerm, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.tierValueMaxTerm) &&
        Objects.equals(this.maxTermPeriod, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.maxTermPeriod) &&
        Objects.equals(this.fixedVariableInterestRateType, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.fixedVariableInterestRateType) &&
        Objects.equals(this.repAPR, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.repAPR) &&
        Objects.equals(this.loanProviderInterestRateType, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.loanProviderInterestRateType) &&
        Objects.equals(this.loanProviderInterestRate, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.loanProviderInterestRate) &&
        Objects.equals(this.notes, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.notes) &&
        Objects.equals(this.otherLoanProviderInterestRateType, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.otherLoanProviderInterestRateType) &&
        Objects.equals(this.loanInterestFeesCharges, obReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner.loanInterestFeesCharges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identification, tierValueMinimum, tierValueMaximum, tierValueMinTerm, minTermPeriod, tierValueMaxTerm, maxTermPeriod, fixedVariableInterestRateType, repAPR, loanProviderInterestRateType, loanProviderInterestRate, notes, otherLoanProviderInterestRateType, loanInterestFeesCharges);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadProduct2DataProductInnerOtherProductTypeLoanInterestLoanInterestTierBandSetInnerLoanInterestTierBandInner {\n");
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
    sb.append("    tierValueMinimum: ").append(toIndentedString(tierValueMinimum)).append("\n");
    sb.append("    tierValueMaximum: ").append(toIndentedString(tierValueMaximum)).append("\n");
    sb.append("    tierValueMinTerm: ").append(toIndentedString(tierValueMinTerm)).append("\n");
    sb.append("    minTermPeriod: ").append(toIndentedString(minTermPeriod)).append("\n");
    sb.append("    tierValueMaxTerm: ").append(toIndentedString(tierValueMaxTerm)).append("\n");
    sb.append("    maxTermPeriod: ").append(toIndentedString(maxTermPeriod)).append("\n");
    sb.append("    fixedVariableInterestRateType: ").append(toIndentedString(fixedVariableInterestRateType)).append("\n");
    sb.append("    repAPR: ").append(toIndentedString(repAPR)).append("\n");
    sb.append("    loanProviderInterestRateType: ").append(toIndentedString(loanProviderInterestRateType)).append("\n");
    sb.append("    loanProviderInterestRate: ").append(toIndentedString(loanProviderInterestRate)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    otherLoanProviderInterestRateType: ").append(toIndentedString(otherLoanProviderInterestRateType)).append("\n");
    sb.append("    loanInterestFeesCharges: ").append(toIndentedString(loanInterestFeesCharges)).append("\n");
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

