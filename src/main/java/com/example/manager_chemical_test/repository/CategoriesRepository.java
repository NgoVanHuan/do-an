package com.example.manager_chemical_test.repository;

import com.example.manager_chemical_test.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Long> {
    boolean existsByCategoryName(String categoryName);
}
