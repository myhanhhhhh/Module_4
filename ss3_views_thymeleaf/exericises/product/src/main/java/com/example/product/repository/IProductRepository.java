package com.example.product.repository;

import com.example.product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> display();

    void add(Product product);

    Product findById(int id);

    void update(int id, Product product);
    void delete(int id);
    Product findByName(String name);

}
