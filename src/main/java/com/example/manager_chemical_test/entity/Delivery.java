package com.example.manager_chemical_test.entity;

import com.example.manager_chemical_test.entity.Customer;
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
@Table(name = "delivery")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Delivery extends BaseEntity {
    Date SalesDate;//ngày việc bán hàng được thực hiện và yêu cầu giao hàng được tạo.

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties(value ="delivery")
    private Customer customer;

//    @OneToMany(mappedBy = "delivery" ,cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonIgnore
//    @JsonIgnoreProperties(value = "delivery")
//    private List<DeliveryDetail> deliveryDetail;

}
