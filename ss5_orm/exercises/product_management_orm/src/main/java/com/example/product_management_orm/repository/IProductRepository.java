package com.example.product_management_orm.repository;

import com.example.product_management_orm.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> display();

    void add(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void delete(int id);

    Product findByName(String name);


}
