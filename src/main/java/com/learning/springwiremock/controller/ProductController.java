package com.learning.springwiremock.controller;

import com.learning.springwiremock.model.Product;
import com.learning.springwiremock.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @PostConstruct
    public void init(){
        Product book = new Product();
        book.setProductId(1L);
        book.setProductName("Shri Sai Leelamrutham");
        productRepository.save(book);
    }

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    @PostMapping
    public Product saveProduct(@RequestBody @Validated Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }
}
