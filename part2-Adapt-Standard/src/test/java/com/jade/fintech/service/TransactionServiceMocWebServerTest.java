package com.jade.fintech.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jade.fintech.constant.TRANSACTION_TYPE;
import com.jade.fintech.domain.Transaction;
import com.jade.fintech.repository.MerchantDetailsRepository;
import com.jade.fintech.repository.impl.MerchantDetailsRepositoryImpl;
import com.jade.fintech.util.CustomMapper;
import com.jade.fintech.web.RESTTransactionsAPIClient;
import com.jade.fintech.web.dto.TransactionDto;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 8/6/22
 */
public class TransactionServiceMocWebServerTest {

    public static MockWebServer mockBackEnd;

    @BeforeAll
     static void setup() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @Test
    void getTransactionByAccountIDTest() throws Exception {
        mockBackEnd.enqueue(new MockResponse()
                .setBody(new Gson().toJson(getTransaction()))
                .addHeader("Content-Type", "application/json"));

        List<TransactionDto> transactionDtoList = getTransactionService().findAllByAccountNumber(22289);

        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/accounts/22289/transactions", recordedRequest.getPath());

    }

    private List<TransactionDto> getTransaction() {
        return CustomMapper.convertToTransactionDtos(getTransactionFor3());
    }

    private List<Transaction> getTransactionFor3() {
        return List.of(new Transaction(1L, TRANSACTION_TYPE.CASH, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Temp Investment", "NA" ),
                new Transaction(2L, TRANSACTION_TYPE.CARD, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Temp Investment", "NA" ),
                new Transaction(3L, TRANSACTION_TYPE.TRANSFER, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Temp Investment", "NA" ) );
    }

    private TransactionService getTransactionService() {
        return new TransactionService(getAPIClient(), getMerchantDetailsRepository());
    }

    private RESTTransactionsAPIClient getAPIClient() {
        return new RESTTransactionsAPIClient(WebClient.create());
    }

    private MerchantDetailsRepository getMerchantDetailsRepository() {
        return new MerchantDetailsRepositoryImpl();
    }


}
