package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String time;
    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "idCategory")
    private Category category;

    public Blog() {
    }

    public Blog(String name, String content,String time) {
        this.name = name;
        this.content = content;
        this.time = time;
    }

    public Blog(int id, String name, String content,String time) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.time = time;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
