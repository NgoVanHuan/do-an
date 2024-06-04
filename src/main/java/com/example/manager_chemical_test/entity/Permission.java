package com.example.manager_chemical_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permission")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission {
    @Id
    String name;
    String description;

//    @ManyToMany(mappedBy = "role")
//    private List<UsersEntity> user = new ArrayList<>();




//    role_name (Tên vai trò)
//    role_description (Mô tả vai trò)
//    role_permissions (Quyền hạn vai trò)
}