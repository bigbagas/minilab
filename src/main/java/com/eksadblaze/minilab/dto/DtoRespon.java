package com.eksadblaze.minilab.dto;

import com.eksadblaze.minilab.domain.Customer;

import java.util.List;
import java.util.Map;

public class DtoRespon {

    private String status;
    private String code;
    private String message;
    Object data;

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
}
