package com.example.mspayments.dtos.client.notifications.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SendMessageClientResponse {

    Long userId;
    String message;

}
