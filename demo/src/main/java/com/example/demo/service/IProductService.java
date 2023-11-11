package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll(String name, String type);

    Product findById(int id);

    void add(Product product);

    void update(int id, Product product);

    void delete(int id);
}
