package com.example.manager_chemical_test.mapper;

import com.example.manager_chemical_test.dto.RoleResponse;
import com.example.manager_chemical_test.dto.request.RoleRequest;
import com.example.manager_chemical_test.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
