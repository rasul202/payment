package com.example.msusers.mapper;

import com.example.msusers.entity.UserEntity;
import com.example.msusers.model.host.request.SaveUserToDBRequest;
import com.example.msusers.model.host.request.UpdateUserByIdRequest;
import com.example.msusers.model.host.response.GetAllUsersResponse;
import com.example.msusers.model.host.response.SaveUserToDBResponse;
import com.example.msusers.model.host.response.UpdateUserByIdResponse;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    GetAllUsersResponse toGetAllUsersResponse(UserEntity user);

    UserEntity updateUser(@MappingTarget UserEntity user , UpdateUserByIdRequest request);

    UpdateUserByIdResponse toUpdateUserByIdResponse(UserEntity user);

    UserEntity toUserEntity(SaveUserToDBRequest request);

    SaveUserToDBResponse toSaveUserToDBResponse(UserEntity user);

}
