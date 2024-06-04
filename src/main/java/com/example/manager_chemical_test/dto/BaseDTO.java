package com.example.manager_chemical_test.dto;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public abstract class BaseDTO {
     Long id;
     String createdBy;
     Date createdDate;
     String modifiedBy;
     Date modifiedDate;
    //private List<T> listResult = new ArrayList<>();


}
