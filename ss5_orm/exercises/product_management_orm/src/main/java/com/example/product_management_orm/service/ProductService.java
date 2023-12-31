package com.example.product_management_orm.service;

import com.example.product_management_orm.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductService productRepository;

    @Override
    public List<Product> display() {
        return productRepository.display();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
