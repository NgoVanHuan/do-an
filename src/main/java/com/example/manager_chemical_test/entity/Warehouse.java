package com.example.manager_chemical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "warehouse")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Warehouse extends BaseEntity {
    String WarehouseName;
    Boolean IsRefrigerated;


//    @OneToMany(mappedBy = "sourceWarehouse")
//    private Set<Transfer> sourceTransfers;
//
//
//    @OneToMany(mappedBy = "destinationWarehouse")
//    private Set<Transfer> destinationTransfers;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties(value ="warehouse")
    private Location location;

    @OneToMany(mappedBy = "warehouse" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @JsonIgnoreProperties(value = "warehouse")
    private List<DeliveryDetail> deliveryDetail;


}
