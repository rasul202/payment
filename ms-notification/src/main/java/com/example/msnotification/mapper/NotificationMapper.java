package com.example.msnotification.mapper;

import com.example.msnotification.Dto.request.SendMessageRequest;
import com.example.msnotification.Dto.response.SendMessageResponse;
import com.example.msnotification.entity.NotificationEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface NotificationMapper {

    NotificationEntity toEntity(SendMessageRequest request);

    SendMessageResponse toSendMessageResponse(NotificationEntity entity);

}
