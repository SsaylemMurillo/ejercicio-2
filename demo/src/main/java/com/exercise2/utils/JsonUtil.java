package com.exercise2.utils;
import com.exercise2.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {

    private static final String FILE_PATH = "src/main/resources/products.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Product> readProductsFromFile() {
        try {
            return objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeProductsToFile(List<Product> products) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

