package com.example.demo.controller;

import com.example.demo.database.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ProductRepository productRepository;

    public ApiController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/productSave")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    @DeleteMapping("/productDelete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
