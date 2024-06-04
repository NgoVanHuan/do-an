package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "supplier_contacts")
public class SupplierContactsEntity extends BaseEntity{
    @Column(name = "contact_name")
    private String contactName;
    @Column(name ="contact_title")
    private String contact_title;
    @Column(name = "contact_email")
    private String contactEmail;
    @Column(name = "contact_phone_number")
    private String contactPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private SuppliersEntity suppliers;
}
