package com.eksadblaze.minilab.controller;

import com.eksadblaze.minilab.domain.Customer;
import com.eksadblaze.minilab.dto.DtoRespon;
import com.eksadblaze.minilab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ddms/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("cmd/master/customer/save")
    public ResponseEntity<Object> save(
            @RequestBody  final Map<String , Object> request
    ){
        Map<String , Object> ret = new HashMap<>();

        String customerId = request.get("customerId").toString();
        String customerName = request.get("customerName").toString();
        String dealerCode = request.get("dealerId").toString();
        String customerGender = request.get("customerGender").toString();
        String customerNik = request.get("customerNik").toString();
        String customerEmail = request.get("customerEmail").toString();
        String customerAddress = request.get("customerAddress").toString();
        String noHp = request.get("customerHpNumber").toString();
        String noTelp = request.get("customerTelpNumber").toString();
        String customerKk = request.get("customerKk").toString();

        ret.put("customerId", customerId);
        ret.put("customerName", customerName);
        ret.put("dealerId", dealerCode);
        ret.put("customerGender", customerGender);
        ret.put("customerNik", customerNik);
        ret.put("customerKk", customerKk);
        ret.put("customerEmail", customerEmail);
        ret.put("customerAddress", customerAddress);


        int insertCustomer = customerService.insertCustomer(
                customerId,customerAddress,customerEmail,customerGender,
                noHp,customerKk,customerName,customerNik,dealerCode,noTelp
        );

        DtoRespon dtoRespon = new DtoRespon();

        dtoRespon.setStatus("S");
        dtoRespon.setCode("201");
        dtoRespon.setMessage("Process Successed");
        dtoRespon.setData(ret);

        return new ResponseEntity<>(dtoRespon, HttpStatus.OK);

    }

}
