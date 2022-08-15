package com.jade.fintech.controller;

import com.jade.fintech.FintechApiApplication;
import com.jade.fintech.exception.TransactionsNotFoundException;
import com.jade.fintech.service.TransactionService;
import com.jade.fintech.util.CustomMapper;
import com.jade.fintech.web.dto.TransactionDto;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 8/10/22
 */
@AutoConfigureMockMvc
@SpringBootTest(classes = {FintechApiApplication.class})
@ActiveProfiles("dev")
public class TransactionControllerIntegrationWithOAuthTest {

    private static final String CLIENT_ID = "open-banking";
    private static final String CLIENT_SECRET = "UzE0EMyU8YIpVWGE8aRnZHyfdYA7Vnb9";

    @MockBean
    private TransactionService transactionService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findTransactionsByAccountNumberWithAuthenticationTest() throws Exception {
        String access_token = obtainAccessToken("josleke", "1234567");

        mockMvc.perform(get("/api/v1/transactions/1234567")
                .header("Authorization", "Bearer " + access_token)
                .accept("application/json;charset=UTF-8")
        )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void findTransactionsByAccountNumberWithoutAuthenticationTest() throws Exception, TransactionsNotFoundException {
        when(transactionService.findAllByAccountNumber(1234))
                .thenReturn(List.of(new TransactionDto()));

        mockMvc.perform(
                get("/api/v1/transactions/12345")
        ).andExpect(status().is4xxClientError());
 }

    private String obtainAccessToken(String username, String password) throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", CLIENT_ID);
        params.add("scope", "open-banking");
        params.add("username", username);
        params.add("password", password);

        WebClient webClient = WebClient.create("http://localhost:9001");
        String resultString = webClient.post()
                .uri("/realms/open-banking/protocol/openid-connect/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .header("Authorization", httpBasic(CLIENT_ID, CLIENT_SECRET))
                .body(BodyInserters.fromFormData(params))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

    private String httpBasic(String username, String password) {
        return "Basic " + Base64.encodeBase64String((username+":"+password).getBytes());
    }
}
