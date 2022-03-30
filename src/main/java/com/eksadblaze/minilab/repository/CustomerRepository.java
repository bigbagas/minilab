package com.eksadblaze.minilab.repository;

import com.eksadblaze.minilab.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Modifying
    @Query(value = "insert into mst_customer (customer_id, customer_address, customer_email,customer_gender, customer_hp_number, customer_kk, customer_name, customer_nik,dealer_code, customer_telp_number, sales_id, customer_status) values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12)",nativeQuery = true)
    int insertCustomer(String id, String address, String email, String gender, String hp, String kk, String nama, String nik, String dealerCode, String telp, String salesId, String customerStatus);

    @Query(value = "select * from mst_customer where customer_id =?1",nativeQuery = true)
    List<Customer> listCustomer(String id);

    @Modifying
    @Query(value = "update mst_customer set customer_address = ?1, customer_email = ?2, customer_gender = ?3, customer_hp_number =?4,customer_kk = ?5, customer_name=?6, customer_nik=?7, dealer_code=?8, customer_telp_number=?9,sales_id=?10, customer_status =?11 where customer_id =?12",nativeQuery = true)
    int updateCustomer (String address, String email, String gender, String hp, String kk, String name, String nik, String dealerCode, String telp , String salesId, String status, String customerId);

    @Query(value = "select * from mst_customer where dealer_code =?1 and lower(customer_name) like lower(concat('%',?2,'%')) limit ?3 offset ?4",nativeQuery = true)
    List<Customer> listCustomer2 (String dealerCode, String customerName, int limit, int offset);
}
