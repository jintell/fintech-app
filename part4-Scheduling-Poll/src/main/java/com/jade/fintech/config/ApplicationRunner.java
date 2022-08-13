package com.jade.fintech.config;

import com.jade.fintech.constant.TRANSACTION_TYPE;
import com.jade.fintech.domain.Transaction;
import com.jade.fintech.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 8/7/22
 */
@Profile("dev")
@Configuration
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {
    private final TransactionRepository transactionRepository;

    @Override
    public void run(String... args) {
        // Delete all transaction first
        transactionRepository.deleteAll();
        getTransactions()
                .stream()
                .map(transactionRepository::save)
                .forEach(System.out::println);
    }

    private List<Transaction> getTransactions() {
        return List.of(new Transaction(0L, TRANSACTION_TYPE.CASH, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Acme", "NA" ),
                new Transaction(0L, TRANSACTION_TYPE.CARD, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Globex", "NA" ),
                new Transaction(0L, TRANSACTION_TYPE.TRANSFER, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Morley", "NA" ),
        new Transaction(0L, TRANSACTION_TYPE.TRANSFER, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Contoso", "NA" ),
                new Transaction(0L, TRANSACTION_TYPE.CARD, Instant.now(), 1234567, "USD",
                        new BigDecimal("200.00"), "Morley", "NA" ),
                new Transaction(0L, TRANSACTION_TYPE.TRANSFER, Instant.now(), 1234567, "USD",
                        new BigDecimal("200.00"), "Contoso", "NA" ));
    }
}
