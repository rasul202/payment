package com.example.mspayments.service;

import com.example.mspayments.client.NotificationClient;
import com.example.mspayments.dtos.client.notifications.request.SendMessageClientRequest;
import com.example.mspayments.dtos.client.notifications.response.SendMessageClientResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class NotificationsService {

    NotificationClient notificationClient;

    public SendMessageClientResponse sendMessage(SendMessageClientRequest request){
        return notificationClient.sendMessage(request);
    }

}
