package com.jade.fintech.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.jade.fintech.model.OBParty2;
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
 * OBReadParty3Data
 */

@JsonTypeName("OBReadParty3_Data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-20T22:20:45.412805+01:00[Africa/Lagos]")
public class OBReadParty3Data {

  @JsonProperty("Party")
  @Valid
  private List<OBParty2> party = null;

  public OBReadParty3Data party(List<OBParty2> party) {
    this.party = party;
    return this;
  }

  public OBReadParty3Data addPartyItem(OBParty2 partyItem) {
    if (this.party == null) {
      this.party = new ArrayList<>();
    }
    this.party.add(partyItem);
    return this;
  }

  /**
   * Get party
   * @return party
  */
  @Valid 
  @Schema(name = "Party", required = false)
  public List<OBParty2> getParty() {
    return party;
  }

  public void setParty(List<OBParty2> party) {
    this.party = party;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadParty3Data obReadParty3Data = (OBReadParty3Data) o;
    return Objects.equals(this.party, obReadParty3Data.party);
  }

  @Override
  public int hashCode() {
    return Objects.hash(party);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadParty3Data {\n");
    sb.append("    party: ").append(toIndentedString(party)).append("\n");
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

