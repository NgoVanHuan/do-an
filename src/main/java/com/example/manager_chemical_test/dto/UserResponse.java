package com.example.manager_chemical_test.dto;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String createdBy;
    Date createdDate;
    String modifiedBy;
    Date modifiedDate;
    String userName;
    String password;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    Set<RoleResponse> roles;

}
