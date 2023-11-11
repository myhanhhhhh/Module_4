package com.example.demo.service;

import com.example.demo.model.Type;
import com.example.demo.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepository typeRepository;
    @Override
    public List<Type> getAll() {
        return typeRepository.findAll();
    }
}
