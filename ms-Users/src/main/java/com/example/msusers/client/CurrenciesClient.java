package com.example.msusers.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "ms-currencies" , url = "${urls.ms-currencies}")
public interface CurrenciesClient {

    @GetMapping()
    BigDecimal findPriceOfCurrency(@RequestParam String code,
                                   @RequestParam String date);

}
