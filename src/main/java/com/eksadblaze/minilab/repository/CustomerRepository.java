package com.eksadblaze.minilab.repository;

import com.eksadblaze.minilab.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Modifying
    @Query(value = "insert into mst_customer (customer_id, customer_address, customer_email, customer_gender, customer_hp_number, customer_kk, customer_name, customer_nik, customer_status, customer_telp_number) values(?1,?2,?3,?4,?5,?6,?7,?8)")
    int insertCustomer(String id, String address, String email, String gender, String hp, String kk, String nama, String nik, String status, String telp);
}
