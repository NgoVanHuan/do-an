package com.example.manager_chemical_test.repository;


import com.example.manager_chemical_test.entity.Role;
import com.example.manager_chemical_test.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
