package com.example.msusers.service;

import com.example.msusers.client.CurrenciesClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE ,makeFinal = true)
@RequiredArgsConstructor
public class CurrencyService {

    CurrenciesClient currenciesClient;

    public BigDecimal findPriceOfCurrency(String code , String date){
        return currenciesClient.findPriceOfCurrency(code ,date);
    }

}
