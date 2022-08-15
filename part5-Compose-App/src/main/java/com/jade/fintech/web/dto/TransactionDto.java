package com.jade.fintech.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/17/22
 */
@Data
public class TransactionDto implements Serializable {
    private String type;
    @JsonIgnore
    private Instant date;
    private String transactionDate;
    private Integer accountNumber;
    private String currency;
    private BigDecimal amount;
    private String merchantName;
    private String merchantLogo;

    public void setStringTransactionDate() {
        transactionDate = date.toString();
    }
}
