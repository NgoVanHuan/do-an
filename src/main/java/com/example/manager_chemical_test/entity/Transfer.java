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
@Table(name = "transfer")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Transfer extends BaseEntity {
  Long TransferQuantity;//Số lượng Sản phẩm cụ thể đã được chuyển từ kho này sang kho khác
  Date SentDate;//ngày sản phẩm rời khỏi KHO
  Date ReceivedDate; //ngày sản phẩm đến đích KHO

//  @ManyToOne
//  @JoinColumn(name = "sourceTransfers", referencedColumnName = "warehouseId")
//  private Warehouse sourceWarehouse;
//  @ManyToOne
//  @JoinColumn(name = "destinationTransfers", referencedColumnName = "warehouseId")
//  private Warehouse destinationWarehouse;

  @ManyToOne
  @JoinColumn(name = "product_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @JsonIgnoreProperties(value ="transfer")
  private Product product;

}
