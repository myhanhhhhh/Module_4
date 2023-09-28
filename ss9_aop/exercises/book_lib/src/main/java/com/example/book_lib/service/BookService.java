package com.example.book_lib.service;

import com.example.book_lib.model.Book;
import com.example.book_lib.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookingRepository bookingRepository;

    @Override
    public List<Book> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Book finById(int id) {
        return bookingRepository.findById(id).get();
    }

    @Override
    public void add(Book book) {
        bookingRepository.save(book);
    }

    @Override
    public void update(Book book, int id) {
        bookingRepository.update(book, id);
    }

    @Override
    public Book rentBook(int id) {
        Book book = bookingRepository.findById(id).orElse(null);
        if (book != null && book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookingRepository.save(book);
            return book;
        }
        return null;
    }

    @Override
    public Book payBook(int id) {
        Book book = bookingRepository.findById(id).orElse(null);
        if (book != null) {
            book.setQuantity(book.getQuantity() + 1);
            bookingRepository.save(book);
            return book;
        }
        return null;
    }
}
