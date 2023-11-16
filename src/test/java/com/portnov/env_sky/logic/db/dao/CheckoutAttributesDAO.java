package com.portnov.env_sky.logic.db.dao;

import com.portnov.env_sky.logic.db.model.CheckoutAttributesEntity;

public interface CheckoutAttributesDAO {

    void create(CheckoutAttributesEntity checkoutAttributesEntity);

    void deleteAll(String patternName);
}
