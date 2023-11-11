package com.example.thi_module_4.service;

import com.example.thi_module_4.model.TypeProduct;
import com.example.thi_module_4.repository.ITypeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService{
    @Autowired
    private ITypeProductRepository typeProductRepository;


    @Override
    public List<TypeProduct> findAll() {
        return typeProductRepository.findAll();
    }
}
