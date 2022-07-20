package com.jade.fintech.service;

import com.jade.fintech.domain.Transaction;
import com.jade.fintech.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/17/22
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {
    
    private final TransactionRepository transactionRepository;

    public List<Transaction> findAllByAccountNumber(Integer accountNumber) {
        log.info("Find transaction with account number {}", accountNumber);
        return transactionRepository.findByAccountNumber(accountNumber);
    }

}
