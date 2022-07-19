package com.jade.fintech.service;

import com.jade.fintech.FintechApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {FintechApiApplication.class})
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void findAllByAccountNumber() {
        assertEquals(3, transactionService.findAllByAccountNumber(1234).size());
    }


}