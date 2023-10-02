package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {

    void save(Blog blog);

    Blog findById(int id);

    void deleteById(int id);

    Page<Blog> searchByName(Pageable pageable, String searchName,int id);

    void edit(Blog blog, int id);

    Page<Blog> searchByName(Pageable pageable, String searchName);

    List<Blog> findAll();

    List<Blog> findByCategory(int id);

    Page<Blog> findAllAjax(Pageable pageable);
}