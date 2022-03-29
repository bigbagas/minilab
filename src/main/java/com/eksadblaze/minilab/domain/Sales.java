package com.eksadblaze.minilab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "mst_sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {

    @Id
    @Column(name = "sales_id",
            length = 50,
            nullable = false)
    private String salesId;

    @Column(name = "sales_name",
            length = 255,
            nullable = false)
    private String salesName;

//    // dealer_code
//    @ManyToOne
//    @JoinColumn(name = "dealer_code")
//    private Dealer dealer;

//    // supervisor_id
//    @ManyToOne
//    @JoinColumn(name = "supervisor_id")
//    private Sales sales;

    @Column(name = "sales_gender",
           length = 4,
           nullable = false)
    private String salesGender;

    @Column(name = "sales_email",
            length = 255,
            nullable = false)
    private String salesEmail;

    @Column(name = "sales_status",
            length = 10,
            nullable = false)
    private String salesStatus;



}
