package me.geardao.merchant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.geardao.merchant.helper.MD5;

import java.util.Map;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantResponse {
    private String code;
    private String message;
    private Map<String, String> data; // for additional data
    private String checksum;

    public String createChecksum(String secretKey) {
        String data = code + secretKey;
        return MD5.encode(data);
    }

}