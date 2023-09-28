package com.example.book_lib.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class RentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Not Empty")
    @Column(name = "code", unique = true)
    private int code;
    @NotEmpty(message = "Not Empty")
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public RentDetail() {
    }

    public RentDetail(int code, Book book) {
        this.code = code;
        this.book = book;
    }

    public RentDetail(int code, String customerName, Book book) {
        this.code = code;
        this.customerName = customerName;
        this.book = book;
    }

    public RentDetail(int id, int code, String customerName, Book book) {
        this.id = id;
        this.code = code;
        this.customerName = customerName;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        code = code;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
