package com.example.msusers.model.host.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetUsersByNameAndSurnameResponse {

    Long id;
    String name;
    String surname;
    BigDecimal balance;

}
