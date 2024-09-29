package com.exercise2.factory;

import com.exercise2.DAO.MySQLProductDAO;
import com.exercise2.DAO.OracleProductDAO;
import com.exercise2.DAO.IProductDAO;

public class ProductDAOFactory {

    public static IProductDAO getProductDAO(String dataBaseType) {
        if (dataBaseType.equalsIgnoreCase("MySQL")) {
            return new MySQLProductDAO();
        } else if (dataBaseType.equalsIgnoreCase("Oracle")) {
            return new OracleProductDAO();
        }
        throw new IllegalArgumentException("DataBaseType not supported.");
    }
}

