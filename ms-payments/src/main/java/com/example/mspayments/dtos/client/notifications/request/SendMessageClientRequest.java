package com.example.mspayments.dtos.client.notifications.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SendMessageClientRequest {

    Long userId;
    String message;

}
