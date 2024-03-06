package com.example.mspayments.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class ScheduledTasksService {

    PaymentService paymentService;

//    @Scheduled(fixedDelayString = "PT20S")
    @SchedulerLock(name = "ScheduledTasksService.makePaymentAndSendNotification",
    lockAtLeastFor = "PT15S",
    lockAtMostFor = "PT1M")
    public void makePaymentAndSendNotification(){
        paymentService.makePaymentAndSendNotification();
    }

}
