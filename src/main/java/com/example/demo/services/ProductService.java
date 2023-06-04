package com.example.demo.services;

import com.example.demo.database.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService  {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void saveProduct(Product product){
        productRepository.save(product);

    }
    public ResponseEntity<String> deleteProduct(long id) {
        String message = "Product with ID " + id + " does not exist";
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productRepository.findAll();
        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Product> updateProduct(long id, Product updateProduct){
        Optional<Product> existingProduct = productRepository.findById(id);
        if(existingProduct.isPresent()){
            Product product = existingProduct.get();
            product.setName(updateProduct.getName());
            product.setPrice(updateProduct.getPrice());
            Product updated = productRepository.save(product);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
        }
    }


