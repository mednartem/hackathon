package com.portnov.env_sky.logic.data;

import com.portnov.env_sky.logic.db.model.ProductEntity;

public class FillProductModelEntity {

    public ProductEntity fillRequiredFields() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(RandomData.generateNameProduct());
        productEntity.setShortDescription(RandomData.generateDescriptionProduct());
        productEntity.setProductTypeId(5);
        productEntity.setParentGroupedProductId(0);
        productEntity.setVisibleIndividually(1);
        productEntity.setProductTemplateId(1);
        productEntity.setVendorId(0);
        productEntity.setShowOnHomepage(0);
        productEntity.setAllowCustomerReviews(1);
        productEntity.setApprovedRatingSum(0);
        productEntity.setNotApprovedRatingSum(0);
        productEntity.setApprovedTotalReviews(0);
        productEntity.setNotApprovedTotalReviews(0);
        productEntity.setSubjectToAcl(0);
        productEntity.setLimitedToStores(0);
        productEntity.setIsGiftCard(0);
        productEntity.setGiftCardTypeId(0);
        productEntity.setRequireOtherProducts(0);
        productEntity.setAutomaticallyAddRequiredProducts(0);
        productEntity.setIsDownload(0);
        productEntity.setDownloadId(0);
        productEntity.setUnlimitedDownloads(0);
        productEntity.setMaxNumberOfDownloads(0);
        productEntity.setDownloadActivationTypeId(0);
        productEntity.setHasSampleDownload(0);
        productEntity.setSampleDownloadId(0);
        productEntity.setHasUserAgreement(0);
        productEntity.setIsRecurring(0);
        productEntity.setRecurringCycleLength(100);
        productEntity.setRecurringCyclePeriodId(0);
        productEntity.setRecurringTotalCycles(10);
        productEntity.setIsRental(0);
        productEntity.setRentalPriceLength(1);
        productEntity.setRentalPricePeriodId(0);
        productEntity.setIsShipEnabled(1);
        productEntity.setIsFreeShipping(0);
        productEntity.setShipSeparately(0);
        productEntity.setAdditionalShippingCharge(0);
        productEntity.setDeliveryDateId(0);
        productEntity.setIsTaxExempt(0);
        productEntity.setTaxCategoryId(0);
        productEntity.setIsTelecommunicationsOrBroadcastingOrElectronicServices(0);
        productEntity.setManageInventoryMethodId(0);
        productEntity.setProductAvailabilityRangeId(0);
        productEntity.setUseMultipleWarehouses(0);
        productEntity.setWarehouseId(0);
        productEntity.setStockQuantity(10000);
        productEntity.setDisplayStockAvailability(0);
        productEntity.setDisplayStockQuantity(0);
        productEntity.setMinStockQuantity(0);
        productEntity.setLowStockActivityId(0);
        productEntity.setNotifyAdminForQuantityBelow(1);
        productEntity.setBackorderModeId(0);
        productEntity.setAllowBackInStockSubscriptions(0);
        productEntity.setOrderMinimumQuantity(1);
        productEntity.setOrderMaximumQuantity(10000);
        productEntity.setAllowAddingOnlyExistingAttributeCombinations(0);
        productEntity.setNotReturnable(0);
        productEntity.setDisableBuyButton(0);
        productEntity.setDisableWishlistButton(0);
        productEntity.setAvailableForPreOrder(0);
        productEntity.setCallForPrice(0);
        productEntity.setPrice(0);
        productEntity.setOldPrice(0);
        productEntity.setProductCost(0);
        productEntity.setCustomerEntersPrice(0);
        productEntity.setMinimumCustomerEnteredPrice(0);
        productEntity.setMaximumCustomerEnteredPrice(1000);
        productEntity.setBasePriceEnabled(0);
        productEntity.setBasePriceAmount(0);
        productEntity.setBasePriceUnitId(1);
        productEntity.setBasePriceBaseAmount(0);
        productEntity.setBasePriceBaseUnitId(1);
        productEntity.setMarkAsNew(0);
        productEntity.setHasTierPrices(0);
        productEntity.setHasDiscountsApplied(0);
        productEntity.setWeight(0);
        productEntity.setLength(0);
        productEntity.setWidth(0);
        productEntity.setHeight(0);
        productEntity.setDisplayOrder(0);
        productEntity.setPublished(1);
        productEntity.setDeleted(0);
        productEntity.setCreatedOnUtc(Time.getDateNow());
        productEntity.setUpdatedOnUtc(Time.getDateNow());

        return productEntity;
    }
}