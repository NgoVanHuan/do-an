package com.example.manager_chemical_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "manufacturers")
public class ManufacturersEntity extends BaseEntity {
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    @Column(name = "manufacturer_address")
    private String manufacturerAddress;

    @Column(name = "manufacturer_contact_information")
    private String manufacturerContactInformation;
    @Column(name = "manufacturer_website")
    private String manufacturerWebsite;

    @OneToMany(mappedBy = "manufacturer")
    private List<ChemicalsEntity> chemicals;





}
