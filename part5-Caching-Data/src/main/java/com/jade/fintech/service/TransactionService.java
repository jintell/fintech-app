package com.jade.fintech.service;

import com.jade.fintech.domain.Transaction;
import com.jade.fintech.exception.TransactionsNotFoundException;
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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
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

//    @PostFilter("hasAuthority('1234567')")
    @CircuitBreaker(name = "transactionService", fallbackMethod = "transactionNotFound")
    @RateLimiter(name = "transactionService")
    @Bulkhead(name = "bulkheadTransactionService", fallbackMethod = "getTransactionFallback")
    @Retry(name = "retryTransactionService")
    @Cacheable(value = "transactions")
    public List<TransactionDto> findAllByAccountNumber(Integer accountNumber) throws TransactionsNotFoundException {
        log.info("Find transaction with account number {}", accountNumber);
        List<Transaction> transactions = transactionRepository.findByAccountNumber(accountNumber);
        if(transactions.isEmpty()) throw new TransactionsNotFoundException(" No transactions for "+ accountNumber);
        return CustomMapper.convertToTransactionDtos(transactions);
    }

    public List<TransactionDto> pollByAccountNumber(Integer accountNumber) throws Exception {
        List<TransactionDto> transactionsFromApi = apiClient.getTransactionByAccountNumber(accountNumber)
                .stream()
                .peek(transactionDto -> transactionDto.
                        setMerchantLogo(merchantDetailsRepository
                                .getLogo(transactionDto.getMerchantName())))
                .collect(Collectors.toList());
        List<Transaction> transactionsFromDB = transactionRepository.findByAccountNumber(accountNumber);

        List<Transaction> transactions = CustomMapper.convertToTransactions(transactionsFromApi);
        List<Transaction> newTransaction = transactions
                .stream()
                .filter(transaction -> !checkExistence(transaction, transactionsFromDB))
                .collect(Collectors.toList());

        if(!newTransaction.isEmpty())
            transactionRepository.saveAll(newTransaction);

        return transactionsFromApi;
    }

    @Scheduled(fixedRate = (1000 * 60 * 5))
    protected void pollTransactionsByAccountNumber()  {
        List<Integer> accountNumbers = transactionRepository.findWithUniqueAccountNumber();
        accountNumbers.forEach(accountNumber -> {
            try {
                log.info("Polling transaction for {}", accountNumber);
                pollByAccountNumber(accountNumber);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private boolean checkExistence(Transaction transaction, List<Transaction> transactions) {
        return transactions
                .stream()
                .anyMatch(transaction1 -> transaction1.equals(transaction));
    }


    private List<TransactionDto> transactionNotFound(Integer param1, TransactionsNotFoundException e) throws Exception {
        log.error("TransactionsNotFoundException: {} / {}", param1, e.getLocalizedMessage());
        return pollByAccountNumber(param1);
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
