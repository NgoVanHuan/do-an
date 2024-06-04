package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "shipments")
public class ShipmentsEntity extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chemical_id")
    private ChemicalsEntity chemicals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private SuppliersEntity suppliers;

    @Column(name = "shipment_quantity")
    private Double shipmentQuantity;
    @Column(name = "shipment_status")
    private String shipmentStatus;
    @Column(name = "shipment_date")
    private Date shipmentDate;
    @Column(name = "shipment_method")
    private  String shipmentMethod;
    @Column(name = "shipment_price")
    private Double shipmentPrice;
    @Column(name = "shipment_note")
    private String shipmentNote;
    @OneToMany(mappedBy = "shipments")
    private List<ShipmentItemsEntity> shipmentItems;
    @ManyToMany(mappedBy = "shipments")
    private List<WarehouseLocationsEntity> warehouseLocations = new ArrayList<>();

}
