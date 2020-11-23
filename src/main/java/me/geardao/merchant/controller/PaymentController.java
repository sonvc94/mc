package me.geardao.merchant.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import me.geardao.merchant.model.MerchantResponse;
import me.geardao.merchant.model.BankRequest;
import me.geardao.merchant.service.PaymentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    Gson gson;

    PaymentService paymentService;

    public PaymentController(Gson gson, PaymentService paymentService) {
        this.gson = gson;
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String confirm(@RequestBody String request) {
        log.info("request from bank {}", request);
        BankRequest bankRequest = gson.fromJson(request, BankRequest.class);
        MerchantResponse merchantResponse = paymentService.confirm(bankRequest);
        String result = gson.toJson(merchantResponse);
        log.info("response to bank {}", result);
        return result;
    }
}
