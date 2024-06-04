package com.example.manager_chemical_test.mapper;

import com.example.manager_chemical_test.dto.UserResponse;
import com.example.manager_chemical_test.dto.request.UserCreationRequest;
import com.example.manager_chemical_test.dto.request.UserUpdateRequest;
import com.example.manager_chemical_test.entity.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UsersEntity toUser(UserCreationRequest request);
    UserResponse toUserResponse(UsersEntity usersEntity);
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget UsersEntity user, UserUpdateRequest request);

}
