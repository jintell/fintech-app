package com.jade.fintech.service;

import com.jade.fintech.domain.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/17/22
 */
@Slf4j
@Service
public class TransactionService {

    public List<Transaction> findAllByAccountNumber(Integer accountNumber) {
        log.info("Find transaction with account number {}", accountNumber);
        return getAllTransaction()
                .stream()
                .filter(transaction ->  transaction.getAccountNumber().compareTo(accountNumber) == 0)
                .collect(Collectors.toList());
    }

    public List<Transaction> findAllTransaction() {
        return getAllTransaction();
    }

    private List<Transaction> getAllTransaction() {
        return List.of(new Transaction(1L,"Current", LocalDate.now(), 1234, "USD",
                        new BigDecimal(250), "ABC Corps", "Na"),
                new Transaction(2L,"Savings", LocalDate.now(), 5678, "USD",
                        new BigDecimal(150), "XYZ Ltd", "Na"),
                new Transaction(3L,"Checking", LocalDate.now(), 90123, "USD",
                        new BigDecimal(550), "Insight", "Na"),
                new Transaction(4L,"Saving", LocalDate.now(), 1234, "USD",
                        new BigDecimal(600), "ABC Corps", "Na"),
                new Transaction(5L,"Checking", LocalDate.now(), 1234, "USD",
                        new BigDecimal(1000), "ABC Corps", "Na") );
    }
}
