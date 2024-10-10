package com.exercise2.factory;

import com.exercise2.DAO.IProduct;

public abstract class DBFactory {
    public abstract IProduct createProductDB();
}
