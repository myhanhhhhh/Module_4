package com.example.cart.dto;

import java.util.Objects;

public class ProductDto {
    private int id;
    private String name;
    private String image;
    private double price;
    private String description;

    public ProductDto() {
    }

    public ProductDto(String name,String image, double price, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
    }

    public ProductDto(int id,String image, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id && Double.compare(that.price, price) == 0 && Objects.equals(name, that.name)
                && Objects.equals(image, that.image) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, price, description);
    }
}
