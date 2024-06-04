package com.example.manager_chemical_test.entity;

import com.fasterxml.jackson.core.sym.NameN;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class CustomersEntity extends  BaseEntity{
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_address")
    private String customerAddress;
    @Column(name = "customer_contact_information")
    private String customerContactInformation;
    @Column(name = "customer_payment_terms")
    private String customerPaymentTerms;
    @Column(name = "customer_type")
    private String customerType; //(Loại khách hàng) (Ví dụ: Đại lý, Nhà bán lẻ, Khách hàng cuối cùng)

    @OneToMany(mappedBy = "customers")
    private List<OrdersEntity> orders;
}
