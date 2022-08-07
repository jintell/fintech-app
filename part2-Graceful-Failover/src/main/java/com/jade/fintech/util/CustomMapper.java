package com.jade.fintech.util;

import com.jade.fintech.domain.Transaction;
import com.jade.fintech.web.dto.TransactionDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/19/22
 */
public class CustomMapper {

    public static TransactionDto convertToTransactionDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountNumber(transactionDto.getAccountNumber());
        transactionDto.setType(transaction.getType().name());
        transactionDto.setCurrency(transactionDto.getCurrency());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setMerchantName(transaction.getMerchantName());
        transactionDto.setMerchantLogo(transaction.getMerchantLogo());
        return transactionDto;
    }

    public static List<TransactionDto> convertToTransactionDtos(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(CustomMapper::convertToTransactionDto)
                .collect(Collectors.toList());
    }
}
