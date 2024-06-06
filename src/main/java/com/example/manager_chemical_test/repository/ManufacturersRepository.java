package com.example.manager_chemical_test.repository;

import com.example.manager_chemical_test.entity.CategoriesEntity;
import com.example.manager_chemical_test.entity.ManufacturersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturersRepository extends JpaRepository<ManufacturersEntity, Long> {
    //boolean existsByCategoryName(String categoryName);
}
