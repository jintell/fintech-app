package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Frequency at which the overdraft charge is applied to the account
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T22:38:36.269814+01:00[Africa/Lagos]")
public enum OBFeeFrequency1Code0 {
  
  FEAC("FEAC"),
  
  FEAO("FEAO"),
  
  FECP("FECP"),
  
  FEDA("FEDA"),
  
  FEHO("FEHO"),
  
  FEI("FEI"),
  
  FEMO("FEMO"),
  
  FEOA("FEOA"),
  
  FEOT("FEOT"),
  
  FEPC("FEPC"),
  
  FEPH("FEPH"),
  
  FEPO("FEPO"),
  
  FEPS("FEPS"),
  
  FEPT("FEPT"),
  
  FEPTA("FEPTA"),
  
  FEPTP("FEPTP"),
  
  FEQU("FEQU"),
  
  FESM("FESM"),
  
  FEST("FEST"),
  
  FEWE("FEWE"),
  
  FEYE("FEYE");

  private String value;

  OBFeeFrequency1Code0(String value) {
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
  public static OBFeeFrequency1Code0 fromValue(String value) {
    for (OBFeeFrequency1Code0 b : OBFeeFrequency1Code0.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

