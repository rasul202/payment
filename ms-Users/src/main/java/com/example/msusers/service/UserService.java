package com.example.msusers.service;


import com.example.msusers.constants.StatusConstants;
import com.example.msusers.entity.UserEntity;
import com.example.msusers.exceptions.NotFoundException;
import com.example.msusers.mapper.UserMapper;
import com.example.msusers.model.client.payments.request.SavePaymentToDBClientRequest;
import com.example.msusers.model.host.request.SaveUserToDBRequest;
import com.example.msusers.model.host.request.TransferMoneyRequest;
import com.example.msusers.model.host.request.UpdateUserByIdRequest;
import com.example.msusers.model.host.response.GetAllUsersResponse;
import com.example.msusers.model.host.response.SaveUserToDBResponse;
import com.example.msusers.model.host.response.UpdateUserByIdResponse;
import com.example.msusers.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor //for making injection
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PaymentService paymentService;
    CurrencyService currencyService;

    public UserEntity fetchUserByIdAndStatus(Long id){
        return userRepository.findByIdAndStatus(id,StatusConstants.ACTIVE.getStatus())
                .orElseThrow(  () -> new NotFoundException("there is no user with " + id + " id" ,
                          "Not-found" ,
                          LocalDateTime.now()));
    }

    public GetAllUsersResponse getUserById(Long id) {
        return userMapper.toGetAllUsersResponse(fetchUserByIdAndStatus(id));
    }

    public UpdateUserByIdResponse updateUserById(UpdateUserByIdRequest request , Long id){
        UserEntity user = fetchUserByIdAndStatus(id);

        UserEntity newUser = userMapper.updateUser(user,request);

        userRepository.save(newUser);

        return userMapper.toUpdateUserByIdResponse(user);
    }


    public SaveUserToDBResponse saveUserToDB(SaveUserToDBRequest request) {
        UserEntity user = userMapper.toUserEntity(request);
        userRepository.save(user);
        return userMapper.toSaveUserToDBResponse(user);
    }

    public void transferMoney(TransferMoneyRequest request){
        UserEntity debtorUser = getDebtorUser(request.getDebtorUserId());
        UserEntity creditorUser =getCreditorUser(request.getCreditorUserId());

        compareAmountWithDebtorBalance(request.getAmount() , debtorUser.getBalance());

        setDebtorAndCreditorBalance(debtorUser , creditorUser , request );

        userRepository.save(debtorUser);
        userRepository.save(creditorUser);

        paymentService.savePaymentToDB(SavePaymentToDBClientRequest.builder()
                        .debtorUserId(request.getDebtorUserId())
                        .creditorUserId(request.getCreditorUserId())
                        .debtorUserCurrency(debtorUser.getCurrency())
                        .creditorUserCurrency(creditorUser.getCurrency())
                        .debtorUserAmount(request.getDebtorAmount())
                        .creditorUserAmount(request.getCreditorAmount())
                .build());

    }

    private UserEntity getDebtorUser(Long id){
        UserEntity debtorUser = fetchUserByIdAndStatus(id);
        if (debtorUser.getBalance().compareTo(BigDecimal.ZERO) < 1)
            throw new RuntimeException("debtor user has no enough money for making transfer");
        return debtorUser;
    }

    private UserEntity getCreditorUser(Long id){
        UserEntity creditorUser = fetchUserByIdAndStatus(id);
        //some operations can be applied
        return creditorUser;
    }

    private void compareAmountWithDebtorBalance(BigDecimal amount , BigDecimal balance){
        if(balance.compareTo(amount) < 0)
            throw new RuntimeException("your balance insufficient for entered amount");
        //also you can apply some logics about balance and amount
    }

    private void setDebtorAndCreditorBalance(UserEntity debtor , UserEntity creditor , TransferMoneyRequest request){

        request.setDebtorAmount(request.getAmount());
        debtor.setBalance(debtor.getBalance().subtract(request.getDebtorAmount()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = LocalDate.now().format(formatter);

        BigDecimal priceOfCreditorCurrency = currencyService.findPriceOfCurrency(creditor.getCurrency() , formattedDate);
        BigDecimal priceOfDebtorCurrency = currencyService.findPriceOfCurrency(debtor.getCurrency(), formattedDate);

        request.setCreditorAmount(request.getAmount().multiply(priceOfDebtorCurrency).divide(priceOfCreditorCurrency,2, RoundingMode.HALF_UP));
        creditor.setBalance(creditor.getBalance().add(request.getCreditorAmount()));

    }

}




