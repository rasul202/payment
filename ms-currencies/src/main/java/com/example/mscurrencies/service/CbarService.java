package com.example.mscurrencies.service;

import com.example.mscurrencies.client.CbarClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
@RequiredArgsConstructor
public class CbarService {

    CbarClient cbarClient;

    public String getData(String date){
        return cbarClient.getData(date);
    }
    
//    public String getData2(){
//        return cbarClient.getData2();
//    }

}
