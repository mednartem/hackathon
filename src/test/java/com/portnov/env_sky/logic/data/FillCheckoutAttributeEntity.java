package com.portnov.env_sky.logic.data;

import com.portnov.env_sky.logic.db.model.CheckoutAttributesEntity;

public class FillCheckoutAttributeEntity {

    public CheckoutAttributesEntity fillRequiredFields() {
        CheckoutAttributesEntity checkoutAttributesEntity = new CheckoutAttributesEntity();
        checkoutAttributesEntity.setName(RandomData.generateNameCheckoutAttribute());
        checkoutAttributesEntity.setTextPrompt(RandomData.generateDescriptionCheckoutAttribute());
        checkoutAttributesEntity.setIsRequired(0);
        checkoutAttributesEntity.setShippableProductRequired(0);
        checkoutAttributesEntity.setIsTaxExempt(0);
        checkoutAttributesEntity.setTaxCategoryId(0);
        checkoutAttributesEntity.setAttributeControlTypeId(1);
        checkoutAttributesEntity.setDisplayOrder(0);
        checkoutAttributesEntity.setLimitedToStores(0);

        return checkoutAttributesEntity;
    }
}
