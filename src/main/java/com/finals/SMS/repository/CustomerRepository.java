package com.finals.SMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.finals.SMS.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    //ポイント①
    @Query("SELECT s FROM Customer s ORDER BY s.id")
    List<Customer> findAllOrderById();
}
