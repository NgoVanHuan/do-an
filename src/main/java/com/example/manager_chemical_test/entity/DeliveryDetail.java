package com.example.manager_chemical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "deliveryDetail")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class DeliveryDetail extends BaseEntity {
    Long DeliveryQuantity; //SL cu the se duoc phan phoi
    Date ExpectedDate;//Ngay ma sp se toi dia chi
    Date ActualDate; //ngay san pham duoc giao

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties(value ="deliveryDetail")
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties(value ="deliveryDetail")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties(value ="deliveryDetail")
    private Warehouse warehouse;

}
