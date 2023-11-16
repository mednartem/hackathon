package com.portnov.env_sky.logic.data;

import com.portnov.env_sky.logic.db.model.CategoryEntity;

public class FillCategoryEntity {

    public CategoryEntity fillRequiredFields() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(RandomData.generateNameCategory());
        categoryEntity.setDescription(RandomData.generateDescriptionCategory());
        categoryEntity.setParentCategoryId(0);
        categoryEntity.setPictureId(0);
        categoryEntity.setCategoryTemplateId(1);
        categoryEntity.setManuallyPriceRange(1);
        categoryEntity.setPageSize(6);
        categoryEntity.setPageSizeOptions("3, 6, 9");
        categoryEntity.setAllowCustomersToSelectPageSize(1);
        categoryEntity.setShowOnHomepage(0);
        categoryEntity.setIncludeInTopMenu(1);
        categoryEntity.setSubjectToAcl(0);
        categoryEntity.setLimitedToStores(0);
        categoryEntity.setPublished(1);
        categoryEntity.setDeleted(0);
        categoryEntity.setDisplayOrder(0);
        categoryEntity.setCreatedOnUtc(Time.getDateNow());
        categoryEntity.setUpdatedOnUtc(Time.getDateNow());
        categoryEntity.setPriceRangeFiltering(1);
        categoryEntity.setPriceFrom(0);
        categoryEntity.setPriceTo(10000);

        return categoryEntity;
    }
}
