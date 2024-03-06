package com.example.msusers.model.host.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransferMoneyRequest {

    Long debtorUserId;
    Long creditorUserId;

    BigDecimal debtorAmount;
    BigDecimal creditorAmount;

    BigDecimal amount;

}
