package com.exercise2.controller;

import org.springframework.web.bind.annotation.*;

import com.exercise2.DAO.IProduct;
import com.exercise2.config.DatabaseConfig;
import com.exercise2.model.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private IProduct productDAO;

    public ProductController() {
        DatabaseConfig.configureAdapterDB("Oracle");
        this.productDAO = DatabaseConfig.getProductDAO();
    }

    @GetMapping
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productDAO.getById(id);
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        productDAO.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productDAO.deleteProduct(id);
    }
}
