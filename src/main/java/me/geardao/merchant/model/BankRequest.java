package me.geardao.merchant.model;

import lombok.Builder;
import lombok.Data;
import me.geardao.merchant.helper.MD5;

import java.util.List;

@Data
@Builder
public class BankRequest {
    private String code;
    private String message;
    private String msgType;
    private String txnId;
    private String qrTrace;
    private String bankCode;
    private String mobile;
    private String accountNo;
    private String amount;
    private String payDate;
    private String masterMerCode;
    private String merchantCode;
    private String terminalId;
    private List<QrCodeItemPayment> addData;
    private String checksum;
    private String urlMerchant;
    private String ccy;
    private String address;
    private String txnSaleAmount;
    private String realAmount;
    private String note;
    private String voucherCode;
    private String tipAmount;

    public String createChecksum(String secretKey) {
        String data = this.getCode() + "|"
                + this.getMsgType() + "|"
                + this.getTxnId() + "|"
                + this.getQrTrace() + "|"
                + this.getBankCode() + "|"
                + this.getMobile() + "|"
                + this.getAccountNo() + "|"
                + this.getAmount() + "|"
                + this.getPayDate() + "|"
                + this.getMerchantCode() + "|"
                + secretKey;
        return MD5.encode(data);
    }
}
