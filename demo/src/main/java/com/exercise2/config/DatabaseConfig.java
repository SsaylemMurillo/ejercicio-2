package com.exercise2.config;

import com.exercise2.DAO.IProductDAO;
import com.exercise2.factory.ProductDAOFactory;

public class DatabaseConfig {
    private static String databaseType = "Oracle"; // Valor predeterminado

    public static void configureAdapterDB(String dbType) {
        databaseType = dbType;
    }

    public static IProductDAO getConfiguredDAO() {
        return ProductDAOFactory.getProductDAO(databaseType);
    }
}
