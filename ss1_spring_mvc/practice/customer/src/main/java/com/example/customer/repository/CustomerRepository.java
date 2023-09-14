package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customerList = new ArrayList<>();
    static{
        customerList.add(new Customer(1,"Thien","thien@gmail.com","Da nang"));
        customerList.add(new Customer(2,"Lien","lien@gmail.com","Da nang"));
        customerList.add(new Customer(3,"Hanh","hanh@gmail.com","Da nang"));
        customerList.add(new Customer(4,"Thang","thang@gmail.com","Da nang"));
    }
    @Override
    public List<Customer> showList() {
        return customerList;
    }
}
