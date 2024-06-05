package com.example.manager_chemical_test.repository;

import com.example.manager_chemical_test.entity.CustomersEntity;
import com.example.manager_chemical_test.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomersEntity,Long> {}
