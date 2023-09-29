package com.example.book_lib.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class RentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "code", unique = true, nullable = false)
    private int code;
    @NotEmpty(message = "Not empty")
    private String customerName;
    @Column(columnDefinition = "default 0")
    private int status = 0;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public RentDetail() {
    }

    public RentDetail(int code, Book book) {
        this.code = code;
        this.book = book;
    }

    public RentDetail(int code, String customerName, Book book, int status) {
        this.code = code;
        this.customerName = customerName;
        this.book = book;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RentDetail(int id, int code, String customerName, Book book, int status) {
        this.id = id;
        this.code = code;
        this.customerName = customerName;
        this.book = book;
        this.status = status;
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
