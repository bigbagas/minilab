package com.eksadblaze.minilab.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_dealer")
public class Dealer {

    @Id
    @Column(name = "dealer_code", length = 50, nullable = false)
    private String dealerId;

    @Column(name = "dealer_name", length = 255, nullable = false)
    private String dealerName;

    @Column(name = "dealer_class", length = 10, nullable = false)
    private String dealerClass;

    @Column(name = "telp_number", length = 255, nullable = false)
    private String telpNumber;

    @Column(name = "alamat", length = 512, nullable = false)
    private String alamat;

    @Column(name = "dealer_status", length = 10, nullable = false)
    private String dealerStatus;

    @Column(name = "dealer_ext_code", length = 50, nullable = true)
    private String dealerExtCode;

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerClass() {
        return dealerClass;
    }

    public void setDealerClass(String dealerClass) {
        this.dealerClass = dealerClass;
    }

    public String getTelpNumber() {
        return telpNumber;
    }

    public void setTelpNumber(String telpNumber) {
        this.telpNumber = telpNumber;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDealerStatus() {
        return dealerStatus;
    }

    public void setDealerStatus(String dealerStatus) {
        this.dealerStatus = dealerStatus;
    }

    public String getDealerExtCode() {
        return dealerExtCode;
    }

    public void setDealerExtCode(String dealerExtCode) {
        this.dealerExtCode = dealerExtCode;
    }
}
