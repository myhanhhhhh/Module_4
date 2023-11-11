package com.example.thi_module_4.dto;

import javax.persistence.*;
import java.util.Set;
public class TypeProductDto {
    private int id;
    private String name;

    private Set<ProductDto> productSet;

    public TypeProductDto() {
    }

    public TypeProductDto(int id, String name, Set<ProductDto> productSet) {
        this.id = id;
        this.name = name;
        this.productSet = productSet;
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

    public Set<ProductDto> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<ProductDto> productSet) {
        this.productSet = productSet;
    }
}
