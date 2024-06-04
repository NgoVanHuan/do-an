package com.example.manager_chemical_test.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserUpdateRequest {
    Long id;
    String createdBy;
    Date createdDate;
    String modifiedBy;
    Date modifiedDate;

//    @Size(min = 6, message = "USERNAME_INVALID")
    String userName;
//    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    List<String> roles;
}
