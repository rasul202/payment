package com.example.mspayments.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "payments")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants //it holds all fields as Constants call them with PaymentEntity.Fields.name
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long debtorUserId;
    Long creditorUserId;

    String debtorUserCurrency;
    String creditorUserCurrency;

    BigDecimal debtorUserAmount;
    BigDecimal creditorUserAmount;

    Integer status;
    LocalDateTime createdAt;

    @PrePersist
    public void setDefaults(){
        this.createdAt = LocalDateTime.now();
        this.status = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
