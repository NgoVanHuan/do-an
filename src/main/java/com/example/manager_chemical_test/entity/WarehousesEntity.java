package com.example.manager_chemical_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "warehouses")
public class WarehousesEntity extends  BaseEntity{
    @Column(name = "warehouse_name")
    private  String warehouseName;
    @Column(name = "warehouse_address")
    private  String warehouseAddress;
    @Column(name = "warehouse_capacity")
    private  String warehouseCapacity;
    @Column(name = "warehouse_type")
    private String warehouseType;
    @OneToMany(mappedBy = "warehouses")
    private List<WarehouseLocationsEntity> warehouseLocations;

}
