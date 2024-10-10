package com.exercise2.factory;

import com.exercise2.DAO.IProduct;
import com.exercise2.DAO.OracleProductDB;

public class ConcreteFactoryOracle extends DBFactory {

    @Override
    public IProduct createProductDB() {
        return new OracleProductDB();
    }
}
