package com.jade.fintech.controller;

import com.jade.fintech.web.TransactionController;
import com.jade.fintech.domain.Transaction;
import com.jade.fintech.repository.TransactionRepository;
import com.jade.fintech.service.TransactionService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/18/22
 */
public class TransactionComponentTest {

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.standaloneSetup(new TransactionController(new TransactionService(new TransactionRepository() {
            @Override
            public List<Transaction> findByAccountNumber(Integer accountNum) {
                return null;
            }

            @Override
            public List<Transaction> findAll() {
                return null;
            }

            @Override
            public List<Transaction> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Transaction> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Transaction> List<S> saveAll(Iterable<S> entities) {
                return null;
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
            public <S extends Transaction> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Transaction> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Transaction> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Transaction> S save(S entity) {
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
            public <S extends Transaction> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
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
        })));
    }

    @Test
    void testTransactionsWithRestAssured() {
        int id = 1234;
        List<Object> size =  given()
                .when()
                .get("/api/v1/transactions/{accountNumber}", id)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract().jsonPath().getList("$");

        assertEquals(3, size.size());
    }
}
