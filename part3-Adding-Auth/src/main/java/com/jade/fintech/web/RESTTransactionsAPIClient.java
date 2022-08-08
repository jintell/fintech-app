package com.jade.fintech.web;

import com.jade.fintech.adapter.OBTransactionAdapter;
import com.jade.fintech.model.OBTransaction6;
import com.jade.fintech.service.TransactionApiClient;
import com.jade.fintech.web.dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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

    @Value("${open.banking.transactions.endpoint}")
    private String getTransactionEndpoint = "https://api.alphabank.com/open-banking/v3.1/aisp/accounts/{AccountId}/transactions/";

    @Override
    public List<TransactionDto> getTransactionByAccountNumber(Integer accountNumber) throws Exception {
        return transactionAdapter.getTransactions(
                retrieveTransactionByAccountNUmber(accountNumber)
        );
    }

    private List<OBTransaction6> retrieveTransactionByAccountNUmber(Integer accountNumber) {
        Flux<OBTransaction6> transaction6Flux = webClient.get()
                .uri(getTransactionEndpoint, accountNumber)
                .retrieve()
                .bodyToFlux(OBTransaction6.class);
        // Block the thread and retrieve and return the object
        return transaction6Flux
                .timeout(Duration.ofSeconds(1))
                .collectList()
                .block();
    }
}
