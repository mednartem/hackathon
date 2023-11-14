package com.portnov.env_sky.logic.db.dao;

import com.portnov.env_sky.logic.db.model.CategoryModel;

public interface CategoryDAO {

    void create(CategoryModel categoryModel);

    void deleteAll(String patternName);
}
