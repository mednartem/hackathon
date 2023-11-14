package com.portnov.env_sky.logic.db.model;

public class CategoryModel {
    private String name;
    private String description;
    private int parentCategoryId;
    private int pictureId;
    private int categoryTemplateId;
    private int manuallyPriceRange;
    private int pageSize;
    private String pageSizeOptions;
    private int allowCustomersToSelectPageSize;
    private int showOnHomepage;
    private int includeInTopMenu;
    private int subjectToAcl;
    private int limitedToStores;
    private int published;
    private int deleted;
    private int displayOrder;
    private String createdOnUtc;
    private String updatedOnUtc;
    private int priceRangeFiltering;
    private int priceFrom;
    private int priceTo;

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

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getCategoryTemplateId() {
        return categoryTemplateId;
    }

    public void setCategoryTemplateId(int categoryTemplateId) {
        this.categoryTemplateId = categoryTemplateId;
    }

    public int getManuallyPriceRange() {
        return manuallyPriceRange;
    }

    public void setManuallyPriceRange(int manuallyPriceRange) {
        this.manuallyPriceRange = manuallyPriceRange;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageSizeOptions() {
        return pageSizeOptions;
    }

    public void setPageSizeOptions(String pageSizeOptions) {
        this.pageSizeOptions = pageSizeOptions;
    }

    public int getAllowCustomersToSelectPageSize() {
        return allowCustomersToSelectPageSize;
    }

    public void setAllowCustomersToSelectPageSize(int allowCustomersToSelectPageSize) {
        this.allowCustomersToSelectPageSize = allowCustomersToSelectPageSize;
    }

    public int getShowOnHomepage() {
        return showOnHomepage;
    }

    public void setShowOnHomepage(int showOnHomepage) {
        this.showOnHomepage = showOnHomepage;
    }

    public int getIncludeInTopMenu() {
        return includeInTopMenu;
    }

    public void setIncludeInTopMenu(int includeInTopMenu) {
        this.includeInTopMenu = includeInTopMenu;
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

    public int getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(int priceFrom) {
        this.priceFrom = priceFrom;
    }

    public int getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(int priceTo) {
        this.priceTo = priceTo;
    }
}
