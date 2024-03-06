package com.example.mspayments.client;

import com.example.mspayments.dtos.client.notifications.request.SendMessageClientRequest;
import com.example.mspayments.dtos.client.notifications.response.SendMessageClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-notifications" , url = "${urls.ms-notifications}")
public interface NotificationClient {

    @PostMapping
    SendMessageClientResponse sendMessage(@RequestBody SendMessageClientRequest request);

}
