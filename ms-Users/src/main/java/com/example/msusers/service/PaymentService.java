package com.example.msusers.service;

import com.example.msusers.client.PaymentsClient;
import com.example.msusers.model.client.payments.request.SavePaymentToDBClientRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class PaymentService {

    PaymentsClient paymentsClient;

    public void savePaymentToDB(SavePaymentToDBClientRequest request){
        paymentsClient.savePaymentToDB(request);
    }

}
