package com.example.book_lib.repository;

import com.example.book_lib.model.Book;
import com.example.book_lib.model.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IRentDetailRepository extends JpaRepository<RentDetail, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into rent_detail(book_id, code, customer_name, status) values (:bookId,:code,:customerName, 0)", nativeQuery = true)
    void save(@Param("bookId") int bookId, @Param("code") int code, @Param("customerName") String customerName);

    @Query(value = "select * from rent_detail where code = :code", nativeQuery = true)
    RentDetail findByCode(@Param("code") int code);

}
