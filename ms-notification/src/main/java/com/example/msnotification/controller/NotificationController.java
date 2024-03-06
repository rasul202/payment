package com.example.msnotification.controller;

import com.example.msnotification.Dto.request.SendMessageRequest;
import com.example.msnotification.Dto.response.SendMessageResponse;
import com.example.msnotification.service.NotificationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RequestMapping("notifications")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class NotificationController {

    NotificationService notificationService;

    @PostMapping()
    public SendMessageResponse sendMessage(@RequestBody SendMessageRequest request){
        return notificationService.sendMessage(request);
    }

}
