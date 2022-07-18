package com.jade.fintech.service;

import com.jade.fintech.domain.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/17/22
 */
@Service
public class TransactionService {

    public List<Transaction> findAllByAccountNumber(String accountNumber) {
        return List.of(new Transaction("Current", LocalDate.now(), "1234", "USD",
                        new BigDecimal(250), "ABC Corps", "Na"),
                new Transaction("Savings", LocalDate.now(), "5678", "USD",
                        new BigDecimal(150), "XYZ Ltd", "Na"),
                new Transaction("Checking", LocalDate.now(), "90123", "USD",
                        new BigDecimal(550), "Insight", "Na") );
    }
}
