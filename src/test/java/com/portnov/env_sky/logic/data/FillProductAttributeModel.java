package com.portnov.env_sky.logic.data;

import com.portnov.env_sky.logic.db.model.ProductAttributesModel;

public class FillProductAttributeModel {

    public ProductAttributesModel fillRequiredFields() {
        ProductAttributesModel productAttributesModel = new ProductAttributesModel();
        productAttributesModel.setName(RandomData.generateNameProductAttribute());
        productAttributesModel.setDescription(RandomData.generateDescriptionProductAttribute());

        return productAttributesModel;
    }
}
