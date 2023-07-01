package com.example.demo.controller;
import com.example.demo.database.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/productSave")
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }
    @DeleteMapping("/productDelete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
    @GetMapping("/productsGet")
    public List<Product> getAllProducts() throws ChangeSetPersister.NotFoundException {
        return productService.getAllProducts();
    }
    @PutMapping("/productUpdate/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) throws ChangeSetPersister.NotFoundException {
       return productService.updateProduct(id,updatedProduct);
    }
}
