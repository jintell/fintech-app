package com.jade.fintech.adapter;

import com.jade.fintech.model.*;
import com.jade.fintech.web.dto.TransactionDto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OBTransactionAdapterTest {

    private final OBTransactionAdapter obTransactionAdapter = new OBTransactionAdapter();

    @ParameterizedTest
    @MethodSource("transactionTestCases")
    void getTransaction(OBTransaction6 transaction6, Integer expected1, String expected2, String expected3,
                        Instant expected4, BigDecimal expected5, String expected6) {
        TransactionDto transactionDto = obTransactionAdapter.getTransaction(transaction6);

        assertNotNull(transactionDto);
        assertEquals(expected1 ,transactionDto.getAccountNumber());
        assertEquals(expected2 ,transactionDto.getType());
        assertEquals(expected3 ,transactionDto.getCurrency());
        assertEquals(expected4 ,transactionDto.getDate());
        assertEquals(expected5 ,transactionDto.getAmount());
        assertEquals(expected6 ,transactionDto.getMerchantName());
    }

    static Stream<Arguments> transactionTestCases() {
        boolean defaultConfig = true;
        return Stream.of(
                //T1 - null or missing account id
                Arguments.of(setAccountId(null, !defaultConfig), null, null, null, null , null ,null),
                //T2 - Empty account id
                Arguments.of(setAccountId("", !defaultConfig), null, null, null, null , null ,null),
                //T3 - Account id less than 3. My business rule
                Arguments.of(setAccountId("123", !defaultConfig), null, null, null, null , null ,null),
                //T4 - null or missing  transaction type or creditDebitBalance type
                Arguments.of(setType(!defaultConfig), null, null, null, null , null ,null) ,
                //T5 - null or missing  unit currency
                Arguments.of(setCurrency(null, !defaultConfig), null, null, null, null , null ,null),
                //T6 - Empty unit currency
                Arguments.of(setCurrency(new OBCurrencyExchange5().unitCurrency(""), !defaultConfig),
                        null, null, null, null , null ,null),
                //T7 - null or missing value date
                Arguments.of(setValueDate(null, !defaultConfig), null, null, null, null , null ,null),
                //T8 - Invalid Future transaction date - My Business rule
                Arguments.of(setValueDate(getDate(false), !defaultConfig),
                        null, null, null, null , null ,null),
                //T9 - null or missing amount and null or missing rate
                Arguments.of(setAmountAndRate(null, null, !defaultConfig),
                        null, null, null, null , null ,null),
                //T10 - empty amount and null or missing rate
                Arguments.of(setAmountAndRate(getAmount(""), null, !defaultConfig),
                        null, null, null, null , null ,null),
                //T11 - valid amount and 0 rate
                Arguments.of(setAmountAndRate(getAmount("200.00"),
                                getCurrencyRate("0", 0), !defaultConfig),
                        null, null, null, null , null ,null),
                //T12 - negative amount and valid rate
                Arguments.of(setAmountAndRate(getAmount("-20.00"),
                                getCurrencyRate("1.2", 0), !defaultConfig),
                        null, null, null, null , null ,null),
                //T13 - valid amount and negative rate
                Arguments.of(setAmountAndRate(getAmount("500"),
                                getCurrencyRate("-1.2", 0), !defaultConfig),
                        null, null, null, null , null ,null),
                //T14 - null or missing merchant name
                Arguments.of(setMerchantName(null, !defaultConfig),
                        null, null, null, null , null ,null),
                //T15 - empty merchant name
                Arguments.of(setMerchantName(getMerchantName(""),  !defaultConfig),
                        null, null, null, null , null ,null),
                // T16 - Sunny day scenario
                Arguments.of(setAccountId("1234567", defaultConfig), 1234567, "Debit", "USD",
                        getDate(true).toInstant(), new BigDecimal("178.80") , "ABC Corporation")
        );
    }

    private static OBTransaction6 newOBTransaction6() {
        OBTransaction6 transaction6 = new OBTransaction6();
        OBCurrencyExchange5 currencyExchange5 = getCurrencyRate("USD", 1)
                .exchangeRate(new BigDecimal("1.20"));

        transaction6.accountId("1234567");
        transaction6.creditDebitIndicator(OBCreditDebitCode1.DEBIT);
        transaction6.currencyExchange(currencyExchange5);
        transaction6.valueDateTime(getDate(true));
        transaction6.amount(new OBActiveOrHistoricCurrencyAndAmount9().amount("149.00"));
        transaction6.currencyExchange(currencyExchange5);
        transaction6.merchantDetails(getMerchantName("ABC Corporation"));
        return transaction6;
    }

    private static Date getDate(boolean today) {
        return today ? new Date() : Date.from(LocalDate.now()
                .plusDays(7)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant());
    }
    
    private static OBTransaction6 setAccountId(String accountId, boolean defaultConfig) {
        OBTransaction6 transaction6 = newOBTransaction6();
        if(defaultConfig) return transaction6;
        transaction6.setAccountId(accountId);
        return transaction6;
    }
    
    private static OBTransaction6 setType(boolean defaultConfig) {
        OBTransaction6 transaction6 = newOBTransaction6();
        if(defaultConfig) return transaction6;
        transaction6.setCreditDebitIndicator(null);
        return transaction6;
    }
    
    private static OBTransaction6 setCurrency(OBCurrencyExchange5 currency, boolean defaultConfig) {
        OBTransaction6 transaction6 = newOBTransaction6();
        if(defaultConfig) return transaction6;
        transaction6.setCurrencyExchange(currency);
        return transaction6;
    }
    
    private static OBTransaction6 setValueDate(Date valueDate, boolean defaultConfig) {
        OBTransaction6 transaction6 = newOBTransaction6();
        if(defaultConfig) return transaction6;
        transaction6.setValueDateTime(valueDate);
        return transaction6;
    }
    
    private static OBTransaction6 setAmountAndRate(OBActiveOrHistoricCurrencyAndAmount9 amount, OBCurrencyExchange5 rate,
                                                   boolean defaultConfig) {
        OBTransaction6 transaction6 = newOBTransaction6();
        if(defaultConfig) return transaction6;
        transaction6.setAmount(amount);
        transaction6.setCurrencyExchange(rate);
        return transaction6;
    }
    
    private static OBTransaction6 setMerchantName(OBMerchantDetails1 name, boolean defaultConfig) {
        OBTransaction6 transaction6 = newOBTransaction6();
        if(defaultConfig) return transaction6;
        transaction6.setMerchantDetails(name);
        return transaction6;
    }

    private static OBMerchantDetails1 getMerchantName(String name) {
        return new OBMerchantDetails1().merchantName(name);
    }

    private static OBActiveOrHistoricCurrencyAndAmount9 getAmount(String amt) {
        return new OBActiveOrHistoricCurrencyAndAmount9().amount(amt);
    }

    private static OBCurrencyExchange5 getCurrencyRate(String value, int type) {
        return (type == 0) ? new OBCurrencyExchange5().exchangeRate(new BigDecimal(value)).unitCurrency(value)
         : new OBCurrencyExchange5().unitCurrency(value).exchangeRate(new BigDecimal(0));
    }
    
    
}