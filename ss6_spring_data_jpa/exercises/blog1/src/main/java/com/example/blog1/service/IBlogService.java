package com.example.blog1.service;

import com.example.blog1.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void add(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void delete(int id);
}
