package com.portnov.env_sky.logic.db.model;

public class ProductEntity {
    private int id;
    private String name;
    private String shortDescription;
    private int parentGroupedProductId;
    private int productTypeId;
    private int visibleIndividually;
    private int productTemplateId;
    private int vendorId;
    private int showOnHomepage;
    private int allowCustomerReviews;
    private int approvedRatingSum;
    private int notApprovedRatingSum;
    private int approvedTotalReviews;
    private int notApprovedTotalReviews;
    private int subjectToAcl;
    private int limitedToStores;
    private int isGiftCard;
    private int giftCardTypeId;
    private int requireOtherProducts;
    private int automaticallyAddRequiredProducts;
    private int isDownload;
    private int downloadId;
    private int unlimitedDownloads;
    private int maxNumberOfDownloads;
    private int downloadActivationTypeId;
    private int hasSampleDownload;
    private int sampleDownloadId;
    private int hasUserAgreement;
    private int isRecurring;
    private int recurringCycleLength;
    private int recurringCyclePeriodId;
    private int recurringTotalCycles;
    private int isRental;
    private int rentalPriceLength;
    private int rentalPricePeriodId;
    private int isShipEnabled;
    private int isFreeShipping;
    private int shipSeparately;
    private double additionalShippingCharge;
    private int deliveryDateId;
    private int isTaxExempt;
    private int taxCategoryId;
    private int isTelecommunicationsOrBroadcastingOrElectronicServices;
    private int manageInventoryMethodId;
    private int productAvailabilityRangeId;
    private int useMultipleWarehouses;
    private int warehouseId;
    private int stockQuantity;
    private int displayStockAvailability;
    private int displayStockQuantity;
    private int minStockQuantity;
    private int lowStockActivityId;
    private int notifyAdminForQuantityBelow;
    private int backorderModeId;
    private int allowBackInStockSubscriptions;
    private int orderMinimumQuantity;
    private int orderMaximumQuantity;
    private int allowAddingOnlyExistingAttributeCombinations;
    private int notReturnable;
    private int disableBuyButton;
    private int disableWishlistButton;
    private int availableForPreOrder;
    private int callForPrice;
    private double price;
    private double oldPrice;
    private double productCost;
    private int customerEntersPrice;
    private double minimumCustomerEnteredPrice;
    private double maximumCustomerEnteredPrice;
    private int basePriceEnabled;
    private double basePriceAmount;
    private int basePriceUnitId;
    private double basePriceBaseAmount;
    private int basePriceBaseUnitId;
    private int markAsNew;
    private int hasTierPrices;
    private int hasDiscountsApplied;
    private double weight;
    private double length;
    private double width;
    private double height;
    private int displayOrder;
    private int published;
    private int deleted;
    private String createdOnUtc;
    private String updatedOnUtc;

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getParentGroupedProductId() {
        return parentGroupedProductId;
    }

