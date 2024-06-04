package com.example.manager_chemical_test.dto;

import com.example.manager_chemical_test.entity.BaseEntity;
import com.example.manager_chemical_test.entity.ChemicalsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoriesDTO extends BaseDTO {
    Long id;
    String createdBy;
    Date createdDate;
    String modifiedBy;
    Date modifiedDate;
    @Size(min = 2, message = "name hon 2")
    String categoryName;
    String description;

}
