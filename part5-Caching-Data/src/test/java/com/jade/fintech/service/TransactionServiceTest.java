package com.jade.fintech.service;

import com.jade.fintech.FintechApiApplication;
import com.jade.fintech.constant.TRANSACTION_TYPE;
import com.jade.fintech.domain.Transaction;
import com.jade.fintech.exception.TransactionsNotFoundException;
import com.jade.fintech.repository.MerchantDetailsRepository;
import com.jade.fintech.util.CustomMapper;
import com.jade.fintech.web.RESTTransactionsAPIClient;
import com.jade.fintech.web.dto.TransactionDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {FintechApiApplication.class})
class TransactionServiceTest {

    @Mock private RESTTransactionsAPIClient apiClient;
    @Mock private MerchantDetailsRepository merchantDetailsRepository;
    @InjectMocks private TransactionService transactionService;

    @Test
    @DisplayName("TransactionService get transactions using mock TransactionApiClient")
    void findAllByAccountNumber() throws Exception, TransactionsNotFoundException {
        when(apiClient.getTransactionByAccountNumber(any()))
                .thenReturn(getTransaction());

        assertEquals(3, transactionService.findAllByAccountNumber(1234).size());
    }

    private  List<TransactionDto> getTransaction() {
        return CustomMapper.convertToTransactionDtos(getTransactionFor3());
    }

    private List<Transaction> getTransactionFor3() {
        return List.of(new Transaction(1L, TRANSACTION_TYPE.CASH, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Temp Investment", "NA" ),
                new Transaction(2L, TRANSACTION_TYPE.CARD, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Temp Investment", "NA" ),
                new Transaction(3L, TRANSACTION_TYPE.TRANSFER, Instant.now(), 1234, "USD",
                        new BigDecimal("200.00"), "Temp Investment", "NA" ) );
    }


}