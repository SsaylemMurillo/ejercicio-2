package com.exercise2.factory;

import com.exercise2.DAO.IProduct;
import com.exercise2.DAO.MySQLProductDB;

public class ConcreteFactoryMySQL extends DBFactory {
    @Override
    public IProduct createProductDB() {
        return new MySQLProductDB();
    }
}
