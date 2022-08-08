package com.jade.fintech.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jade.fintech.constant.TRANSACTION_TYPE;
import com.jade.fintech.domain.Transaction;
import com.jade.fintech.repository.MerchantDetailsRepository;
import com.jade.fintech.repository.TransactionRepository;
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
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
        return new TransactionService(getAPIClient(), getTransactionRepository(), getMerchantDetailsRepository());
    }

    private RESTTransactionsAPIClient getAPIClient() {
        return new RESTTransactionsAPIClient(WebClient.create());
    }

    private MerchantDetailsRepository getMerchantDetailsRepository() {
        return new MerchantDetailsRepositoryImpl();
    }

    private TransactionRepository getTransactionRepository() {
        return new TransactionRepository() {
            @Override
            public List<Transaction> findAll() {
                return null;
            }

            @Override
            public List<Transaction> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<Transaction> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public List<Transaction> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Transaction entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Transaction> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Transaction> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Transaction> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Transaction> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Transaction> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Transaction> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Transaction> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Transaction getOne(Long aLong) {
                return null;
            }

            @Override
            public Transaction getById(Long aLong) {
                return null;
            }

            @Override
            public Transaction getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Transaction> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Transaction> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Transaction> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends Transaction> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Transaction> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Transaction> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Transaction, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }

            @Override
            public List<Transaction> findByAccountNumber(Integer accountNum) {
                return null;
            }
        };
    }


}
