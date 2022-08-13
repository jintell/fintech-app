package com.jade.fintech.controller;

import com.jade.fintech.repository.impl.MerchantDetailsRepositoryImpl;
import com.jade.fintech.service.TransactionService;
import com.jade.fintech.web.RESTTransactionsAPIClient;
import com.jade.fintech.web.TransactionController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/18/22
 */
public class TransactionComponentTest {

//    @BeforeEach
//    void setup() {
//        RestAssuredMockMvc.standaloneSetup(new TransactionController(getTransactionService()));
//    }
//
//    @Test
//    void testTransactionsWithRestAssured() {
//        int id = 1234;
//        List<Object> size =  given()
//                .when()
//                .get("/api/v1/transactions/{accountNumber}", id)
//                .then()
//                .statusCode(200)
//                .contentType("application/json")
//                .extract().jsonPath().getList("$");
//
//        assertEquals(3, size.size());
//    }
//
//    private TransactionService getTransactionService() {
//        return new TransactionService(getTransactionsAPIClient(), new MerchantDetailsRepositoryImpl());
//    }
//
//    private RESTTransactionsAPIClient getTransactionsAPIClient() {
//        return new RESTTransactionsAPIClient(WebClient.builder().build());
//    }
}
