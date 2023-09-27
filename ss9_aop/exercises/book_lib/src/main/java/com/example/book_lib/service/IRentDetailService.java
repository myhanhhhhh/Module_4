package com.example.book_lib.service;

import com.example.book_lib.model.RentDetail;

import java.util.List;

public interface IRentDetailService {
    List<RentDetail> findAll();
    boolean add(int bookId, int code, String customerName);
    RentDetail finById(int id);
    void delete(int id);
    RentDetail findByCode(int id);

}
