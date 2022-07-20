package com.jade.fintech.util;

import com.jade.fintech.domain.Transaction;
import com.jade.fintech.web.dto.TransactionDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/19/22
 */
public class CustomMapper {

    public static TransactionDto convertToTransactionDto(Transaction transaction){
        return TransactionDto.builder()
                .type(transaction.getType().name())
                .accountNumber(transaction.getAccountNumber())
                .amount(transaction.getAmount())
                .currency(transaction.getCurrency())
                .date(transaction.getDate())
                .merchantLogo(transaction.getMerchantLogo())
                .merchantName(transaction.getMerchantName())
                .build();
    }

    public static List<TransactionDto> convertToTransactionDtos(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(CustomMapper::convertToTransactionDto)
                .collect(Collectors.toList());
    }
}
