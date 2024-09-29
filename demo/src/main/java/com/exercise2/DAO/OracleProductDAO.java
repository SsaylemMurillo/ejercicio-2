package com.exercise2.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.exercise2.model.Product;
import com.exercise2.utils.JsonUtil;

public class OracleProductDAO implements IProductDAO {
    private Map<Integer, Product> products = new HashMap<>();

    public OracleProductDAO() {
        List<Product> productsList = JsonUtil.readProductsFromFile();
        products = new HashMap<>();
        if (productsList != null) {
            for (Product product : productsList) {
                products.put(product.getId(), product);
            }
        }
    }

    @Override
    public List<Product> getAll() {
        return products.values().stream().collect(Collectors.toList());
    }

    @Override
    public Product getById(int id) {
        return products.get(id);
    }

    @Override
    public void saveProduct(Product product) {
        products.put(product.getId(), product);
        JsonUtil.writeProductsToFile(getAll());
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
        JsonUtil.writeProductsToFile(getAll());
    }
}
