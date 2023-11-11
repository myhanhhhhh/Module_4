package com.example.demo.service;

import com.example.demo.model.News;
import com.example.demo.repository.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewsService implements INewsService {
    @Autowired
    private INewsRepository newsRepository;

    @Override
    public Page<News> findAll(Pageable pageable, String searchName) {
        return newsRepository.findAllByTitleContaining(pageable, searchName);
    }

    @Override
    public void add(News news) {
        newsRepository.save(news);
    }

    @Override
    public News findbyId(int id) {
        return newsRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        newsRepository.deleteById(id);
    }
}
