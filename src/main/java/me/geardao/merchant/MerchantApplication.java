package me.geardao.merchant;

import com.google.gson.Gson;
import me.geardao.merchant.external.TransactionCore;
import me.geardao.merchant.external.TransactionCoreImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MerchantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MerchantApplication.class, args);
    }

    @Bean
    Gson gson() {
        return new Gson();
    }

    @Bean
    TransactionCore transactionCore() {
        return new TransactionCoreImpl();
    }

}
