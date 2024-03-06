package com.example.mscurrencies.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cbar.az" , url = "${urls.cbar.az}")
public interface CbarClient {

    @GetMapping("/{date}.xml") //31.12.2024.xml
    String getData(@PathVariable String date);


//    @GetMapping("/31.12.2024.xml")
//    String getData2();

}
