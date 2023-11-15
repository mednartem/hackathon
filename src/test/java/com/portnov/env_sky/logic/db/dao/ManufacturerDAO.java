package com.portnov.env_sky.logic.db.dao;

import com.portnov.env_sky.logic.db.model.ManufacturerModel;

public interface ManufacturerDAO {

    void create(ManufacturerModel categoryModel);

    void deleteAll(String patternName);
}
