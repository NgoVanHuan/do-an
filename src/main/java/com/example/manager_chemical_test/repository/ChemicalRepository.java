package com.example.manager_chemical_test.repository;

import com.example.manager_chemical_test.entity.ChemicalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ChemicalRepository extends  JpaRepository<ChemicalsEntity, Long> {
}
