package me.geardao.merchant.model;

import lombok.Data;

@Data
public class QrCodeItemPayment {
    private String merchantType;
    private String serviceCode;
    private String masterMerCode;
    private String merchantCode;
    private String terminalId;
    private String productId;
    private String amount;
    private String tipAndFee;
    private String ccy;
    private String qty;
    private String note;
}
