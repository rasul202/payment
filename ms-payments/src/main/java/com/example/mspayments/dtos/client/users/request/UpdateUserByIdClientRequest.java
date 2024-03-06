package com.example.mspayments.dtos.client.users.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserByIdClientRequest {

    BigDecimal balance;
    String surname;

}
