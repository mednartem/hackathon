package com.portnov.env_sky.logic.db.model;

import com.portnov.env_sky.logic.helpers.RandomData;
import com.portnov.env_sky.logic.helpers.Time;

public class FillCategoryModel {

    public CategoryModel fillRequiredFields() {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName(RandomData.generateNameCategory());
        categoryModel.setDescription(RandomData.generateDescriptionCategory());
        categoryModel.setParentCategoryId(0);
        categoryModel.setPictureId(0);
        categoryModel.setCategoryTemplateId(1);
        categoryModel.setManuallyPriceRange(1);
        categoryModel.setPageSize(6);
        categoryModel.setPageSizeOptions("3, 6, 9");
        categoryModel.setAllowCustomersToSelectPageSize(1);
        categoryModel.setShowOnHomepage(0);
        categoryModel.setIncludeInTopMenu(1);
        categoryModel.setSubjectToAcl(0);
        categoryModel.setLimitedToStores(0);
        categoryModel.setPublished(1);
        categoryModel.setDeleted(0);
        categoryModel.setDisplayOrder(0);
        categoryModel.setCreatedOnUtc(Time.getDateNow());
        categoryModel.setUpdatedOnUtc(Time.getDateNow());
        categoryModel.setPriceRangeFiltering(1);
        categoryModel.setPriceFrom(0);
        categoryModel.setPriceTo(10000);

        return categoryModel;
    }
}
