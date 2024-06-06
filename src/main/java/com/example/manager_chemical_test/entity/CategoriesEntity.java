package com.example.manager_chemical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "categories")
public class CategoriesEntity extends BaseEntity {
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "categories" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @JsonIgnoreProperties(value = "categories")
    private List<ChemicalsEntity> chemicals;
}
