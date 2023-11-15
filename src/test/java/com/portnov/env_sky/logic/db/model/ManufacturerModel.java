package com.portnov.env_sky.logic.db.model;

public class ManufacturerModel {
    private int id;
    private String name;
    private String description;
    private String pageSizeOptions;
    private int manufacturerTemplateId;
    private int pictureId;
    private int pageSize;
    private int allowCustomersToSelectPageSize;
    private int subjectToAcl;
    private int limitedToStores;
    private int published;
    private int deleted;
    private int displayOrder;
    private String createdOnUtc;
    private String updatedOnUtc;
    private int priceRangeFiltering;
    private double priceFrom;
    private double priceTo;
    private int manuallyPriceRange;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPageSizeOptions() {
        return pageSizeOptions;
    }

    public void setPageSizeOptions(String pageSizeOptions) {
        this.pageSizeOptions = pageSizeOptions;
    }

    public int getManufacturerTemplateId() {
        return manufacturerTemplateId;
    }

    public void setManufacturerTemplateId(int manufacturerTemplateId) {
        this.manufacturerTemplateId = manufacturerTemplateId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getAllowCustomersToSelectPageSize() {
        return allowCustomersToSelectPageSize;
    }

    public void setAllowCustomersToSelectPageSize(int allowCustomersToSelectPageSize) {
        this.allowCustomersToSelectPageSize = allowCustomersToSelectPageSize;
    }

    public int getSubjectToAcl() {
        return subjectToAcl;
    }

    public void setSubjectToAcl(int subjectToAcl) {
        this.subjectToAcl = subjectToAcl;
    }

    public int getLimitedToStores() {
        return limitedToStores;
    }

    public void setLimitedToStores(int limitedToStores) {
        this.limitedToStores = limitedToStores;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getCreatedOnUtc() {
        return createdOnUtc;
    }

    public void setCreatedOnUtc(String createdOnUtc) {
        this.createdOnUtc = createdOnUtc;
    }

    public String getUpdatedOnUtc() {
        return updatedOnUtc;
    }

    public void setUpdatedOnUtc(String updatedOnUtc) {
        this.updatedOnUtc = updatedOnUtc;
    }

    public int getPriceRangeFiltering() {
        return priceRangeFiltering;
    }

    public void setPriceRangeFiltering(int priceRangeFiltering) {
        this.priceRangeFiltering = priceRangeFiltering;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public int getManuallyPriceRange() {
        return manuallyPriceRange;
    }

    public void setManuallyPriceRange(int manuallyPriceRange) {
        this.manuallyPriceRange = manuallyPriceRange;
    }
}
