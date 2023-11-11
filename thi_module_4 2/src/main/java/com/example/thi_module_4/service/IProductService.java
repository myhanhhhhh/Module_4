package com.example.thi_module_4.service;

import com.example.thi_module_4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable, String name);
    boolean save(Product product);
    Product findById(int id);
    boolean delete(int id);
}
