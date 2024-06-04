package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "suppliers")
public class SuppliersEntity extends BaseEntity{
    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_address")
    private String supplierAddress;
    @Column(name = "supplier_contact_information")
    private String supplierContactInformation;

    @Column(name = "supplier_website")
    private String supplierWebsite;
    @Column(name = "supplier_payment_terms")
    private String supplierPaymentTerms;
    @Column(name = "supplier_type")
    private String supplierType;
    @Column(name = "supplier_rating")
    private Double supplierRating;
    @ManyToMany(mappedBy = "suppliers")
    private List<ChemicalsEntity> chemicals = new ArrayList<>();
    @OneToMany(mappedBy = "suppliers")
    private List<SupplierContactsEntity> supplierContacts;
    @OneToMany(mappedBy = "suppliers")
    private List<ShipmentsEntity> shipments;





}
