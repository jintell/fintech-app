package com.jade.fintech.repository;

import com.jade.fintech.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/19/22
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountNumber(Integer accountNum);

    @Query("select distinct t.accountNumber from Transaction t")
    List<Integer> findWithUniqueAccountNumber();
}
