package com.jade.fintech.service;

import com.jade.fintech.repository.MerchantDetailsRepository;
import com.jade.fintech.web.RESTTransactionsAPIClient;
import com.jade.fintech.web.dto.TransactionDto;
import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/17/22
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {
    
    private final RESTTransactionsAPIClient apiClient;
    private final MerchantDetailsRepository merchantDetailsRepository;

    private final List<TransactionDto> EMPTY = new ArrayList<>();

    @CircuitBreaker(name = "transactionService", fallbackMethod = "fallback")
    @RateLimiter(name = "transactionService")
    @Bulkhead(name = "bulkheadTransactionService", fallbackMethod = "fallback")
    @Retry(name = "retryCTransactionService")
    @TimeLimiter(name = "transactionService", fallbackMethod = "fallback")
    public List<TransactionDto> findAllByAccountNumber(Integer accountNumber) {
        log.info("Find transaction with account number {}", accountNumber);
//        return transactionRepository.findByAccountNumber(accountNumber);
        return apiClient.getTransactionByAccountNumber(accountNumber)
                .stream()
                .peek(transactionDto -> transactionDto.
                        setMerchantLogo(merchantDetailsRepository
                                .getLogo(transactionDto.getMerchantName())))
                .collect(Collectors.toList());
    }


    private List<TransactionDto> fallback(String param1, CallNotPermittedException e) {
        log.error("{} / {}", param1, e.getLocalizedMessage());
        return EMPTY;
    }

    private List<TransactionDto> fallback(String param1, TimeoutException e) {
        log.error("Timeout: {} / {}", param1, e.getLocalizedMessage());
        return EMPTY;
    }

    private List<TransactionDto> fallback(String param1, BulkheadFullException e) {
        log.error("{} / {}", param1, e.getLocalizedMessage());
        return EMPTY;
    }

    private List<TransactionDto> fallback(String param1, NumberFormatException e) {
        log.error("{} / {}", param1, e.getLocalizedMessage());
        return EMPTY;
    }

    private List<TransactionDto> fallback(String param1, Exception e) {
        return EMPTY;
    }

}
