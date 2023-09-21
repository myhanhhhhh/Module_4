package com.example.blog1.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  name;
    @Column(columnDefinition = "text")
    private String content;

    public Blog() {
    }

    public Blog(String name, String description) {
        this.name = name;
        this.content = description;
    }

    public Blog(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.content = description;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
