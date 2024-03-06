package com.example.mspayments.mapper;

import com.example.mspayments.dtos.host.request.SavePaymentToDBRequest;
import com.example.mspayments.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PaymentMapper {

    PaymentEntity toPaymentEntity(SavePaymentToDBRequest request);

}
