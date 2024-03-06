package com.example.msusers.controller;


import com.example.msusers.model.host.request.SaveUserToDBRequest;
import com.example.msusers.model.host.request.TransferMoneyRequest;
import com.example.msusers.model.host.request.UpdateUserByIdRequest;
import com.example.msusers.model.host.response.GetAllUsersResponse;
import com.example.msusers.model.host.response.SaveUserToDBResponse;
import com.example.msusers.model.host.response.UpdateUserByIdResponse;
import com.example.msusers.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //the request will be sent over this name
@RequiredArgsConstructor //for making injection
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class UserController {

    UserService userService;

   @GetMapping("{id}")
   public GetAllUsersResponse getUserById(@PathVariable Long id){
       return userService.getUserById(id);
   }

   @PostMapping("{id}")
    public UpdateUserByIdResponse updateUserById(@RequestBody UpdateUserByIdRequest request,
                                                 @RequestParam Long id){
        return userService.updateUserById(request , id);
    }

    @PostMapping("save")
    SaveUserToDBResponse saveUserToDB(@RequestBody SaveUserToDBRequest request){
       return userService.saveUserToDB(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("transfer")
    public void transferMoney(@RequestBody TransferMoneyRequest request){
       userService.transferMoney(request);
    }



}
