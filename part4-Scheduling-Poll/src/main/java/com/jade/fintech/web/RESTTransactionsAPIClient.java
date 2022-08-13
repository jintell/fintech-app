package com.jade.fintech.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jade.fintech.adapter.OBTransactionAdapter;
import com.jade.fintech.domain.ApiResponseDto;
import com.jade.fintech.model.OBTransaction6;
import com.jade.fintech.service.AccessTokenService;
import com.jade.fintech.service.TransactionApiClient;
import com.jade.fintech.web.dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/21/22
 */
@Service
@RequiredArgsConstructor
public class RESTTransactionsAPIClient implements TransactionApiClient {

    private final WebClient webClient;
    private final OBTransactionAdapter transactionAdapter = new OBTransactionAdapter();

    private final AccessTokenService accessTokenService;

    @Value("${open.banking.transactions.endpoint}")
    private String getTransactionEndpoint;

    @Override
    public List<TransactionDto> getTransactionByAccountNumber(Integer accountNumber) throws Exception {;
        return transactionAdapter.getTransactions(
                retrieveTransactionByAccountNUmber(accountNumber)
        );
    }

    private List<OBTransaction6> retrieveTransactionByAccountNUmber(Integer accountNumber) {

        Mono<ApiResponseDto> transaction6Flux = webClient.get()
                .uri(getTransactionEndpoint, accountNumber)
                .header("Authorization", "Bearer "+
                        accessTokenService.getToken().getAccessToken() )
                .header("accept", "application/json")
                .retrieve()
                .bodyToMono(ApiResponseDto.class);

        return transaction6Flux
                .timeout(Duration.ofSeconds(1))
                .block()
                .getData()
                .getTransactions();

    }

}
