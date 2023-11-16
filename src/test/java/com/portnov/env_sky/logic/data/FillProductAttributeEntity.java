package com.portnov.env_sky.logic.data;

import com.portnov.env_sky.logic.db.model.ProductAttributesEntity;

public class FillProductAttributeEntity {

    public ProductAttributesEntity fillRequiredFields() {
        ProductAttributesEntity productAttributesEntity = new ProductAttributesEntity();
        productAttributesEntity.setName(RandomData.generateNameProductAttribute());
        productAttributesEntity.setDescription(RandomData.generateDescriptionProductAttribute());

        return productAttributesEntity;
    }
}
