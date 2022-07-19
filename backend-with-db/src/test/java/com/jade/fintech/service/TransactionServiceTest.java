package com.jade.fintech.service;

import com.jade.fintech.constant.TRANSACTION_TYPE;
import com.jade.fintech.domain.Transaction;
import com.jade.fintech.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private TransactionService transactionService;



    @Test
    void findAllByAccountNumber() {
        when(transactionService.findAllByAccountNumber(1234))
                .thenReturn(getTransactionFor3());

        assertEquals(3, transactionService.findAllByAccountNumber(1234).size());
    }

    private List<Transaction> getTransactionFor3() {
        return List.of(new Transaction(1L, TRANSACTION_TYPE.CASH, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Temp Investment", "NA" ),
                new Transaction(2L, TRANSACTION_TYPE.CARD, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Temp Investment", "NA" ),
                new Transaction(3L, TRANSACTION_TYPE.TRANSFER, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Temp Investment", "NA" ) );
    }


}