package com.example.mspayments.client;

import com.example.mspayments.dtos.client.users.response.GetUserByIdClientResponse;
import com.example.mspayments.dtos.client.users.request.UpdateUserByIdClientRequest;
import com.example.mspayments.dtos.client.users.response.UpdateUserByIdClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-users" , url = "${urls.ms-users}")
public interface UserClient {

    @GetMapping("{id}")
    public GetUserByIdClientResponse getUserById(@PathVariable Long id);

    @PostMapping("{id}")
    public UpdateUserByIdClientResponse updateUserById(@RequestBody UpdateUserByIdClientRequest request,
                                                       @RequestParam Long id);

}
