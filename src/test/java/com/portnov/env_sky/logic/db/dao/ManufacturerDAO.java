package com.portnov.env_sky.logic.db.dao;

import com.portnov.env_sky.logic.db.model.ManufacturerEntity;

public interface ManufacturerDAO {

    void create(ManufacturerEntity categoryModel);

    void deleteAll(String patternName);
}
