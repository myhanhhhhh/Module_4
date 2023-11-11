package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.ICategotyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategotyRepository categotyRepository;
    @Override
    public List<Category> getAll() {
        return categotyRepository.findAll();
    }
}
