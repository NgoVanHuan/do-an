package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrdersEntity extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomersEntity customers;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_status")
    private String orderStatus; //(Trạng thái đơn hàng) (Ví dụ: Chờ xử lý, Đang đóng gói, Đã giao hàng)
    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "payment")
    private String payment;//hinh thuc thanh toan , tien mat or chuyen khoan or quet the
    @Column(name = "order_total")
    private  Double orderTotal;

    @Column(name = "delivery_instructions")
    private  String deliveryInstructions; //HUONG DAN GIAO HANG

    @Column(name = "discount")
    private Double discount;

    private int user_id;

}
