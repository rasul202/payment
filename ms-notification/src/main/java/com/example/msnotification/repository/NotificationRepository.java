package com.example.msnotification.repository;

import com.example.msnotification.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity , Long> {



}
