package com.example.manager_chemical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "chemicals")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ChemicalsEntity extends BaseEntity {
  @Column(name = "chemical_name")
  String chemicalName;
  @Column(name = "chemical_description")
  String chemicalDescription;
  @Column(name = "cas_number")
  int casNumber;
  @Column(name = "safety_datasheetfilepath")
  String safetyDatasheetfilepath;
  @Column(name = "flash_point")
  Double flashPoint;
  @Column(name = "storage_temperaturerange")
  Double storageTemperaturerange;
 @Column(name = "storage_conditions")
  String storageConditions;
 @Column(name = "chemical_type")
  String chemicalType;
 @Column(name ="unit_ofmeasure" )
  String unitOfmeasure;

// @ManyToMany
// @JoinTable(name = "chemicals_suppliers",
//         joinColumns = @JoinColumn(name = "chemical_id"),
//         inverseJoinColumns = @JoinColumn(name = "supplier_id")
// )
// private List<SuppliersEntity> suppliers;
 @ManyToOne
 @JoinColumn(name = "category_id")
 @EqualsAndHashCode.Exclude
 @ToString.Exclude
 @JsonIgnoreProperties(value = "chemicals")
 private CategoriesEntity categories;
 @ManyToOne
 @EqualsAndHashCode.Exclude
 @ToString.Exclude
 @JsonIgnoreProperties(value = "chemicals")
 @JoinColumn(name = "manufacturer_id")
 private ManufacturersEntity manufacturers;
// @ManyToMany(mappedBy = "chemicals")
// private List<WarehouseLocationsEntity> warehouseLocations ;
// @OneToMany(mappedBy = "chemicals")
// private List<ShipmentsEntity> shipments;
// @OneToMany(mappedBy = "chemicals")
// private List<ShipmentItemsEntity> shipmentItems;
// @OneToMany(mappedBy = "chemicals")
// private List<InventoryEntity> inventory;

}
