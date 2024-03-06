package com.example.mspayments.Controller;

import com.example.mspayments.dtos.host.request.SavePaymentToDBRequest;
import com.example.mspayments.dtos.host.request.SendMoneyRequest;
import com.example.mspayments.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class PaymentController {

    PaymentService paymentService;

    @PostMapping("save")
    public void savePaymentToDB(@RequestBody SavePaymentToDBRequest request){
        paymentService.savePaymentToDB(request);
    }

}
