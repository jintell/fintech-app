package com.jade.fintech.service;

import com.jade.fintech.repository.MerchantDetailsRepository;
import com.jade.fintech.repository.TransactionRepository;
import com.jade.fintech.util.CustomMapper;
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
    private final TransactionRepository transactionRepository;
    private final MerchantDetailsRepository merchantDetailsRepository;

    @CircuitBreaker(name = "transactionService", fallbackMethod = "getTransactionFallback")
    @RateLimiter(name = "transactionService")
    @Bulkhead(name = "bulkheadTransactionService", fallbackMethod = "getTransactionFallback")
    @Retry(name = "retryCTransactionService")
    public List<TransactionDto> findAllByAccountNumber(Integer accountNumber) throws Exception {
        log.info("Find transaction with account number {}", accountNumber);
//        return transactionRepository.findByAccountNumber(accountNumber);
        return apiClient.getTransactionByAccountNumber(accountNumber)
                .stream()
                .peek(transactionDto -> transactionDto.
                        setMerchantLogo(merchantDetailsRepository
                                .getLogo(transactionDto.getMerchantName())))
                .collect(Collectors.toList());
    }


    private List<TransactionDto> getTransactionFallback(Integer param1, CallNotPermittedException e) {
        log.error("CallNotPermittedException:: {} / {}", param1, e.getLocalizedMessage());
        return getFallbackTransactions(param1);
    }

    private List<TransactionDto> getTransactionFallback(Integer param1, TimeoutException e) {
        log.error("TimeoutException:: {} / {}", param1, e.getLocalizedMessage());
        return getFallbackTransactions(param1);
    }

    private List<TransactionDto> getTransactionFallback(Integer param1, BulkheadFullException e) {
        log.error("BulkheadFullException:: {} / {}", param1, e.getLocalizedMessage());
        return getFallbackTransactions(param1);
    }

    private List<TransactionDto> getTransactionFallback(Integer param1, NumberFormatException e) {
        log.error("NumberFormatException:: {} / {}", param1, e.getLocalizedMessage());
        return getFallbackTransactions(param1);
    }

    private List<TransactionDto> getTransactionFallback(Integer param1, Exception e) {
        log.error("Exception:: {} / {}", param1, e.getLocalizedMessage());
        return getFallbackTransactions(param1);
    }

    private List<TransactionDto> getFallbackTransactions(Integer accNumber) {
        return CustomMapper.convertToTransactionDtos( transactionRepository.findByAccountNumber(accNumber) );
    }

}
