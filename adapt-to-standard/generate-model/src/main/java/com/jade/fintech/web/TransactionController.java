package com.jade.fintech.web;

import com.jade.fintech.web.dto.TransactionDto;
import com.jade.fintech.service.TransactionService;
import com.jade.fintech.util.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/17/22
 */
@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/{accountNumber}")
    public List<TransactionDto> getTransactions(@PathVariable Integer accountNumber) {
        return CustomMapper.convertToTransactionDtos(
                transactionService.findAllByAccountNumber(accountNumber) );
    }


}
