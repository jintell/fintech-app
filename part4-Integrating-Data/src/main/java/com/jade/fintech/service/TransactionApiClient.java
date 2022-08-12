package com.jade.fintech.service;

import com.jade.fintech.web.dto.TransactionDto;

import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/21/22
 */
public interface TransactionApiClient {

    List<TransactionDto> getTransactionByAccountNumber(Integer accountNumber) throws Exception;
}
