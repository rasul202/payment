package com.example.mspayments.service;


import com.example.mspayments.dtos.client.users.response.GetUserByIdClientResponse;
import com.example.mspayments.dtos.client.users.request.UpdateUserByIdClientRequest;
import com.example.mspayments.dtos.host.request.SendMoneyRequest;
import com.example.mspayments.entity.PaymentEntity;
import com.example.mspayments.repository.PaymentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class AsyncPaymentService {

    UserService userService;
    PaymentRepository paymentRepository;

    @Async("asyncExecutor")
    @SneakyThrows
    public void asyncMethod(){
        Thread.sleep(10000);
    }

}
