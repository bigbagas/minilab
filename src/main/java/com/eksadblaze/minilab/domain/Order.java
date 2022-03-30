package com.eksadblaze.minilab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "trx_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id",
            columnDefinition = "VARCHAR(255) NOT NULL")
    private String orderId;

//    unitCode
    @ManyToOne
    @JoinColumn(name = "unit_code",
            columnDefinition = "VARCHAR(100) NOT NULL")
    Unit unit;

//    dealerCode;
    @ManyToOne
    @JoinColumn(name = "dealer_code",
            columnDefinition = "VARCHAR(50) NOT NULL")
    private Dealer dealer;

//    salesId
    @ManyToOne
    @JoinColumn(name = "sales_id",
            columnDefinition = "VARCHAR(50) NOT NULL")
    private Sales sales;

//    customerId
    @ManyToOne
    @JoinColumn(name = "customer_id",
            columnDefinition = "VARCHAR(50) NOT NULL")
    private Customer customer;

    @Column(name = "minimum_payment",
            nullable = false)
    private float minimumPayment;

    @Column(name = "total_value",
            nullable = false)
    private float totalValue;

    @Column(name = "order_value",
            nullable = false)
    private float orderValue;

    @Column(name = "offtheroad_value",
            nullable = false)
    private float offtheroadValue;

    @Column(name = "order_total_discount",
            nullable = false)
    private float orderTotalDiscount;

    @Column(name = "ppn",
            nullable = false)
    private float ppn;

    @Column(name = "plat_nomor",
            columnDefinition = "VARCHAR(50)",
            nullable = true)
    private String platNomor;

    @Column(name = "nomor_mesin",
            columnDefinition = "VARCHAR(50)",
            nullable = true)
    private String nomorMesin;

    @Column(name = "nomor_rangka",
            columnDefinition = "VARCHAR(50)",
            nullable = true)
    private String nomorRangka;

    @Column(name = "is_leasing",
            columnDefinition = "VARCHAR(10)")
    private String isLeasing;

    @Column(name = "payment_status",
            columnDefinition = "VARCHAR(50) NOT NULL")
    private String paymentStatus;

    @Column(name = "unit_status",
            columnDefinition = "VARCHAR(50) NOT NULL")
    private String unitStatus;
}
