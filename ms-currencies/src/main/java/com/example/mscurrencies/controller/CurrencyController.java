package com.example.mscurrencies.controller;

import com.example.mscurrencies.service.CbarService;
import com.example.mscurrencies.service.CurrencyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("currencies")
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
@RequiredArgsConstructor
public class CurrencyController {

    CurrencyService currencyService;


    @GetMapping()
    public BigDecimal findPriceOfCurrency(@RequestParam String code,
                                          @RequestParam String date) {
        return currencyService.findPriceOfCurrency(code, date);
    }

}

