package com.example.thi_module_4.dto;

import javax.persistence.*;


public class ProductDto {

    private int id;
    private String name;
    private TypeProductDto typeProduct;

    public ProductDto() {
    }


    public ProductDto(int id, String name, TypeProductDto typeProduct) {
        this.id = id;
        this.name = name;
        this.typeProduct = typeProduct;
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

    public TypeProductDto getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProductDto typeProduct) {
        this.typeProduct = typeProduct;
    }
}
