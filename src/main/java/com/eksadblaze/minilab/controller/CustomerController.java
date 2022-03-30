package com.eksadblaze.minilab.controller;

import com.eksadblaze.minilab.domain.Customer;
import com.eksadblaze.minilab.domain.Dealer;
import com.eksadblaze.minilab.domain.Sales;
import com.eksadblaze.minilab.dto.CustomerDtoGet;
import com.eksadblaze.minilab.dto.CustomerRequestDto;
import com.eksadblaze.minilab.dto.DtoCustomerListAll;
import com.eksadblaze.minilab.dto.DtoRespon;
import com.eksadblaze.minilab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("ddms/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("cmd/master/customer/save")
    public ResponseEntity<Object> save(
            @RequestBody  final Map<String , Object> request
    ) {
        Map<String, Object> ret = new HashMap<>();

        String customerId = request.get("customerId").toString();
        String customerName = request.get("customerName").toString();
        String dealerCode = request.get("dealerId").toString();
        String customerGender = request.get("customerGender").toString();
        String customerNik = request.get("customerNik").toString();
        String customerEmail = request.get("customerEmail").toString();
        String customerAddress = request.get("customerAddress").toString();
        String noHp = request.get("customerHp").toString();
        String noTelp = request.get("customerTelp").toString();
        String customerKk = request.get("customerKk").toString();
        String salesId = request.get("salesId").toString();
        String customerStatus = request.get("customerStatus").toString();

        DtoRespon dtoRespon = new DtoRespon();

        if (!customerGender.equals("GTLK")||!customerGender.equals("GTPR")||!customerStatus.equals("ACTIVE")||!customerStatus.equals("INACTIVE")){
            dtoRespon.setStatus("E");
            dtoRespon.setCode("404");
            dtoRespon.setMessage("Request tidak valid");
            dtoRespon.setData(null);
            return new ResponseEntity<>(dtoRespon, HttpStatus.BAD_REQUEST);
        }else {
            List<Customer> listCustomer = customerService.listCustomer(customerId);

            if (listCustomer.isEmpty()) {
                CustomerRequestDto customerRequestDto = new CustomerRequestDto();
                customerRequestDto.setCustomerId(customerId);
                customerRequestDto.setCustomerName(customerName);
                customerRequestDto.setDealerId(dealerCode);
                customerRequestDto.setCustomerGender(customerGender);
                customerRequestDto.setCustomerNik(customerNik);
                customerRequestDto.setCustomerKk(customerKk);
                customerRequestDto.setCustomerEmail(customerEmail);
                customerRequestDto.setCustomerAddress(customerAddress);
                customerRequestDto.setCustomerTelp(noTelp);
                customerRequestDto.setCustomerHp(noHp);
                customerRequestDto.setSalesId(salesId);
                customerRequestDto.setCustomerStatus(customerStatus);

                int insertCustomer = customerService.insertCustomer(
                        customerId, customerAddress, customerEmail, customerGender,
                        noHp, customerKk, customerName, customerNik, dealerCode, noTelp,
                        salesId, customerStatus
                );



                dtoRespon.setStatus("S");
                dtoRespon.setCode("201");
                dtoRespon.setMessage("Process Successed");
                dtoRespon.setData(customerRequestDto);

                return new ResponseEntity<>(dtoRespon, HttpStatus.OK);

            }else {
                CustomerRequestDto customerRequestDto = new CustomerRequestDto();
                customerRequestDto.setCustomerId(customerId);
                customerRequestDto.setCustomerName(customerName);
                customerRequestDto.setDealerId(dealerCode);
                customerRequestDto.setCustomerGender(customerGender);
                customerRequestDto.setCustomerNik(customerNik);
                customerRequestDto.setCustomerKk(customerKk);
                customerRequestDto.setCustomerEmail(customerEmail);
                customerRequestDto.setCustomerAddress(customerAddress);
                customerRequestDto.setCustomerTelp(noTelp);
                customerRequestDto.setCustomerHp(noHp);
                customerRequestDto.setSalesId(salesId);
                customerRequestDto.setCustomerStatus(customerStatus);

                int updateCustomer = customerService.updateCustomer(customerAddress, customerEmail, customerGender, noHp,customerKk,customerName,customerNik,dealerCode,noTelp,salesId,customerStatus,customerId);



                dtoRespon.setStatus("S");
                dtoRespon.setCode("201");
                dtoRespon.setMessage("Process Successed");
                dtoRespon.setData(customerRequestDto);

                return new ResponseEntity<>(dtoRespon, HttpStatus.OK);
            }
        }
    }

    @GetMapping("qry/master/customer/get/{customerId}")
    public ResponseEntity<Object> getById(
            @PathVariable(value = "customerId")String customerId
    ){
        Optional<Customer> customer = customerService.optionalCustomer(customerId);

        String custId = customer.get().getCustomerId();
        String custName = customer.get().getCustomerName();
        String dealerId = customer.get().getDealer().getDealerId();
        String custGender = customer.get().getCustomerGender();
        String custNik = customer.get().getCustomerNik();
        String custKk = customer.get().getCustomerKk();
        String custEmail = customer.get().getCustomerEmail();
        String custAddress = customer.get().getCustomerAddress();

        CustomerDtoGet dtoGet = new CustomerDtoGet();

        dtoGet.setCustomerId(custId);
        dtoGet.setCustomerName(custName);
        dtoGet.setDealerId(dealerId);
        dtoGet.setCustomerGender(custGender);
        dtoGet.setCustomerNik(custNik);
        dtoGet.setCustomerKk(custKk);
        dtoGet.setCustomerEmail(custEmail);
        dtoGet.setCustomerAddress(custAddress);

        DtoRespon respon = new DtoRespon();

        respon.setStatus("S");
        respon.setCode("201");
        respon.setMessage("Process Successed");
        respon.setData(dtoGet);

        return new ResponseEntity<>(respon, HttpStatus.OK);
    }

    @PostMapping("qry/master/customer/listAll")
    public ResponseEntity<Object> listAll(
            @RequestBody final Map<String, Object> request
    ){

        String customerName = request.get("customerName").toString();
        String dealerId = request.get("dealerId").toString();
        int offset = Integer.parseInt(request.get("offset").toString());
        int limit = Integer.parseInt(request.get("limit").toString());

        List<Customer> customers = customerService.customerList(dealerId,customerName,limit,offset);
        Map<String, Object> ret = new HashMap<>();
        List list = new ArrayList<>();

        CustomerDtoGet dtoGet;

        for (int i = 0; i < customers.size(); i++) {

            dtoGet = new CustomerDtoGet();

            String custId = customers.get(i).getCustomerId();
            String custName = customers.get(i).getCustomerName();
            String idDealer = customers.get(i).getDealer().getDealerId();
            String custGender = customers.get(i).getCustomerGender();
            String custNik = customers.get(i).getCustomerNik();
            String custkk = customers.get(i).getCustomerKk();
            String custEmail = customers.get(i).getCustomerEmail();
            String custAddress = customers.get(i).getCustomerAddress();

            dtoGet.setCustomerId(custId);
            dtoGet.setCustomerName(custName);
            dtoGet.setDealerId(idDealer);
            dtoGet.setCustomerGender(custGender);
            dtoGet.setCustomerNik(custNik);
            dtoGet.setCustomerKk(custkk);
            dtoGet.setCustomerEmail(custEmail);
            dtoGet.setCustomerAddress(custAddress);

            list.add(dtoGet);

            ret.put("listCustomer", list);

        }

        DtoCustomerListAll listAll = new DtoCustomerListAll();
        listAll.setStatus("S");
        listAll.setCode("201");
        listAll.setMessage("Process Successed");
        listAll.setData(ret);
        listAll.setDataOfRecord(customers.size());


        return new ResponseEntity<>(listAll, HttpStatus.OK);


    }


}
