package me.geardao.merchant.external;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
    private String id;
    private String amount;
    //......
}
