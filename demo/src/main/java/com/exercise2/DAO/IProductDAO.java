package com.exercise2.DAO;

import java.util.List;

import com.exercise2.model.Product;

public interface IProductDAO {
    List<Product> getAll();
    Product getById(int id);
    void saveProduct(Product product);
    void deleteProduct(int id);
}

