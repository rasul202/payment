package com.example.msusers.model.host.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserByIdResponse {

    Long id;
    String name;
    String surname;
    BigDecimal balance;

}
