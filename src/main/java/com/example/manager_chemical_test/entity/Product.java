package com.example.manager_chemical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {

    String ProductCode;
    String Barcode;
    String ProductName;
    String ProductDescription;
    Long PackedWeight;
    Long PackedHeight;
    Long PackedWidth;
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonIgnoreProperties(value = "product")
//    private CategoriesEntity categories;

    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @JsonIgnoreProperties(value = "product")
    private List<OrderDetail> orderDetail;

    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @JsonIgnoreProperties(value = "product")
    private List<DeliveryDetail> deliveryDetail;

    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @JsonIgnoreProperties(value = "product")
    private List<Inventory> inventory;

    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @JsonIgnoreProperties(value = "product")
    private List<Transfer> transfer;

}
