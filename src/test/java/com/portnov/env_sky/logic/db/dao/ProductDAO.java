package com.portnov.env_sky.logic.db.dao;

import com.portnov.env_sky.logic.db.model.ProductModel;

public interface ProductDAO {

    void create(ProductModel categoryModel);

    void deleteAll(String patternName);
}
