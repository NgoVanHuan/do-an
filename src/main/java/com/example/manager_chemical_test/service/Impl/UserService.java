package com.example.manager_chemical_test.service.Impl;

import com.example.manager_chemical_test.dto.UserResponse;
import com.example.manager_chemical_test.dto.request.UserCreationRequest;
import com.example.manager_chemical_test.dto.request.UserUpdateRequest;
import com.example.manager_chemical_test.entity.Role;
import com.example.manager_chemical_test.entity.UsersEntity;
import com.example.manager_chemical_test.exception.AppException;
import com.example.manager_chemical_test.exception.ErrorCode;
import com.example.manager_chemical_test.mapper.UserMapper;
//import com.example.manager_chemical_test.mapper.UserMapperImpl;
import com.example.manager_chemical_test.repository.RoleRepository;
import com.example.manager_chemical_test.repository.UserRepository;
import com.example.manager_chemical_test.service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService implements IUserService {
    UserRepository userRepository;

    RoleRepository roleRepository;

    RoleService roleService;
    UserMapper userMapper;
//    UserMapperImpl userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse getById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        Optional<UsersEntity> optionalUsersEntity = userRepository.findById(id);
        if (optionalUsersEntity.isPresent()) {
            return userMapper.toUserResponse(optionalUsersEntity.get());
        } else {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
    }

    @Override
    public List<UserResponse> getByAll() {
        log.info("In method get Users");
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }


    @Override
    public UserResponse createUser(UserCreationRequest request) {
            if (userRepository.existsByUserName(request.getUserName())) {
                throw new AppException(ErrorCode.USER_EXISTED);
            }

        UsersEntity usersEntity1 =userMapper.toUser(request);
        usersEntity1.setPassword(passwordEncoder.encode(request.getPassword()));

//        var roles = roleRepository.findAllById(request.getRoles());
//        usersEntity1.setRoles(new HashSet<>(roles));
        log.info("thanhcong");
        return userMapper.toUserResponse(userRepository.save(usersEntity1));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponse updateUser(Long userId, UserUpdateRequest request) {
        UsersEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
//
        userMapper.updateUser(user, request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
//
        var roles = roleRepository.findAllById(request.getRoles());
        user.setRoles(new HashSet<>(roles));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        UsersEntity user = userRepository.findByUserName(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }
}
