package com.exercise2.config;

import com.exercise2.DAO.IProduct;
import com.exercise2.factory.ConcreteFactoryMySQL;
import com.exercise2.factory.ConcreteFactoryOracle;
import com.exercise2.factory.DBFactory;

public class DatabaseConfig {
    private static String dataBaseType = "";

    public static void configureAdapterDB(String dbType) {
        dataBaseType = dbType;
    }

    public static IProduct getProductDAO() {
        DBFactory factory = null;

        switch (dataBaseType.toLowerCase()) {
            case "mysql":
                factory = new ConcreteFactoryMySQL();
                break;
            case "oracle":
                factory = new ConcreteFactoryOracle();
                break;
            default:
                throw new IllegalStateException();
        }
        return factory.createProductDB();
    }
}
