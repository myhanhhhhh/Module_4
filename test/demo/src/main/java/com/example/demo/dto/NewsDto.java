package com.example.demo.dto;

import com.example.demo.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private int id;
    @NotBlank(message = "Not empty")
    private String title;
    @NotBlank(message = "Not empty")
    private String content;
    @NotBlank(message = "Not empty")
    private String time;
    @NotBlank(message = "Not empty")
    private String employee;
    public Category category;

}
