package com.jade.fintech.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/17/22
 */
@Data
@AllArgsConstructor
public class Transaction {
    private String type;
    private LocalDate date;
    private String accountNumber;
    private String currency;
    private BigDecimal amount;
    private String merchantName;
    private String merchantLogo;

}
