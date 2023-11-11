package com.example.thi_module_4.service;

import com.example.thi_module_4.model.Product;
import com.example.thi_module_4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable, String name) {
        return productRepository.findAllByNameContaining(pageable,name);
    }


    @Override
    public boolean save(Product product) {
        try {
            productRepository.save(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public boolean delete(int id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
