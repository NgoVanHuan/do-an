package com.example.manager_chemical_test.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "createdBy")
    @CreatedBy
    private String createdBy;

    @Column(name = "createdDate")
    @CreatedDate
    private Date createdDate;

    @Column(name = "modifiedBy")
    @LastModifiedBy
    private String modifiedBy;

    @Column(name = "modifiedDate")
    @LastModifiedDate
    private Date modifiedDate;

}