package com.example.manager_chemical_test.mapper;


import com.example.manager_chemical_test.dto.CustomerResponse;
import com.example.manager_chemical_test.dto.PermissionResponse;
import com.example.manager_chemical_test.dto.request.CustomerRequest;
import com.example.manager_chemical_test.dto.request.PermissionRequest;
import com.example.manager_chemical_test.dto.request.UserUpdateRequest;
import com.example.manager_chemical_test.entity.CustomersEntity;
import com.example.manager_chemical_test.entity.Permission;
import com.example.manager_chemical_test.entity.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomersEntity toCustomer(CustomerRequest request);
    CustomerResponse toCustomerResponse(CustomersEntity customers);

    void update(@MappingTarget CustomersEntity customers, CustomerRequest request);
}
