package com.example.manager_chemical_test.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChemicalDTO  {
     Long id;
     String createdBy;
     Date createdDate;
     String modifiedBy;
     Date modifiedDate;
     String chemicalName;
     String chemicalDescription;
     int casNumber;
     String safetyDataSheetFilePath;
//     List<CategoriesDTO> categories;
     Double flashPoint;
     Double storageTemperatureRange;
     String storageConditions;
     String chemicalType;
     String unitOfMeasure;


}
