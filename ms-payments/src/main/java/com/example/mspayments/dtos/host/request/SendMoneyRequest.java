package com.example.mspayments.dtos.host.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SendMoneyRequest {

    Long debtorUserId;
    Long creditorUserId;

    String currency;
    BigDecimal amount;

}
