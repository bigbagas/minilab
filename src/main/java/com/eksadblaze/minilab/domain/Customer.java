package com.eksadblaze.minilab.domain;


import javax.persistence.*;

@Entity
@Table(name = "mst_customer")
public class Customer {

    @Id
    @Column(name = "customer_id", length = 50, nullable = false)
    private String customerId;

    @Column(name = "customer_name", length = 255, nullable = false)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "dealer_code")
    private Dealer dealer;

    @Column(name = "customer_gender", length = 4, nullable = false)
    private String customerGender;

    @Column(name = "customer_nik", length = 50, nullable = false)
    private String customerNik;

    @Column(name = "customer_kk", length = 50, nullable = false)
    private String customerKk;

    @Column(name = "customer_email", length = 255)
    private String customerEmail;

    @Column(name = "customer_address", length = 512, nullable = false)
    private String customerAddress;

    @Column(name = "customer_telp_number", length = 50)
    private String customerTelpNumber;

    @Column(name = "customer_hp_number", length = 50)
    private String customerHpNumber;

    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;

    @Column(name = "customer_status", length = 10)
    private String customerStatus;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerNik() {
        return customerNik;
    }

    public void setCustomerNik(String customerNik) {
        this.customerNik = customerNik;
    }

    public String getCustomerKk() {
        return customerKk;
    }

    public void setCustomerKk(String customerKk) {
        this.customerKk = customerKk;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerTelpNumber() {
        return customerTelpNumber;
    }

    public void setCustomerTelpNumber(String customerTelpNumber) {
        this.customerTelpNumber = customerTelpNumber;
    }

    public String getCustomerHpNumber() {
        return customerHpNumber;
    }

    public void setCustomerHpNumber(String customerHpNumber) {
        this.customerHpNumber = customerHpNumber;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
}
