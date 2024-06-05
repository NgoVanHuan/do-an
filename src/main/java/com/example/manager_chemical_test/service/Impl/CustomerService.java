package com.example.manager_chemical_test.service.Impl;


import com.example.manager_chemical_test.dto.CustomerResponse;
import com.example.manager_chemical_test.dto.PermissionResponse;
import com.example.manager_chemical_test.dto.UserResponse;
import com.example.manager_chemical_test.dto.request.CustomerRequest;
import com.example.manager_chemical_test.dto.request.PermissionRequest;
import com.example.manager_chemical_test.dto.request.UserUpdateRequest;
import com.example.manager_chemical_test.entity.CustomersEntity;
import com.example.manager_chemical_test.entity.Permission;
import com.example.manager_chemical_test.entity.UsersEntity;
import com.example.manager_chemical_test.exception.AppException;
import com.example.manager_chemical_test.exception.ErrorCode;
import com.example.manager_chemical_test.mapper.CustomerMapper;
import com.example.manager_chemical_test.mapper.PermissionMapper;
import com.example.manager_chemical_test.repository.CustomerRepository;
import com.example.manager_chemical_test.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {
    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    public CustomerResponse create(CustomerRequest request) {
        CustomersEntity customers = customerMapper.toCustomer(request);
        customers = customerRepository.save(customers);
        return customerMapper.toCustomerResponse(customers);
    }

    public CustomerResponse updateUser(Long Id, CustomerRequest request) {
        CustomersEntity customers = customerRepository.findById(Id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        customerMapper.update(customers, request);

          System.out.println(request + " test" );
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//
//        var roles = roleRepository.findAllById(request.getRoles());
//        user.setRoles(new HashSet<>(roles));
        return customerMapper.toCustomerResponse(customerRepository.save(customers));
    }

    public List<CustomerResponse> getAll() {
        var customersEntities = customerRepository.findAll();
        return customersEntities.stream().map(customerMapper::toCustomerResponse).toList();
    }

    public void delete(Long customer) {
        customerRepository.deleteById(customer);
    }
}
