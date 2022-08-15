package com.jade.fintech.domain;

import com.jade.fintech.constant.TRANSACTION_TYPE;
import com.jade.fintech.model.CreditInterest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

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

    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Transaction transaction = (Transaction) obj;
        return Objects.equals(this.accountNumber, transaction.accountNumber) &&
                Objects.equals(this.currency, transaction.currency) &&
                Objects.equals(this.amount, transaction.amount) &&
                Objects.equals(this.merchantName, transaction.merchantLogo);
    }


}
