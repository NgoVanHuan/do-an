package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "chemicals")
public class ChemicalsEntity extends BaseEntity {
 @Column(name = "chemical_name")
 private String chemicalName;
 @Column(name = "chemical_description")
 private String chemicalDescription;
 @Column(name = "cas_number")
 private int casNumber;
 @Column(name = "safety_data_sheet_file_path")
 private String safetyDataSheetFilePath;
 @Column(name = "flash_point")
 private Double flashPoint;
 @Column(name = "storage_temperature_range")
 private Double storageTemperatureRange;
 @Column(name = "storage_conditions")
 private String storageConditions;
 @Column(name = "chemical_type")
 private String chemicalType;
 @Column(name = "unit_of_measure")
 private String unitOfMeasure;

 @ManyToMany
 @JoinTable(name = "chemicals_suppliers",
         joinColumns = @JoinColumn(name = "chemical_id"),
         inverseJoinColumns = @JoinColumn(name = "supplier_id")
 )
 private List<SuppliersEntity> suppliers = new ArrayList<>();
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "category_id")
 private CategoriesEntity categories;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "manufacturer_id")
 private ManufacturersEntity manufacturer;


 @OneToMany(mappedBy = "chemicals")
 private List<ShipmentsEntity> shipments;
 @OneToMany(mappedBy = "chemicals")
 private List<ShipmentItemsEntity> shipmentItems;
 @OneToMany(mappedBy = "chemicals")
 private List<InventoryEntity> inventory;
 @ManyToMany(mappedBy = "chemicals")
 private List<WarehouseLocationsEntity> warehouseLocations = new ArrayList<>();



// @OneToMany(mappedBy = "chemicals")
// private List<invoice_details_entity> invoiceDetails;
//
// @OneToMany(mappedBy = "chemicals")
// private List<order_details_entity> orderDetails;
//
// @OneToMany(mappedBy = "chemicals")
// private List<batche_numbers_entity> batcheNumbers;
//
// @OneToMany(mappedBy = "chemicals")
// private List<safetyDataSheets_entity> safetyDataSheets;
//
// @OneToMany(mappedBy = "chemicals")
// private List<usageInstructions_entity> usageInstructions;
//
// @OneToMany(mappedBy = "chemicals")
// private List<storageConditions_entity> storageConditions;
//
// @OneToMany(mappedBy = "chemicals")
// private List<incidents_entity> incidents;
//
// @OneToMany(mappedBy = "chemicals")
// private List<compositions_entity> compositions;
//
// @OneToMany(mappedBy = "chemicals")
// private List<analysisReports_entity> analysisReports;
//
// @OneToMany(mappedBy = "chemicals")
// private List<purchase_details_entity> purchaseDetails;

}
