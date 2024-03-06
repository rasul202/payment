package com.example.msusers.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@FieldNameConstants //this annotation will give the names of the fields as constant ex: UserEntity.Fields.name will give "name"8
public class UserEntity {

    @Id //it is compulsory for all entities
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String surname;
    BigDecimal balance;
    LocalDateTime created_at;
    Integer status;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate birthDate;
    String currency;


    @PrePersist
    public void assignDefaultValue() {
        this.created_at = LocalDateTime.now();
        this.status = 1;
    }


}
