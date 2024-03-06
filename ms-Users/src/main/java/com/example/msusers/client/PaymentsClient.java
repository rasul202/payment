package com.example.msusers.client;

import com.example.msusers.model.client.payments.request.SavePaymentToDBClientRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "ms-payments" , url = "${urls.ms-payments}")
public interface PaymentsClient {


    @PostMapping("save")
    public void savePaymentToDB(SavePaymentToDBClientRequest request);

}
