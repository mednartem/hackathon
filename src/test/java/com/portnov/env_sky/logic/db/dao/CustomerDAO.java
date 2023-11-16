package com.portnov.env_sky.logic.db.dao;

import com.portnov.env_sky.logic.db.model.CustomerEntity;

public interface CustomerDAO {

    void create(CustomerEntity customerEntity);

    void deleteAll(String patternName);
}
