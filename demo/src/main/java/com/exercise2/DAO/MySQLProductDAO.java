package com.exercise2.DAO;

import java.util.ArrayList;
import java.util.List;

import com.exercise2.model.Product;
import com.exercise2.utils.JsonUtil;

public class MySQLProductDAO implements IProductDAO {
    private List<Product> products = new ArrayList<>();

    public MySQLProductDAO() {
        this.products = JsonUtil.readProductsFromFile();
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
 
    @Override
    public Product getById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        products.add(product);
        JsonUtil.writeProductsToFile(products);
    }

    @Override
    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
        JsonUtil.writeProductsToFile(products);
    }
}

