package com.example.THIRUKUMARANBACKEND.service;

import com.example.THIRUKUMARANBACKEND.model.Product;
import com.example.THIRUKUMARANBACKEND.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
             return productRepository.findAll();
    }

    public List<Product> searchProducts(String name) {
        return productRepository.findByNameContaining(name);
    }

    public Product saveProduct(Product product) {
                   return productRepository.save(product);
    }
}
