package com.portnov.env_sky.logic.rest.model;

import java.util.Date;

public class CategoryModel {
    private String name;
    private String description;
    private int parentCategoryId;
    private int pictureId;
    private int categoryTemplateId;
    private boolean manuallyPriceRange;
    private int pageSize;
    private boolean allowCustomersToSelectPageSize;
    private boolean showOnHomepage;
    private boolean includeInTopMenu;
    private int subjectToAcl;
    private int limitedToStores;
    private boolean published;
    private int deleted;
    private int displayOrder;
    private Date CreatedOnUtc;
    private Date updatedOnUtc;
    private boolean priceRangeFiltering;
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

    public boolean isManuallyPriceRange() {
        return manuallyPriceRange;
    }

    public void setManuallyPriceRange(boolean manuallyPriceRange) {
        this.manuallyPriceRange = manuallyPriceRange;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isAllowCustomersToSelectPageSize() {
        return allowCustomersToSelectPageSize;
    }

    public void setAllowCustomersToSelectPageSize(boolean allowCustomersToSelectPageSize) {
        this.allowCustomersToSelectPageSize = allowCustomersToSelectPageSize;
    }

    public boolean isShowOnHomepage() {
        return showOnHomepage;
    }

    public void setShowOnHomepage(boolean showOnHomepage) {
        this.showOnHomepage = showOnHomepage;
    }

    public boolean isIncludeInTopMenu() {
        return includeInTopMenu;
    }

    public void setIncludeInTopMenu(boolean includeInTopMenu) {
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

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
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

    public Date getCreatedOnUtc() {
        return CreatedOnUtc;
    }

    public void setCreatedOnUtc(Date createdOnUtc) {
        CreatedOnUtc = createdOnUtc;
    }

    public Date getUpdatedOnUtc() {
        return updatedOnUtc;
    }

    public void setUpdatedOnUtc(Date updatedOnUtc) {
        this.updatedOnUtc = updatedOnUtc;
    }

    public boolean isPriceRangeFiltering() {
        return priceRangeFiltering;
    }

    public void setPriceRangeFiltering(boolean priceRangeFiltering) {
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
