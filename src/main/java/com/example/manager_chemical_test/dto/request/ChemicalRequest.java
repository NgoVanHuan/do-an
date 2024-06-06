package com.example.manager_chemical_test.dto.request;

import com.example.manager_chemical_test.dto.BaseDTO;
import com.example.manager_chemical_test.dto.CategoriesDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChemicalRequest extends BaseDTO {
     Long id;
     String createdBy;
     Date createdDate;
     String modifiedBy;
     Date modifiedDate;
     String chemicalName;
     String chemicalDescription;
     int casNumber;
     String safetyDataSheetFilePath;
     Long categoryId;
     Double flashPoint;
     Double storageTemperatureRange;
     String storageConditions;
     String chemicalType;
     String unitOfMeasure;

}
