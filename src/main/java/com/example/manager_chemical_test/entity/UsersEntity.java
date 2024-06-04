package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "user")
public class UsersEntity extends BaseEntity {
    String userName;
    String password;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    @ManyToMany
    Set<Role> roles;

//    @ManyToMany
//    @JoinTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private List<RoleEntity> role = new ArrayList<>();

}