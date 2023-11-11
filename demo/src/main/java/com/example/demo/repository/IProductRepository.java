package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select product.* from product join type on product.type_id = type.id where product.name like :name AND type.name like :type", nativeQuery = true)
    List<Product> findAllProduct(String name, String type);
}
