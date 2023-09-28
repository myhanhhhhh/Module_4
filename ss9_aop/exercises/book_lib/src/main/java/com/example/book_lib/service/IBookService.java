package com.example.book_lib.service;

import com.example.book_lib.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book finById(int id);

    void add(Book book);

    void update(Book book, int id);

    Book rentBook(int id);

    Book payBook(int id);
}
