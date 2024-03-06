package com.example.mspayments.dtos.host.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SavePaymentToDBRequest {

    Long debtorUserId;
    Long creditorUserId;

    String debtorUserCurrency;
    String creditorUserCurrency;

    BigDecimal debtorUserAmount;
    BigDecimal creditorUserAmount;

}
