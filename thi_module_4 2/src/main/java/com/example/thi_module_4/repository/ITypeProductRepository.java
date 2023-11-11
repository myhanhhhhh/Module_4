package com.example.thi_module_4.repository;

import com.example.thi_module_4.model.Product;
import com.example.thi_module_4.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeProductRepository extends JpaRepository<TypeProduct, Integer> {
}
