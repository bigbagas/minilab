package com.eksadblaze.minilab.service;

import com.eksadblaze.minilab.domain.Customer;
import com.eksadblaze.minilab.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public int insertCustomer (String id, String address, String email, String gender, String hp, String kk, String nama, String nik, String dealerCode, String telp, String salesId, String customerStatus){
        return customerRepository.insertCustomer(id, address, email, gender, hp, kk, nama, nik,dealerCode , telp, salesId, customerStatus);
    }

    public List<Customer> listCustomer (String id){
        return customerRepository.listCustomer(id);
    }

    public int updateCustomer(String address, String email, String gender, String hp, String kk, String name, String nik, String dealerCode, String telp , String salesId, String status, String customerId){
        return customerRepository.updateCustomer(address, email, gender, hp, kk, name, nik, dealerCode, telp, salesId, status, customerId);
    }

    public Optional<Customer> optionalCustomer(String id){
        return customerRepository.findById(id);
    }

    public List<Customer> customerList (String dealerCode, String customerName, int limit, int offset){
        return customerRepository.listCustomer2(dealerCode,customerName,limit,offset);
    }


}
