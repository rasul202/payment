package com.example.msusers.model.client.payments.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SavePaymentToDBClientRequest {

    Long debtorUserId;
    Long creditorUserId;

    String debtorUserCurrency;
    String creditorUserCurrency;

    BigDecimal debtorUserAmount;
    BigDecimal creditorUserAmount;

}
