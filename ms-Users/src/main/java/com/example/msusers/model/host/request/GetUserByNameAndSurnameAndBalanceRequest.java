package com.example.msusers.model.host.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetUserByNameAndSurnameAndBalanceRequest {

    String name;
    String surname;
    BigDecimal balance;

}
