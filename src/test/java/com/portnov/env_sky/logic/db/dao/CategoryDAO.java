package com.portnov.env_sky.logic.db.dao;

import com.portnov.env_sky.logic.db.model.CategoryEntity;

public interface CategoryDAO {

    void create(CategoryEntity categoryEntity);

    void deleteAll(String patternName);
}
