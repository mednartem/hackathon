package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.ProductDAO;
import com.portnov.env_sky.logic.db.model.FillProductModel;
import com.portnov.env_sky.logic.db.model.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAOJdbc implements ProductDAO {

    private static SQLServerDataSource ds = ServiceDB.INSTANCE.getDataSource();

    @Override
    public void create(ProductModel productModel) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO Product (" +
                     "Name," +
                     "ShortDescription," +
                     "ParentGroupedProductId," +
                     "ProductTypeId," +
                     "VisibleIndividually," +
                     "ProductTemplateId," +
                     "VendorId," +
                     "ShowOnHomepage," +
                     "AllowCustomerReviews," +
                     "ApprovedRatingSum," +
                     "NotApprovedRatingSum," +
                     "ApprovedTotalReviews," +
                     "NotApprovedTotalReviews," +
                     "SubjectToAcl," +
                     "LimitedToStores," +
                     "IsGiftCard," +
                     "GiftCardTypeId," +
                     "RequireOtherProducts," +
                     "AutomaticallyAddRequiredProducts," +
                     "IsDownload," +
                     "DownloadId," +
                     "UnlimitedDownloads," +
                     "MaxNumberOfDownloads," +
                     "DownloadActivationTypeId," +
                     "HasSampleDownload," +
                     "SampleDownloadId," +
                     "HasUserAgreement," +
                     "IsRecurring," +
                     "RecurringCycleLength," +
                     "RecurringCyclePeriodId," +
                     "RecurringTotalCycles," +
                     "IsRental," +
                     "RentalPriceLength," +
                     "RentalPricePeriodId," +
                     "IsShipEnabled," +
                     "IsFreeShipping," +
                     "ShipSeparately," +
                     "AdditionalShippingCharge," +
                     "DeliveryDateId," +
                     "IsTaxExempt," +
                     "TaxCategoryId," +
                     "IsTelecommunicationsOrBroadcastingOrElectronicServices," +
                     "ManageInventoryMethodId," +
                     "ProductAvailabilityRangeId," +
                     "UseMultipleWarehouses," +
                     "WarehouseId," +
                     "StockQuantity," +
                     "DisplayStockAvailability," +
                     "DisplayStockQuantity," +
                     "MinStockQuantity," +
                     "LowStockActivityId," +
                     "NotifyAdminForQuantityBelow," +
                     "BackorderModeId," +
                     "AllowBackInStockSubscriptions," +
                     "OrderMinimumQuantity," +
                     "OrderMaximumQuantity," +
                     "AllowAddingOnlyExistingAttributeCombinations," +
                     "NotReturnable," +
                     "DisableBuyButton," +
                     "DisableWishlistButton," +
                     "AvailableForPreOrder," +
                     "CallForPrice," +
                     "Price," +
                     "OldPrice," +
                     "ProductCost," +
                     "CustomerEntersPrice," +
                     "MinimumCustomerEnteredPrice," +
                     "MaximumCustomerEnteredPrice," +
                     "BasePriceEnabled," +
                     "BasePriceAmount," +
                     "BasePriceUnitId," +
                     "BasePriceBaseAmount," +
                     "BasePriceBaseUnitId," +
                     "MarkAsNew," +
                     "HasTierPrices," +
                     "HasDiscountsApplied," +
                     "Weight," +
                     "Length," +
                     "Width," +
                     "Height," +
                     "DisplayOrder," +
                     "Published," +
                     "Deleted," +
                     "CreatedOnUtc," +
                     "UpdatedOnUtc" +
                    ")" +
                     "VALUES (" +
                         "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                         "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                         "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                         "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                         "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                         "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                         "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                         "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                         "?, ?, ?, ?, ?" +
                     ")")
        ) {
            ps.setString(1, productModel.getName());
            ps.setString(2, productModel.getShortDescription());
            ps.setInt(3, productModel.getParentGroupedProductId());
            ps.setInt(4, productModel.getProductTypeId());
            ps.setInt(5, productModel.getVisibleIndividually());
            ps.setInt(6, productModel.getProductTemplateId());
            ps.setInt(7, productModel.getVendorId());
            ps.setInt(8, productModel.getShowOnHomepage());
            ps.setInt(9, productModel.getAllowCustomerReviews());
            ps.setInt(10, productModel.getApprovedRatingSum());
            ps.setInt(11, productModel.getNotApprovedRatingSum());
            ps.setInt(12, productModel.getApprovedTotalReviews());
            ps.setInt(13, productModel.getNotApprovedTotalReviews());
            ps.setInt(14, productModel.getSubjectToAcl());
            ps.setInt(15, productModel.getLimitedToStores());
            ps.setInt(16, productModel.getIsGiftCard());
            ps.setInt(17, productModel.getGiftCardTypeId());
            ps.setInt(18, productModel.getRequireOtherProducts());
            ps.setInt(19, productModel.getAutomaticallyAddRequiredProducts());
            ps.setInt(20, productModel.getIsDownload());
            ps.setInt(21, productModel.getDownloadId());
            ps.setInt(22, productModel.getUnlimitedDownloads());
            ps.setInt(23, productModel.getMaxNumberOfDownloads());
            ps.setInt(24, productModel.getDownloadActivationTypeId());
            ps.setInt(25, productModel.getHasSampleDownload());
            ps.setInt(26, productModel.getSampleDownloadId());
            ps.setInt(27, productModel.getHasUserAgreement());
            ps.setInt(28, productModel.getIsRecurring());
            ps.setInt(29, productModel.getRecurringCycleLength());
            ps.setInt(30, productModel.getRecurringCyclePeriodId());
            ps.setInt(31, productModel.getRecurringTotalCycles());
            ps.setInt(32, productModel.getIsRental());
            ps.setInt(33, productModel.getRentalPriceLength());
            ps.setInt(34, productModel.getRentalPricePeriodId());
            ps.setInt(35, productModel.getIsShipEnabled());
            ps.setInt(36, productModel.getIsFreeShipping());
            ps.setInt(37, productModel.getShipSeparately());
            ps.setDouble(38, productModel.getAdditionalShippingCharge());
            ps.setInt(39, productModel.getDeliveryDateId());
            ps.setInt(40, productModel.getIsTaxExempt());
            ps.setInt(41, productModel.getTaxCategoryId());
            ps.setInt(42, productModel.getIsTelecommunicationsOrBroadcastingOrElectronicServices());
            ps.setInt(43, productModel.getManageInventoryMethodId());
            ps.setInt(44, productModel.getProductAvailabilityRangeId());
            ps.setInt(45, productModel.getUseMultipleWarehouses());
            ps.setInt(46, productModel.getWarehouseId());
            ps.setInt(47, productModel.getStockQuantity());
            ps.setInt(48, productModel.getDisplayStockAvailability());
            ps.setInt(49, productModel.getDisplayStockQuantity());
            ps.setInt(50, productModel.getMinStockQuantity());
            ps.setInt(51, productModel.getLowStockActivityId());
            ps.setInt(52, productModel.getNotifyAdminForQuantityBelow());
            ps.setInt(53, productModel.getBackorderModeId());
            ps.setInt(54, productModel.getAllowBackInStockSubscriptions());
            ps.setInt(55, productModel.getOrderMinimumQuantity());
            ps.setInt(56, productModel.getOrderMaximumQuantity());
            ps.setInt(57, productModel.getAllowAddingOnlyExistingAttributeCombinations());
            ps.setInt(58, productModel.getNotReturnable());
            ps.setInt(59, productModel.getDisableBuyButton());
            ps.setInt(60, productModel.getDisableWishlistButton());
            ps.setInt(61, productModel.getAvailableForPreOrder());
            ps.setInt(62, productModel.getCallForPrice());
            ps.setDouble(63, productModel.getPrice());
            ps.setDouble(64, productModel.getOldPrice());
            ps.setDouble(65, productModel.getProductCost());
            ps.setInt(66, productModel.getCustomerEntersPrice());
            ps.setDouble(67, productModel.getMinimumCustomerEnteredPrice());
            ps.setDouble(68, productModel.getMaximumCustomerEnteredPrice());
            ps.setInt(69, productModel.getBasePriceEnabled());
            ps.setDouble(70, productModel.getBasePriceAmount());
            ps.setInt(71, productModel.getBasePriceUnitId());
            ps.setDouble(72, productModel.getBasePriceBaseAmount());
            ps.setInt(73, productModel.getBasePriceBaseUnitId());
            ps.setInt(74, productModel.getMarkAsNew());
            ps.setInt(75, productModel.getHasTierPrices());
            ps.setInt(76, productModel.getHasDiscountsApplied());
            ps.setDouble(77, productModel.getWeight());
            ps.setDouble(78, productModel.getLength());
            ps.setDouble(79, productModel.getWidth());
            ps.setDouble(80, productModel.getHeight());
            ps.setInt(81, productModel.getDisplayOrder());
            ps.setInt(82, productModel.getPublished());
            ps.setInt(83, productModel.getDeleted());
            ps.setString(84, productModel.getCreatedOnUtc());
            ps.setString(85, productModel.getUpdatedOnUtc());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProductModel create() {
        ProductModel productModel = new FillProductModel().fillRequiredFields();
        create(productModel);
        return productModel;
    }

    @Override
    public void deleteAll(String patternName) {
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute("DELETE FROM Product WHERE Name LIKE + '" + patternName + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}