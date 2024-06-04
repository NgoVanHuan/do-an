package com.example.manager_chemical_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class CategoriesEntity extends BaseEntity {
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "categories")
    private List<ChemicalsEntity> chemicals;
}
