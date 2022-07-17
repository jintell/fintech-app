package com.jade.fintech.service;

import com.jade.fintech.domain.Transaction;

import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/17/22
 */
// Will add the @Service annotation later
public class TransactionService {

    public List<Transaction> findAllByAccountNumber() {
        return List.of(new Transaction(), new Transaction(), new Transaction());
    }
}
