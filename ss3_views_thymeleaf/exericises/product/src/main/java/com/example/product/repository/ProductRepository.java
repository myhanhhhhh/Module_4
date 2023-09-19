package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone 13", 100000, "phone", "apple"));
        productList.add(new Product(2, "iphone 14", 200000, "phone", "apple"));
        productList.add(new Product(3, "samsung", 300000, "phone", "samsung"));
        productList.add(new Product(4, "oppo", 400000, "phone", "samsung"));
    }

    @Override
    public List<Product> display() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public int searchIndex(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int id, Product product) {
        productList.set(searchIndex(id), product);
    }

    @Override
    public void delete(int id) {
        productList.remove(searchIndex(id));
    }

    @Override
    public Product findByName(String name) {
        for (Product product : productList) {
            if (name.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }
}
