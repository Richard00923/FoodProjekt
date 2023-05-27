package com.example.demo.repository;
import com.example.demo.database.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Product createProduct(Product product) {
        entityManager.persist(product);
        return product;
    }

    public Product getProduct(Long id) {
        return entityManager.find(Product.class, id);
    }

    public Product updateProduct(Product product) {
        return entityManager.merge(product);
    }

    public void deleteProduct(Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}