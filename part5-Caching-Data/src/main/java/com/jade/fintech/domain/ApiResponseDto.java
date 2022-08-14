package com.jade.fintech.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jade.fintech.model.OBTransaction6;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 8/12/22
 */
@Data
public class ApiResponseDto implements Serializable {

    @JsonProperty("Data")
    private Transaction data;

    @Data
    public static class Transaction {
        @JsonProperty("Transaction")
        private List<OBTransaction6> transactions;
    }
}
