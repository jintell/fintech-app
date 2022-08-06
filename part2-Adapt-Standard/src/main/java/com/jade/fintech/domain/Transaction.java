package com.jade.fintech.domain;

import com.jade.fintech.constant.TRANSACTION_TYPE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/17/22
 */
@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    private Long id;
    private TRANSACTION_TYPE type;
    @Column(name = "trans_date")
    private Instant date;
    @Column(name = "account_number")
    private Integer accountNumber;
    private String currency;
    private BigDecimal amount;
    @Column(name = "merchant_name")
    private String merchantName;
    @Column(name = "merchant_logo")
    private String merchantLogo;

}
