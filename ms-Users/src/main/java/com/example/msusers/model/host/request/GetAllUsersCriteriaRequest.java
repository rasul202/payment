package com.example.msusers.model.host.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetAllUsersCriteriaRequest {

    String name;
    String surname;

    BigDecimal toBalance;
    BigDecimal fromBalance;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate toBirthDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate fromBirthDate;

}
