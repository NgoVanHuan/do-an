package com.example.manager_chemical_test.service;

import com.example.manager_chemical_test.dto.UserResponse;
import com.example.manager_chemical_test.dto.request.UserCreationRequest;
import com.example.manager_chemical_test.dto.request.UserUpdateRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IUserService {

    @PostAuthorize("returnObject.userName == authentication.name")
    UserResponse getById(Long id);

//    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasRole('ADMIN')")
//    @PreAuthorize("hasAuthority('UPDATE_DATA')")
    List<UserResponse> getByAll();

    UserResponse createUser(UserCreationRequest userDTO);

    void deleteUser(Long userId);
    UserResponse updateUser(Long userId, UserUpdateRequest request) ;

    UserResponse getMyInfo();
}
