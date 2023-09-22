package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    void save(Blog blog);

    Blog findById(int id);

    void deleteById(int id);

    Page<Blog> searchByName(Pageable pageable, String searchName, int id);

    void edit(Blog blog);
}
