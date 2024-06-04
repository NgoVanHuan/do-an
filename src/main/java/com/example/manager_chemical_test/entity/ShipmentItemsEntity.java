package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "shipment_items")
public class ShipmentItemsEntity extends  BaseEntity{
    @Column(name = "shipment_item_quantity")
    private Double shipmentItemQuantity;
    @Column(name = "unit_price")
    private  Double unitPrice;
    @Column(name = "item_total")
    private  Double itemTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id")
    private ShipmentsEntity shipments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chemical_id")
    private ChemicalsEntity chemicals;

}
