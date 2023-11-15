package com.portnov.env_sky.logic.db.dao;

import com.portnov.env_sky.logic.db.model.ProductAttributesModel;

public interface ProductAttributesDAO {

    void create(ProductAttributesModel productAttributesModel);

    void deleteAll(String patternName);
}
