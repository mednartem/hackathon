package com.portnov.env_sky.logic.db.dao;

import com.portnov.env_sky.logic.db.model.ProductAttributesEntity;

public interface ProductAttributesDAO {

    void create(ProductAttributesEntity productAttributesEntity);

    void deleteAll(String patternName);
}
