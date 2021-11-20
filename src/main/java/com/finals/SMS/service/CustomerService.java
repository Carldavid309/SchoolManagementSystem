package com.finals.SMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finals.SMS.entity.Customer;
import com.finals.SMS.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    //ポイント①
    public List<Customer> findAll() {
        return customerRepository.findAllOrderById();
    }

    public void insert(Customer customer) {
        customerRepository.save(customer);
    }

    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> selectById(Integer id) {
        return customerRepository.findById(id);
    }
}