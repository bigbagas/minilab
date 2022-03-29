package com.eksadblaze.minilab.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="mst_ppn")
public class Ppn {
    @Id
    @Column(name="ppn_id", length=50, nullable = false)
    private String ppn_id;

    @Column(name="description", length=255, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name="dealer_code")
    private Dealer dealer_code;

    @Column(name="effective_start_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "GMT+7")
    private Date effective_start_date;

    @Column(name="effective_end_date", length=50)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "GMT+7")
    private Date effective_end_date;

    @Column(name="ppn_rate", nullable = false)
    private float ppn_rate;

    @Column(name="ppn_rate_previous")
    private float ppn_rate_previous;

    @Column(name="ppn_status", length=10, nullable = false)
    private String ppn_status;

    public String getPpn_id() {
        return ppn_id;
    }

    public void setPpn_id(String ppn_id) {
        this.ppn_id = ppn_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dealer getDealer_code() {
        return dealer_code;
    }

    public void setDealer_code(Dealer dealer_code) {
        this.dealer_code = dealer_code;
    }

    public Date getEffective_start_date() {
        return effective_start_date;
    }

    public void setEffective_start_date(Date effective_start_date) {
        this.effective_start_date = effective_start_date;
    }

    public Date getEffective_end_date() {
        return effective_end_date;
    }

    public void setEffective_end_date(Date effective_end_date) {
        this.effective_end_date = effective_end_date;
    }

    public float getPpn_rate() {
        return ppn_rate;
    }

    public void setPpn_rate(float ppn_rate) {
        this.ppn_rate = ppn_rate;
    }

    public float getPpn_rate_previous() {
        return ppn_rate_previous;
    }

    public void setPpn_rate_previous(float ppn_rate_previous) {
        this.ppn_rate_previous = ppn_rate_previous;
    }

    public String getPpn_status() {
        return ppn_status;
    }

    public void setPpn_status(String ppn_status) {
        this.ppn_status = ppn_status;
    }
}
