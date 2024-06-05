package com.example.manager_chemical_test.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse extends BaseDTO {
    Long id;
    String createdBy;
    Date createdDate;
    String modifiedBy;
    Date modifiedDate;
    String customerName;
    String customerAddress;
    String customerContactInformation;
    String customerPaymentTerms;
    String customerType;
}
