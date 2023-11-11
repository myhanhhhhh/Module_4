package com.example.demo.service;

import com.example.demo.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INewsService {
    Page<News> findAll(Pageable pageable, String searchName);

    void add(News news);

    News findbyId(int id);

    void delete(int id);
}
