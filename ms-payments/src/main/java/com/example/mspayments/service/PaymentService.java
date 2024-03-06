package com.example.mspayments.service;

import com.example.mspayments.constants.StatusConstants;
import com.example.mspayments.dtos.client.notifications.request.SendMessageClientRequest;
import com.example.mspayments.dtos.client.notifications.response.SendMessageClientResponse;
import com.example.mspayments.dtos.host.request.SavePaymentToDBRequest;
import com.example.mspayments.dtos.host.request.SendMoneyRequest;
import com.example.mspayments.entity.PaymentEntity;
import com.example.mspayments.mapper.PaymentMapper;
import com.example.mspayments.repository.PaymentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class PaymentService {

    PaymentRepository paymentRepository;
    PaymentMapper paymentMapper;
    UserService userService;
    NotificationsService notificationsService;
    AsyncPaymentService asyncPaymentService;

    public void savePaymentToDB(SavePaymentToDBRequest request){
        PaymentEntity paymentEntity = paymentMapper.toPaymentEntity(request);
        paymentRepository.save(paymentEntity);
    }

    public void makePaymentAndSendNotification(){
        List<PaymentEntity> deActivePayments = findAllDeActivePayments();

        deActivePayments.forEach(
                //after some payment operations
                payment -> {
                    payment.setStatus(StatusConstants.ACTIVE.getStatus());
                    paymentRepository.save(payment);
                            sendMessage(payment);
                }
        );
    }

    private void sendMessage(PaymentEntity paymentEntity){
        notificationsService.sendMessage(SendMessageClientRequest.builder()
                        .userId(paymentEntity.getCreditorUserId())
                        .message(paymentEntity.getCreditorUserAmount() + paymentEntity.getCreditorUserCurrency() + " has been added to your balance")
                .build());
        notificationsService.sendMessage(SendMessageClientRequest.builder()
                        .userId(paymentEntity.getDebtorUserId())
                        .message(paymentEntity.getDebtorUserAmount() + paymentEntity.getDebtorUserCurrency() + " has been subtracted from your balance")
                .build()) ;
    }

    private List<PaymentEntity> findAllDeActivePayments(){
        return paymentRepository.findAllByStatus(StatusConstants.DE_ACTIVE.getStatus())
                .orElseGet(ArrayList::new);
    }

}
