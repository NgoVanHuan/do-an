package com.example.manager_chemical_test.dto.request;

import com.example.manager_chemical_test.dto.ChemicalDTO;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {
    Long id;
    String createdBy;
    Date createdDate;
    String modifiedBy;
    Date modifiedDate;
    @Size(min = 2, message = "name hon 2")
    String categoryName;
    String description;
    List<ChemicalDTO> chemicals;
}
