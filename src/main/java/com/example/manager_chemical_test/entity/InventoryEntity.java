package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "inventory")
public class InventoryEntity extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chemical_id")
    private ChemicalsEntity chemicals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_location_id")
    private WarehouseLocationsEntity warehouseLocations;

    @Column(name = "inventory_quantity")
    private Double inventoryQuantity;
    @Column(name = "inventory_status")
    private String inventoryStatus; //(Trạng thái tồn kho) (Ví dụ: Sẵn có, Đã đặt hàng, Hết hàng)
    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @OneToMany(mappedBy = "inventory")
    private List<InventoryTransactionsEntity> inventoryTransactions;

}
