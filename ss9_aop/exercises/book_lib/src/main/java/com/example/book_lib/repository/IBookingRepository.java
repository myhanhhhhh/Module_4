package com.example.book_lib.repository;

import com.example.book_lib.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IBookingRepository extends JpaRepository<Book, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update book set quantity = :#{#book.quantity} where id like :id", nativeQuery = true)
    void update(Book book, @Param("id") int id);
}
