package com.example.mspayments.repository;

import com.example.mspayments.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {

    Optional<List<PaymentEntity>> findAllByStatus(Integer status);

}
