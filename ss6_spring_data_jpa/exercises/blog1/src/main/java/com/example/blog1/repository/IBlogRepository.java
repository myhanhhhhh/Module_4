package com.example.blog1.repository;

import com.example.blog1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
