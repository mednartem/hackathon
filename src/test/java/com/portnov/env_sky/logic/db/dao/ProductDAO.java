package com.portnov.env_sky.logic.db.dao;

import com.portnov.env_sky.logic.db.model.ProductEntity;

public interface ProductDAO {

    void create(ProductEntity categoryModel);

    void deleteAll(String patternName);
}
