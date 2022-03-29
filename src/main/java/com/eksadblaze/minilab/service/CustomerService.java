package com.eksadblaze.minilab.service;

import com.eksadblaze.minilab.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public int insertCustomer (String id, String address, String email, String gender, String hp, String kk, String nama, String nik, String status, String telp){
        return customerRepository.insertCustomer(id, address, email, gender, hp, kk, nama, nik, status, telp);
    }
}
