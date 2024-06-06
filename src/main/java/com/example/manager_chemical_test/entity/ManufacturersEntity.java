package com.example.manager_chemical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "manufacturers", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @JsonIgnoreProperties(value = "manufacturers")
    private List<ChemicalsEntity> chemicals;





}
