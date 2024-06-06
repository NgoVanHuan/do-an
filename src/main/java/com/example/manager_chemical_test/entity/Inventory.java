package com.example.manager_chemical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "inventory")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Inventory extends BaseEntity {
    Long QuantityAvailable;  //SL co san
    Long MinimumStockLevel;  //SL toi thieu de kho khong trong
    Long MaximumStockLevel; //SL toi da de kho khong bi day
    String WarehouseDetail; // vi tri trong kho

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties(value ="inventory")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties(value ="inventory")
    private Warehouse warehouse;

}
