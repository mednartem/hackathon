package com.portnov.env_sky.logic.db.model;

import com.portnov.env_sky.logic.helpers.RandomData;
import com.portnov.env_sky.logic.helpers.Time;

public class FillProductModel {

    public ProductModel fillRequiredFields() {
        ProductModel productModel = new ProductModel();
        productModel.setName(RandomData.generateNameProduct());
        productModel.setShortDescription(RandomData.generateDescriptionProduct());
        productModel.setProductTypeId(5);
        productModel.setParentGroupedProductId(0);
        productModel.setVisibleIndividually(1);
        productModel.setProductTemplateId(1);
        productModel.setVendorId(0);
        productModel.setShowOnHomepage(0);
        productModel.setAllowCustomerReviews(1);
        productModel.setApprovedRatingSum(0);
        productModel.setNotApprovedRatingSum(0);
        productModel.setApprovedTotalReviews(0);
        productModel.setNotApprovedTotalReviews(0);
        productModel.setSubjectToAcl(0);
        productModel.setLimitedToStores(0);
        productModel.setIsGiftCard(0);
        productModel.setGiftCardTypeId(0);
        productModel.setRequireOtherProducts(0);
        productModel.setAutomaticallyAddRequiredProducts(0);
        productModel.setIsDownload(0);
        productModel.setDownloadId(0);
        productModel.setUnlimitedDownloads(0);
        productModel.setMaxNumberOfDownloads(0);
        productModel.setDownloadActivationTypeId(0);
        productModel.setHasSampleDownload(0);
        productModel.setSampleDownloadId(0);
        productModel.setHasUserAgreement(0);
        productModel.setIsRecurring(0);
        productModel.setRecurringCycleLength(100);
        productModel.setRecurringCyclePeriodId(0);
        productModel.setRecurringTotalCycles(10);
        productModel.setIsRental(0);
        productModel.setRentalPriceLength(1);
        productModel.setRentalPricePeriodId(0);
        productModel.setIsShipEnabled(1);
        productModel.setIsFreeShipping(0);
        productModel.setShipSeparately(0);
        productModel.setAdditionalShippingCharge(0);
        productModel.setDeliveryDateId(0);
        productModel.setIsTaxExempt(0);
        productModel.setTaxCategoryId(0);
        productModel.setIsTelecommunicationsOrBroadcastingOrElectronicServices(0);
        productModel.setManageInventoryMethodId(0);
        productModel.setProductAvailabilityRangeId(0);
        productModel.setUseMultipleWarehouses(0);
        productModel.setWarehouseId(0);
        productModel.setStockQuantity(10000);
        productModel.setDisplayStockAvailability(0);
        productModel.setDisplayStockQuantity(0);
        productModel.setMinStockQuantity(0);
        productModel.setLowStockActivityId(0);
        productModel.setNotifyAdminForQuantityBelow(1);
        productModel.setBackorderModeId(0);
        productModel.setAllowBackInStockSubscriptions(0);
        productModel.setOrderMinimumQuantity(1);
        productModel.setOrderMaximumQuantity(10000);
        productModel.setAllowAddingOnlyExistingAttributeCombinations(0);
        productModel.setNotReturnable(0);
        productModel.setDisableBuyButton(0);
        productModel.setDisableWishlistButton(0);
        productModel.setAvailableForPreOrder(0);
        productModel.setCallForPrice(0);
        productModel.setPrice(0);
        productModel.setOldPrice(0);
        productModel.setProductCost(0);
        productModel.setCustomerEntersPrice(0);
        productModel.setMinimumCustomerEnteredPrice(0);
        productModel.setMaximumCustomerEnteredPrice(1000);
        productModel.setBasePriceEnabled(0);
        productModel.setBasePriceAmount(0);
        productModel.setBasePriceUnitId(1);
        productModel.setBasePriceBaseAmount(0);
        productModel.setBasePriceBaseUnitId(1);
        productModel.setMarkAsNew(0);
        productModel.setHasTierPrices(0);
        productModel.setHasDiscountsApplied(0);
        productModel.setWeight(0);
        productModel.setLength(0);
        productModel.setWidth(0);
        productModel.setHeight(0);
        productModel.setDisplayOrder(0);
        productModel.setPublished(1);
        productModel.setDeleted(0);
        productModel.setCreatedOnUtc(Time.getDateNow());
        productModel.setUpdatedOnUtc(Time.getDateNow());

        return productModel;
    }
}