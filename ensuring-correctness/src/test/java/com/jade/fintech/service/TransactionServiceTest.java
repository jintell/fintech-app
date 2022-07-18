package com.jade.fintech.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransactionServiceTest {

    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionService();
    }


    @Test
    void findAllByAccountNumber() {
        assertEquals(3, transactionService.findAllByAccountNumber(1234).size());
    }

    @Test
    void listIsNotEmptyTest(){
        assertTrue(transactionService.findAllTransaction().size() > 0);
    }


}