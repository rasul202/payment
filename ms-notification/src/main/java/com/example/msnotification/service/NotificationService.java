package com.example.msnotification.service;

import com.example.msnotification.Dto.request.SendMessageRequest;
import com.example.msnotification.Dto.response.SendMessageResponse;
import com.example.msnotification.entity.NotificationEntity;
import com.example.msnotification.mapper.NotificationMapper;
import com.example.msnotification.repository.NotificationRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class NotificationService {

    NotificationRepository notificationRepository;
    NotificationMapper notificationMapper;

    public SendMessageResponse sendMessage(SendMessageRequest request){
        NotificationEntity notificationEntity = notificationMapper.toEntity(request);
        notificationRepository.save(notificationEntity);
        return notificationMapper.toSendMessageResponse(notificationEntity);
    }
}
