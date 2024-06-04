package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "role")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {
    @Id
    String name;
    String description;

    @ManyToMany
    Set<Permission> permissions;

//    @ManyToMany(mappedBy = "role")
//    private List<UsersEntity> user = new ArrayList<>();




//    role_name (Tên vai trò)
//    role_description (Mô tả vai trò)
//    role_permissions (Quyền hạn vai trò)
}