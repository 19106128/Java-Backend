package com.example.THIRUKUMARANBACKEND.controller;

import com.example.THIRUKUMARANBACKEND.model.Product;
import com.example.THIRUKUMARANBACKEND.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("name") String name) {
                List<Product> products = productService.searchProducts(name);
        return ResponseEntity.ok(products);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
                Product createdProduct = productService.saveProduct(product);
        return ResponseEntity.ok(createdProduct);
    }
}
