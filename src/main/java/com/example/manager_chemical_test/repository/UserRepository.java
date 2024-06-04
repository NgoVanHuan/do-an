package com.example.manager_chemical_test.repository;

import com.example.manager_chemical_test.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity,Long> {
    boolean existsByUserName(String userName);
    Optional<UsersEntity> findByUserName(String userName);
}
