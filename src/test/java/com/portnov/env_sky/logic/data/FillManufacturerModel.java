package com.portnov.env_sky.logic.data;

import com.portnov.env_sky.logic.db.model.ManufacturerModel;

public class FillManufacturerModel {

    public ManufacturerModel fillRequiredFields() {
        ManufacturerModel manufacturerModel = new ManufacturerModel();
        manufacturerModel.setName(RandomData.generateNameManufacturer());
        manufacturerModel.setDescription(RandomData.generateDescriptionManufacturer());
        manufacturerModel.setPageSizeOptions("3, 6, 9");
        manufacturerModel.setManufacturerTemplateId(1);
        manufacturerModel.setPictureId(0);
        manufacturerModel.setPageSize(6);
        manufacturerModel.setAllowCustomersToSelectPageSize(1);
        manufacturerModel.setSubjectToAcl(0);
        manufacturerModel.setLimitedToStores(0);
        manufacturerModel.setPublished(1);
        manufacturerModel.setDeleted(0);
        manufacturerModel.setDisplayOrder(0);
        manufacturerModel.setCreatedOnUtc(Time.getDateNow());
        manufacturerModel.setUpdatedOnUtc(Time.getDateNow());
        manufacturerModel.setPriceRangeFiltering(1);
        manufacturerModel.setPriceFrom(0);
        manufacturerModel.setPriceTo(10000);
        manufacturerModel.setManuallyPriceRange(1);

        return manufacturerModel;
    }
}
