package com.example.msusers.model.host.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveUserToDBRequest {

    String name;
    String surname;
    BigDecimal balance;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate birthDate;
    String currency;

}

