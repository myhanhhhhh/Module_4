package com.example.demo.controller;

import com.example.demo.model.Type;
import com.example.demo.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/types")
public class RestTypeController {

    @Autowired
    private ITypeService typeService;

    @GetMapping("")
    public ResponseEntity<List<Type>> getAll() {
        List<Type> types = typeService.getAll();
        if (types.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(types, HttpStatus.OK);
        }
    }

}
