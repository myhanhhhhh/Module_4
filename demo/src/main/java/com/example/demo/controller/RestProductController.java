package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class RestProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(
            @RequestParam(name = "name_like", defaultValue = "") String name,
            @RequestParam(name = "type.name_like", defaultValue = "") String type
    ) {
        List<Product> products = productService.getAll(name, type);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            Collections.sort(products, new  Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<String> createCustomer(@RequestBody Product product) {
        productService.add(product);
        return ResponseEntity.ok("Thêm thành công!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
        productService.update(id, product);
        return ResponseEntity.ok("Sửa thành công!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        productService.delete(id);
        return ResponseEntity.ok("Xóa thành công!");
    }

}
