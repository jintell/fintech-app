package com.jade.fintech.exception;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 8/13/22
 */
public class TransactionsNotFoundException extends Throwable {

    public TransactionsNotFoundException(String message) {
        super(message);
    }
}
