package com.example.book_lib.model;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private Set<RentDetail> rentDetailSet;

    public String generateRandomCode() {
        return String.valueOf((int)(Math.random() * 100000));
    }

    public Book() {
    }

    public Book(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
