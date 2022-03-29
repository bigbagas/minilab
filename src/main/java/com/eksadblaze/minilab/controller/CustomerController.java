package com.eksadblaze.minilab.controller;

import com.eksadblaze.minilab.dto.DtoRespon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("ddms/v1")
public class CustomerController {

    @PostMapping("cmd/master/customer/save")
    public ResponseEntity<DtoRespon> save(
            @RequestBody  final Map<String , Object> request
    ){
        Map<String , Object> ret = new HashMap<>();

        String customerId = request.get("customerId").toString();
        String customerName = request.get("customerName").toString();
        String dealerId = request.get("dealerId").toString();
        String customerGender = request.get("customerGender").toString();
        String customerNik = request.get("customerNik").toString();
        String customerEmail = request.get("customerEmail").toString();
        String customerAddress = request.get("customerAddress").toString();

        ret.put("customerId", customerId);
        ret.put("customerName", customerName);
        ret.put("dealerId", dealerId);
        ret.put("customerGender", customerGender);
        ret.put("customerNik", customerNik);
        ret.put("customerEmail", customerEmail);
        ret.put("customerAddress", customerAddress);

        DtoRespon dtoRespon = new DtoRespon();

        dtoRespon.setStatus("S");
        dtoRespon.setCode("201");
        dtoRespon.setMessage("Process Successed");
        dtoRespon.setData(ret);

        return new ResponseEntity<>(dtoRespon, HttpStatus.OK);

    }
}
