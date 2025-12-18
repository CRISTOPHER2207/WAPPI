package com.wappi.backend.controller;

import com.wappi.backend.entity.Product;
import com.wappi.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") // Esta será la URL de tu tienda
@CrossOrigin(origins = "*") // IMPORTANTE: Permite que Angular se conecte sin bloqueos
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // 1. Obtener todos los productos (GET)
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. Guardar un producto nuevo (POST) - Para probar luego
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}