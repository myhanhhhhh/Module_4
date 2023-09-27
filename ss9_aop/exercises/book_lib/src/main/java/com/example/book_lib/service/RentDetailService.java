package com.example.book_lib.service;

import com.example.book_lib.model.RentDetail;
import com.example.book_lib.repository.IRentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentDetailService implements IRentDetailService {
    @Autowired
    private IRentDetailRepository rentDetailRepository;

    @Override
    public List<RentDetail> findAll() {
        return rentDetailRepository.findAll();
    }

    @Override
    public boolean add(int bookId, int code, String customerName) {
        rentDetailRepository.save(bookId, code, customerName);
        return true;
    }

    @Override
    public RentDetail finById(int id) {
        return rentDetailRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        rentDetailRepository.deleteById(id);
    }

    @Override
    public RentDetail findByCode(int id) {
        return rentDetailRepository.findByCode(id);
    }
}
