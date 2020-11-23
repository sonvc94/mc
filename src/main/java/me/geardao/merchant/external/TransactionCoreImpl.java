package me.geardao.merchant.external;

import me.geardao.merchant.model.BankRequest;

import java.util.HashMap;
import java.util.Map;

//fake implement
public class TransactionCoreImpl implements TransactionCore {

    @Override
    public Transaction getTransactionById(String id) {
        return Transaction.builder()
                .id(id)
                .amount("100000")
                .build();
    }

    @Override
    public Map<String, String> updateTransaction(BankRequest bankRequest, Transaction transaction) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("code", "00");
        map.put("message", "thanh cong");
        return map;
    }
}
