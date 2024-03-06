package com.example.mspayments.service;

import com.example.mspayments.client.UserClient;
import com.example.mspayments.dtos.client.users.response.GetUserByIdClientResponse;
import com.example.mspayments.dtos.client.users.request.UpdateUserByIdClientRequest;
import com.example.mspayments.dtos.client.users.response.UpdateUserByIdClientResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class UserService {

    UserClient userClient;

}
