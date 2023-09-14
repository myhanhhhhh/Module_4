package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> showList() {
        return customerRepository.showList();
    }
}
