package com.example.thi_module_4.controller;

import com.example.thi_module_4.dto.ProductDto;
import com.example.thi_module_4.model.Product;
import com.example.thi_module_4.model.TypeProduct;
import com.example.thi_module_4.service.IProductService;
import com.example.thi_module_4.service.ITypeProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ITypeProductService typeProductService;
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "",required = false) String name,
                           Model model){
        Pageable pageable = PageRequest.of(page,2);
        Page<Product> productList = productService.findAll(pageable,name);
        model.addAttribute("productList",productList);
        return "/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        ProductDto productDto = new ProductDto();
        List<TypeProduct> typeProductList = typeProductService.findAll();
        model.addAttribute("productDto",productDto);
        model.addAttribute("typeProductList",typeProductList);
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ProductDto productDto,
                         RedirectAttributes redirectAttributes){
        Product product = new Product();
        BeanUtils.c
    }
}
