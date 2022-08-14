package com.jade.fintech.adapter;

import com.jade.fintech.constant.TRANSACTION_TYPE;
import com.jade.fintech.model.OBTransaction6;
import com.jade.fintech.web.dto.TransactionDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/21/22
 */
public class OBTransactionAdapter {

    public TransactionDto getTransaction(OBTransaction6 transaction6) {

        final TransactionDto transactionDto = new TransactionDto();

        if (!validateEntries(transaction6)) return transactionDto;

        transactionDto.setAccountNumber(Integer.parseInt(transaction6.getAccountId()));
        transactionDto.setType(transaction6.getCreditDebitIndicator() == null?
                TRANSACTION_TYPE.DEBIT.name() : transaction6.getCreditDebitIndicator().getValue());
        transactionDto.setCurrency(transaction6.getCurrencyExchange().getUnitCurrency());
        transactionDto.setDate(transaction6.getValueDateTime() == null?
                Instant.now() : transaction6.getValueDateTime().toInstant());
        transactionDto.setAmount((new BigDecimal(transaction6.getAmount().getAmount())
                .multiply(transaction6.getCurrencyExchange().getExchangeRate()))
                .setScale(2, RoundingMode.HALF_EVEN));
        transactionDto.setMerchantName(transaction6.getMerchantDetails().getMerchantName());

        return transactionDto;
    }

    public List<TransactionDto> getTransactions(List<OBTransaction6> obTransaction6s) {
        return obTransaction6s
                .stream()
                .map(this::getTransaction)
                .collect(Collectors.toList());
    }

    private Boolean validateEntries(OBTransaction6 transaction6) {
        boolean valid = true;

        if(transaction6.getAccountId() == null || transaction6.getAccountId().isEmpty()
                || transaction6.getAccountId().length() < 4) return !valid;
        else if(transaction6.getCurrencyExchange() == null ||
                transaction6.getCurrencyExchange().getUnitCurrency().isEmpty()) return !valid;
//        else if(transaction6.getCreditDebitIndicator() == null ) return !valid;
//        else if(transaction6.getValueDateTime() == null ||
//                transaction6.getValueDateTime().toInstant().isAfter(Instant.now())) return !valid;
        else if(transaction6.getAmount() == null ||
                transaction6.getAmount().getAmount().isEmpty() ||
                new BigDecimal(transaction6.getAmount().getAmount())
                        .compareTo(new BigDecimal("0.00")) <= 0) return !valid;
        else if(transaction6.getCurrencyExchange().getExchangeRate() == null ||
                transaction6.getCurrencyExchange().getExchangeRate()
                        .compareTo(new BigDecimal("0.00")) <= 0) return !valid;
        else if(transaction6.getMerchantDetails() == null ||
                transaction6.getMerchantDetails().getMerchantName() == null ||
                transaction6.getMerchantDetails().getMerchantName().isEmpty()) return !valid;
        return valid;
    }
}