    public void setParentGroupedProductId(int parentGroupedProductId) {
        this.parentGroupedProductId = parentGroupedProductId;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getVisibleIndividually() {
        return visibleIndividually;
    }

    public void setVisibleIndividually(int visibleIndividually) {
        this.visibleIndividually = visibleIndividually;
    }

    public int getProductTemplateId() {
        return productTemplateId;
    }

    public void setProductTemplateId(int productTemplateId) {
        this.productTemplateId = productTemplateId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getShowOnHomepage() {
        return showOnHomepage;
    }

    public void setShowOnHomepage(int showOnHomepage) {
        this.showOnHomepage = showOnHomepage;
    }

    public int getAllowCustomerReviews() {
        return allowCustomerReviews;
    }

    public void setAllowCustomerReviews(int allowCustomerReviews) {
        this.allowCustomerReviews = allowCustomerReviews;
    }

    public int getApprovedRatingSum() {
        return approvedRatingSum;
    }

    public void setApprovedRatingSum(int approvedRatingSum) {
        this.approvedRatingSum = approvedRatingSum;
    }

    public int getNotApprovedRatingSum() {
        return notApprovedRatingSum;
    }

    public void setNotApprovedRatingSum(int notApprovedRatingSum) {
        this.notApprovedRatingSum = notApprovedRatingSum;
    }

    public int getApprovedTotalReviews() {
        return approvedTotalReviews;
    }

    public void setApprovedTotalReviews(int approvedTotalReviews) {
        this.approvedTotalReviews = approvedTotalReviews;
    }

    public int getNotApprovedTotalReviews() {
        return notApprovedTotalReviews;
    }

    public void setNotApprovedTotalReviews(int notApprovedTotalReviews) {
        this.notApprovedTotalReviews = notApprovedTotalReviews;
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

    public int getIsGiftCard() {
        return isGiftCard;
    }

    public void setIsGiftCard(int isGiftCard) {
        this.isGiftCard = isGiftCard;
    }

    public int getGiftCardTypeId() {
        return giftCardTypeId;
    }

    public void setGiftCardTypeId(int giftCardTypeId) {
        this.giftCardTypeId = giftCardTypeId;
    }

    public int getRequireOtherProducts() {
        return requireOtherProducts;
    }

    public void setRequireOtherProducts(int requireOtherProducts) {
        this.requireOtherProducts = requireOtherProducts;
    }

    public int getAutomaticallyAddRequiredProducts() {
        return automaticallyAddRequiredProducts;
    }

    public void setAutomaticallyAddRequiredProducts(int automaticallyAddRequiredProducts) {
        this.automaticallyAddRequiredProducts = automaticallyAddRequiredProducts;
    }

    public int getIsDownload() {
        return isDownload;
    }

    public void setIsDownload(int isDownload) {
        this.isDownload = isDownload;
    }

    public int getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(int downloadId) {
        this.downloadId = downloadId;
    }

    public int getUnlimitedDownloads() {
        return unlimitedDownloads;
    }

    public void setUnlimitedDownloads(int unlimitedDownloads) {
        this.unlimitedDownloads = unlimitedDownloads;
    }

    public int getMaxNumberOfDownloads() {
        return maxNumberOfDownloads;
    }

    public void setMaxNumberOfDownloads(int maxNumberOfDownloads) {
        this.maxNumberOfDownloads = maxNumberOfDownloads;
    }

    public int getDownloadActivationTypeId() {
        return downloadActivationTypeId;
    }

    public void setDownloadActivationTypeId(int downloadActivationTypeId) {
        this.downloadActivationTypeId = downloadActivationTypeId;
    }

    public int getHasSampleDownload() {
        return hasSampleDownload;
    }

    public void setHasSampleDownload(int hasSampleDownload) {
        this.hasSampleDownload = hasSampleDownload;
    }

    public int getSampleDownloadId() {
        return sampleDownloadId;
    }

    public void setSampleDownloadId(int sampleDownloadId) {
        this.sampleDownloadId = sampleDownloadId;
    }

    public int getHasUserAgreement() {
        return hasUserAgreement;
    }

    public void setHasUserAgreement(int hasUserAgreement) {
        this.hasUserAgreement = hasUserAgreement;
    }

    public int getIsRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(int isRecurring) {
        this.isRecurring = isRecurring;
    }

    public int getRecurringCycleLength() {
        return recurringCycleLength;
    }

    public void setRecurringCycleLength(int recurringCycleLength) {
        this.recurringCycleLength = recurringCycleLength;
    }

    public int getRecurringCyclePeriodId() {
        return recurringCyclePeriodId;
    }

    public void setRecurringCyclePeriodId(int recurringCyclePeriodId) {
        this.recurringCyclePeriodId = recurringCyclePeriodId;
    }

    public int getRecurringTotalCycles() {
        return recurringTotalCycles;
    }

    public void setRecurringTotalCycles(int recurringTotalCycles) {
        this.recurringTotalCycles = recurringTotalCycles;
    }

    public int getIsRental() {
        return isRental;
    }

    public void setIsRental(int isRental) {
        this.isRental = isRental;
    }

    public int getRentalPriceLength() {
        return rentalPriceLength;
    }

    public void setRentalPriceLength(int rentalPriceLength) {
        this.rentalPriceLength = rentalPriceLength;
    }

    public int getRentalPricePeriodId() {
        return rentalPricePeriodId;
    }

    public void setRentalPricePeriodId(int rentalPricePeriodId) {
        this.rentalPricePeriodId = rentalPricePeriodId;
    }

    public int getIsShipEnabled() {
        return isShipEnabled;
    }

    public void setIsShipEnabled(int isShipEnabled) {
        this.isShipEnabled = isShipEnabled;
    }

    public int getIsFreeShipping() {
        return isFreeShipping;
    }

    public void setIsFreeShipping(int isFreeShipping) {
        this.isFreeShipping = isFreeShipping;
    }

    public int getShipSeparately() {
        return shipSeparately;
    }

    public void setShipSeparately(int shipSeparately) {
        this.shipSeparately = shipSeparately;
    }

    public double getAdditionalShippingCharge() {
        return additionalShippingCharge;
    }

    public void setAdditionalShippingCharge(double additionalShippingCharge) {
        this.additionalShippingCharge = additionalShippingCharge;
    }

    public int getDeliveryDateId() {
        return deliveryDateId;
    }

    public void setDeliveryDateId(int deliveryDateId) {
        this.deliveryDateId = deliveryDateId;
    }

    public int getIsTaxExempt() {
        return isTaxExempt;
    }

    public void setIsTaxExempt(int isTaxExempt) {
        this.isTaxExempt = isTaxExempt;
    }

    public int getTaxCategoryId() {
        return taxCategoryId;
    }

    public void setTaxCategoryId(int taxCategoryId) {
        this.taxCategoryId = taxCategoryId;
    }

    public int getIsTelecommunicationsOrBroadcastingOrElectronicServices() {
        return isTelecommunicationsOrBroadcastingOrElectronicServices;
    }

    public void setIsTelecommunicationsOrBroadcastingOrElectronicServices(int isTelecommunicationsOrBroadcastingOrElectronicServices) {
        this.isTelecommunicationsOrBroadcastingOrElectronicServices = isTelecommunicationsOrBroadcastingOrElectronicServices;
    }

    public int getManageInventoryMethodId() {
        return manageInventoryMethodId;
    }

    public void setManageInventoryMethodId(int manageInventoryMethodId) {
        this.manageInventoryMethodId = manageInventoryMethodId;
    }

    public int getProductAvailabilityRangeId() {
        return productAvailabilityRangeId;
    }

    public void setProductAvailabilityRangeId(int productAvailabilityRangeId) {
        this.productAvailabilityRangeId = productAvailabilityRangeId;
    }

    public int getUseMultipleWarehouses() {
        return useMultipleWarehouses;
    }

    public void setUseMultipleWarehouses(int useMultipleWarehouses) {
        this.useMultipleWarehouses = useMultipleWarehouses;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getDisplayStockAvailability() {
        return displayStockAvailability;
    }

    public void setDisplayStockAvailability(int displayStockAvailability) {
        this.displayStockAvailability = displayStockAvailability;
    }

    public int getDisplayStockQuantity() {
        return displayStockQuantity;
    }

    public void setDisplayStockQuantity(int displayStockQuantity) {
        this.displayStockQuantity = displayStockQuantity;
    }

    public int getMinStockQuantity() {
        return minStockQuantity;
    }

    public void setMinStockQuantity(int minStockQuantity) {
        this.minStockQuantity = minStockQuantity;
    }

    public int getLowStockActivityId() {
        return lowStockActivityId;
    }

    public void setLowStockActivityId(int lowStockActivityId) {
        this.lowStockActivityId = lowStockActivityId;
    }

    public int getNotifyAdminForQuantityBelow() {
        return notifyAdminForQuantityBelow;
    }

    public void setNotifyAdminForQuantityBelow(int notifyAdminForQuantityBelow) {
        this.notifyAdminForQuantityBelow = notifyAdminForQuantityBelow;
    }

    public int getBackorderModeId() {
        return backorderModeId;
    }

    public void setBackorderModeId(int backorderModeId) {
        this.backorderModeId = backorderModeId;
    }

    public int getAllowBackInStockSubscriptions() {
        return allowBackInStockSubscriptions;
    }

    public void setAllowBackInStockSubscriptions(int allowBackInStockSubscriptions) {
        this.allowBackInStockSubscriptions = allowBackInStockSubscriptions;
    }

    public int getOrderMinimumQuantity() {
        return orderMinimumQuantity;
    }

    public void setOrderMinimumQuantity(int orderMinimumQuantity) {
        this.orderMinimumQuantity = orderMinimumQuantity;
    }

    public int getOrderMaximumQuantity() {
        return orderMaximumQuantity;
    }

    public void setOrderMaximumQuantity(int orderMaximumQuantity) {
        this.orderMaximumQuantity = orderMaximumQuantity;
    }

    public int getAllowAddingOnlyExistingAttributeCombinations() {
        return allowAddingOnlyExistingAttributeCombinations;
    }

    public void setAllowAddingOnlyExistingAttributeCombinations(int allowAddingOnlyExistingAttributeCombinations) {
        this.allowAddingOnlyExistingAttributeCombinations = allowAddingOnlyExistingAttributeCombinations;
    }

    public int getNotReturnable() {
        return notReturnable;
    }

    public void setNotReturnable(int notReturnable) {
        this.notReturnable = notReturnable;
    }

    public int getDisableBuyButton() {
        return disableBuyButton;
    }

    public void setDisableBuyButton(int disableBuyButton) {
        this.disableBuyButton = disableBuyButton;
    }

    public int getDisableWishlistButton() {
        return disableWishlistButton;
    }

    public void setDisableWishlistButton(int disableWishlistButton) {
        this.disableWishlistButton = disableWishlistButton;
    }

    public int getAvailableForPreOrder() {
        return availableForPreOrder;
    }

    public void setAvailableForPreOrder(int availableForPreOrder) {
        this.availableForPreOrder = availableForPreOrder;
    }

    public int getCallForPrice() {
        return callForPrice;
    }

    public void setCallForPrice(int callForPrice) {
        this.callForPrice = callForPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public int getCustomerEntersPrice() {
        return customerEntersPrice;
    }

    public void setCustomerEntersPrice(int customerEntersPrice) {
        this.customerEntersPrice = customerEntersPrice;
    }

    public double getMinimumCustomerEnteredPrice() {
        return minimumCustomerEnteredPrice;
    }

    public void setMinimumCustomerEnteredPrice(double minimumCustomerEnteredPrice) {
        this.minimumCustomerEnteredPrice = minimumCustomerEnteredPrice;
    }

    public double getMaximumCustomerEnteredPrice() {
        return maximumCustomerEnteredPrice;
    }

    public void setMaximumCustomerEnteredPrice(double maximumCustomerEnteredPrice) {
        this.maximumCustomerEnteredPrice = maximumCustomerEnteredPrice;
    }

    public int getBasePriceEnabled() {
        return basePriceEnabled;
    }

    public void setBasePriceEnabled(int basePriceEnabled) {
        this.basePriceEnabled = basePriceEnabled;
    }

    public double getBasePriceAmount() {
        return basePriceAmount;
    }

    public void setBasePriceAmount(double basePriceAmount) {
        this.basePriceAmount = basePriceAmount;
    }

    public int getBasePriceUnitId() {
        return basePriceUnitId;
    }

    public void setBasePriceUnitId(int basePriceUnitId) {
        this.basePriceUnitId = basePriceUnitId;
    }

    public double getBasePriceBaseAmount() {
        return basePriceBaseAmount;
    }

    public void setBasePriceBaseAmount(double basePriceBaseAmount) {
        this.basePriceBaseAmount = basePriceBaseAmount;
    }

    public int getBasePriceBaseUnitId() {
        return basePriceBaseUnitId;
    }

    public void setBasePriceBaseUnitId(int basePriceBaseUnitId) {
        this.basePriceBaseUnitId = basePriceBaseUnitId;
    }

    public int getMarkAsNew() {
        return markAsNew;
    }

    public void setMarkAsNew(int markAsNew) {
        this.markAsNew = markAsNew;
    }

    public int getHasTierPrices() {
        return hasTierPrices;
    }

    public void setHasTierPrices(int hasTierPrices) {
        this.hasTierPrices = hasTierPrices;
    }

    public int getHasDiscountsApplied() {
        return hasDiscountsApplied;
    }

    public void setHasDiscountsApplied(int hasDiscountsApplied) {
        this.hasDiscountsApplied = hasDiscountsApplied;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
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
}
