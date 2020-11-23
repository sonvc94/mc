package me.geardao.merchant.service;

import lombok.extern.slf4j.Slf4j;
import me.geardao.merchant.external.Transaction;
import me.geardao.merchant.external.TransactionCore;
import me.geardao.merchant.model.MerchantResponse;
import me.geardao.merchant.model.BankRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class PaymentService {

    @Value("gr.confirm.secretKey")
    String secretKey;

    TransactionCore transactionCore;

    public PaymentService(TransactionCore transactionCore) {
        this.transactionCore = transactionCore;
    }

    public MerchantResponse confirm(BankRequest bankRequest) {
        log.info("[{}] - begin confirm: {}", bankRequest.getTxnId(), bankRequest);
        MerchantResponse merchantResponse = new MerchantResponse();
        if (!bankRequest.createChecksum(secretKey).equals(bankRequest.getChecksum())) {
            log.info("[{}] - wrong checksum", bankRequest.getTxnId());
            merchantResponse.setCode("11");
            merchantResponse.setMessage("invalid checksum");
            merchantResponse.setChecksum(merchantResponse.createChecksum(secretKey));
            return merchantResponse;
        }
        Transaction transaction = transactionCore.getTransactionById(bankRequest.getTxnId());
        if (!transaction.getAmount().equals(bankRequest.getAmount())) {
            log.info("[{}] - invalid amount", bankRequest.getTxnId());
            Map<String, String> additionData = new HashMap<>();
            additionData.put("amount", transaction.getAmount());
            merchantResponse.setCode("07");
            merchantResponse.setMessage("So tien khong chinh xac");
            merchantResponse.setData(additionData);
            return merchantResponse;
        }
        try {
            Map<String, String> result = transactionCore.updateTransaction(bankRequest, transaction);
            log.info("[{}] - update transaction success, return from merchant core process: {}",
                    bankRequest.getTxnId(), result);
            merchantResponse.setCode(result.get("code"));
            merchantResponse.setMessage(result.get("message"));
            Map<String, String> additionData = new HashMap<>();
            additionData.put("txnId", transaction.getId());
            merchantResponse.setData(additionData);
            return merchantResponse;
        } catch (Exception e) {
            log.error("[{}] - exception when update transaction ", bankRequest.getTxnId(), e);
            merchantResponse.setCode("08");
            merchantResponse.setMessage("Khong ro trang thai giao dich");
            merchantResponse.createChecksum(merchantResponse.createChecksum(secretKey));
            return merchantResponse;
        }
    }
}
