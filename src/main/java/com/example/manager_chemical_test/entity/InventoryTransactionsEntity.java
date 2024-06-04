package com.example.manager_chemical_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "inventory_transactions")
public class InventoryTransactionsEntity extends  BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private InventoryEntity inventory;

    @Column(name = "transaction_date")
    private Date transactionDate;
    @Column(name = "transaction_type")
    private String transactionType; //Loại giao dịch) (Ví dụ: Nhập kho, Xuất kho, Điều chỉnh)

    @Column(name = "transaction_quantity")
    private Double transactionQuantity;
     @Column(name = "reference_document")
    private String referenceDocument; //(Tài liệu tham khảo) (Ví dụ: Hóa đơn, Phiếu xuất kho)
    @Column(name = "transaction_reason")
    private String transactionReason; // Ly do giao dich

    @OneToMany(mappedBy = "inventoryTransactions")
    private List<PaymentsEntity> payments;

    private int user_id;

}
