package com.example.thi_module_4.repository;

import com.example.thi_module_4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByNameContaining(Pageable pageable, String name);
}
