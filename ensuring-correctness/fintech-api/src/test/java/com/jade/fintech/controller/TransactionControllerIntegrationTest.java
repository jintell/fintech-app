package com.jade.fintech.controller;

import com.jade.fintech.controllers.TransactionController;
import com.jade.fintech.domain.Transaction;
import com.jade.fintech.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/18/22
 */
@SpringBootTest
@AutoConfigureMockMvc
@Import(TransactionController.class)
public class TransactionControllerIntegrationTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    void getTransactionsTest() throws Exception {

        when(transactionService.findAllByAccountNumber(1234))
                .thenReturn(getTransactionFor3());

       mvc.perform(get("/api/v1/transactions/1234"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$", hasSize(3)));

       verify(transactionService, times(1)).findAllByAccountNumber(1234);
    }

    private List<Transaction> getTransactionFor3() {
        return new TransactionService().findAllByAccountNumber(1234);
    }

}
