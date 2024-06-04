package com.example.manager_chemical_test.mapper;


import com.example.manager_chemical_test.dto.PermissionResponse;
import com.example.manager_chemical_test.dto.request.PermissionRequest;
import com.example.manager_chemical_test.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
