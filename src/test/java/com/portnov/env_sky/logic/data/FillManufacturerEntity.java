package com.portnov.env_sky.logic.data;

import com.portnov.env_sky.logic.db.model.ManufacturerEntity;

public class FillManufacturerEntity {

    public ManufacturerEntity fillRequiredFields() {
        ManufacturerEntity manufacturerEntity = new ManufacturerEntity();
        manufacturerEntity.setName(RandomData.generateNameManufacturer());
        manufacturerEntity.setDescription(RandomData.generateDescriptionManufacturer());
        manufacturerEntity.setPageSizeOptions("3, 6, 9");
        manufacturerEntity.setManufacturerTemplateId(1);
        manufacturerEntity.setPictureId(0);
        manufacturerEntity.setPageSize(6);
        manufacturerEntity.setAllowCustomersToSelectPageSize(1);
        manufacturerEntity.setSubjectToAcl(0);
        manufacturerEntity.setLimitedToStores(0);
        manufacturerEntity.setPublished(1);
        manufacturerEntity.setDeleted(0);
        manufacturerEntity.setDisplayOrder(0);
        manufacturerEntity.setCreatedOnUtc(Time.getDateNow());
        manufacturerEntity.setUpdatedOnUtc(Time.getDateNow());
        manufacturerEntity.setPriceRangeFiltering(1);
        manufacturerEntity.setPriceFrom(0);
        manufacturerEntity.setPriceTo(10000);
        manufacturerEntity.setManuallyPriceRange(1);

        return manufacturerEntity;
    }
}
