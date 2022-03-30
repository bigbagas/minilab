package com.eksadblaze.minilab.dto;

public class DtoCustomerListAll {
    private String status;
    private String code;
    private String message;
    Object data;
    private int dataOfRecord;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getDataOfRecord() {
        return dataOfRecord;
    }

    public void setDataOfRecord(int dataOfRecord) {
        this.dataOfRecord = dataOfRecord;
    }
}
