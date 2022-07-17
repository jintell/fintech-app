package com.jade.fintech.service;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    @Test
    void findAllByAccountNumber() {
        TransactionService transactionService = new TransactionService();
        assertEquals(3, transactionService.findAllByAccountNumber().size());
    }
}