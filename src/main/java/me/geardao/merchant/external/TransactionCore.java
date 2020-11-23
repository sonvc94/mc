package me.geardao.merchant.external;

import me.geardao.merchant.model.BankRequest;

import java.util.Map;

public interface TransactionCore {

    /**
     * get transaction from merchant's system to compare with information that received from bank
     * @return Transaction
     */
    Transaction getTransactionById(String id);

    /**
     * call to merchant core to update transaction status, Convert code, message from merchant's core process to Bank
     * response contain code, message, ...
     * @param bankRequest, contain information from bank request
     * @param transaction, contain id, amount, etc ..
     * @return Map<String, String> contain code, message, etc ...
     * @throws Exception: timeout exception ...
     */
    Map<String, String> updateTransaction(BankRequest bankRequest, Transaction transaction) throws Exception;
}
