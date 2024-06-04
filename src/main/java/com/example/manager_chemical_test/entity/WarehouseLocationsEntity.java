package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "warehouse_locations")
public class WarehouseLocationsEntity extends  BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private WarehousesEntity warehouses;

    @Column(name = "aisle")
    private  String aisle;
    @Column(name = "rack")
    private  String rack;
    @Column(name = "bin")
    private String bin;
    @Column(name = "location_capacity")
    private String locationCapacity;

    @Column(name = "storage_type")//Ghi lại loại hóa chất hoặc hàng hóa phù hợp để lưu trữ tại vị trí này (ví dụ: chất lỏng, chất rắn, hóa chất nguy hiểm).
    private String storageType;

    @ManyToMany
    @JoinTable(name = "warehouse_locations_chemicals",
            joinColumns = @JoinColumn(name = "warehouse_locations_id"),
            inverseJoinColumns = @JoinColumn(name = "chemical_id")
    )
    private List<ChemicalsEntity> chemicals = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "warehouse_locations_shipments",
            joinColumns = @JoinColumn(name = "warehouse_locations_id"),
            inverseJoinColumns = @JoinColumn(name = "shipment_id")
    )
    private List<ShipmentsEntity> shipments = new ArrayList<>();



}
