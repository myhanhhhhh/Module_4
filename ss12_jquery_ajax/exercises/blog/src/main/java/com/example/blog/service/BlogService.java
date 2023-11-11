package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public void save(Blog blog) {
        blogRepository.save(blog.getDescription(), blog.getName(), blog.getCategory().getId());
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchByName(Pageable pageable, String searchName, int id) {
        return blogRepository.findBlogByNameContaining(pageable, "%" + searchName + "%", id);
    }

    @Override
    public void edit(Blog blog, int id) {

        blogRepository.edit(blog.getDescription(), blog.getName(), blog.getId(), id);
    }

    @Override
    public Page<Blog> searchByName(Pageable pageable, String searchName) {
        return blogRepository.findBlogByNameContaining(pageable, "%" + searchName + "%");
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findByCategory(int id) {
        return blogRepository.findByCategory(id);
    }

    @Override
    public Page<Blog> findAllAjax(Pageable pageable) {
        return blogRepository.findAllAjax(pageable);
    }
}