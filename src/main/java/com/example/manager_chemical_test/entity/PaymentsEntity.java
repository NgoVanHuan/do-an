package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.NavigableMap;

@Entity
@Table(name = "payments")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsEntity extends  BaseEntity{

    @Column(name = "payment_date")
    private Date paymentDate;
    @Column(name = "payment_method")
    private  String paymentMethod;

    @Column(name = "payment_amount")
    private Double paymentAmount;

    @Column(name = "payment_status")
    private String paymentStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_transaction_id")
    private InventoryTransactionsEntity inventoryTransactions;

}
