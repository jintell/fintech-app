package com.jade.fintech.controller;

import com.jade.fintech.controllers.TransactionController;
import com.jade.fintech.service.TransactionService;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
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
        RestAssuredMockMvc.standaloneSetup(new TransactionController(new TransactionService()));
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
