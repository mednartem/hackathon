package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.ProductDAO;
import com.portnov.env_sky.logic.data.FillProductModelEntity;
import com.portnov.env_sky.logic.db.model.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAOJdbc implements ProductDAO {

    private static SQLServerDataSource ds = ServiceDB.INSTANCE.getDataSource();

    @Override
    public void create(ProductEntity productEntity) {
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
            ps.setString(1, productEntity.getName());
            ps.setString(2, productEntity.getShortDescription());
            ps.setInt(3, productEntity.getParentGroupedProductId());
            ps.setInt(4, productEntity.getProductTypeId());
            ps.setInt(5, productEntity.getVisibleIndividually());
            ps.setInt(6, productEntity.getProductTemplateId());
            ps.setInt(7, productEntity.getVendorId());
            ps.setInt(8, productEntity.getShowOnHomepage());
            ps.setInt(9, productEntity.getAllowCustomerReviews());
            ps.setInt(10, productEntity.getApprovedRatingSum());
            ps.setInt(11, productEntity.getNotApprovedRatingSum());
            ps.setInt(12, productEntity.getApprovedTotalReviews());
            ps.setInt(13, productEntity.getNotApprovedTotalReviews());
            ps.setInt(14, productEntity.getSubjectToAcl());
            ps.setInt(15, productEntity.getLimitedToStores());
            ps.setInt(16, productEntity.getIsGiftCard());
            ps.setInt(17, productEntity.getGiftCardTypeId());
            ps.setInt(18, productEntity.getRequireOtherProducts());
            ps.setInt(19, productEntity.getAutomaticallyAddRequiredProducts());
            ps.setInt(20, productEntity.getIsDownload());
            ps.setInt(21, productEntity.getDownloadId());
            ps.setInt(22, productEntity.getUnlimitedDownloads());
            ps.setInt(23, productEntity.getMaxNumberOfDownloads());
            ps.setInt(24, productEntity.getDownloadActivationTypeId());
            ps.setInt(25, productEntity.getHasSampleDownload());
            ps.setInt(26, productEntity.getSampleDownloadId());
            ps.setInt(27, productEntity.getHasUserAgreement());
            ps.setInt(28, productEntity.getIsRecurring());
            ps.setInt(29, productEntity.getRecurringCycleLength());
            ps.setInt(30, productEntity.getRecurringCyclePeriodId());
            ps.setInt(31, productEntity.getRecurringTotalCycles());
            ps.setInt(32, productEntity.getIsRental());
            ps.setInt(33, productEntity.getRentalPriceLength());
            ps.setInt(34, productEntity.getRentalPricePeriodId());
            ps.setInt(35, productEntity.getIsShipEnabled());
            ps.setInt(36, productEntity.getIsFreeShipping());
            ps.setInt(37, productEntity.getShipSeparately());
            ps.setDouble(38, productEntity.getAdditionalShippingCharge());
            ps.setInt(39, productEntity.getDeliveryDateId());
            ps.setInt(40, productEntity.getIsTaxExempt());
            ps.setInt(41, productEntity.getTaxCategoryId());
            ps.setInt(42, productEntity.getIsTelecommunicationsOrBroadcastingOrElectronicServices());
            ps.setInt(43, productEntity.getManageInventoryMethodId());
            ps.setInt(44, productEntity.getProductAvailabilityRangeId());
            ps.setInt(45, productEntity.getUseMultipleWarehouses());
            ps.setInt(46, productEntity.getWarehouseId());
            ps.setInt(47, productEntity.getStockQuantity());
            ps.setInt(48, productEntity.getDisplayStockAvailability());
            ps.setInt(49, productEntity.getDisplayStockQuantity());
            ps.setInt(50, productEntity.getMinStockQuantity());
            ps.setInt(51, productEntity.getLowStockActivityId());
            ps.setInt(52, productEntity.getNotifyAdminForQuantityBelow());
            ps.setInt(53, productEntity.getBackorderModeId());
            ps.setInt(54, productEntity.getAllowBackInStockSubscriptions());
            ps.setInt(55, productEntity.getOrderMinimumQuantity());
            ps.setInt(56, productEntity.getOrderMaximumQuantity());
            ps.setInt(57, productEntity.getAllowAddingOnlyExistingAttributeCombinations());
            ps.setInt(58, productEntity.getNotReturnable());
            ps.setInt(59, productEntity.getDisableBuyButton());
            ps.setInt(60, productEntity.getDisableWishlistButton());
            ps.setInt(61, productEntity.getAvailableForPreOrder());
            ps.setInt(62, productEntity.getCallForPrice());
            ps.setDouble(63, productEntity.getPrice());
            ps.setDouble(64, productEntity.getOldPrice());
            ps.setDouble(65, productEntity.getProductCost());
            ps.setInt(66, productEntity.getCustomerEntersPrice());
            ps.setDouble(67, productEntity.getMinimumCustomerEnteredPrice());
            ps.setDouble(68, productEntity.getMaximumCustomerEnteredPrice());
            ps.setInt(69, productEntity.getBasePriceEnabled());
            ps.setDouble(70, productEntity.getBasePriceAmount());
            ps.setInt(71, productEntity.getBasePriceUnitId());
            ps.setDouble(72, productEntity.getBasePriceBaseAmount());
            ps.setInt(73, productEntity.getBasePriceBaseUnitId());
            ps.setInt(74, productEntity.getMarkAsNew());
            ps.setInt(75, productEntity.getHasTierPrices());
            ps.setInt(76, productEntity.getHasDiscountsApplied());
            ps.setDouble(77, productEntity.getWeight());
            ps.setDouble(78, productEntity.getLength());
            ps.setDouble(79, productEntity.getWidth());
            ps.setDouble(80, productEntity.getHeight());
            ps.setInt(81, productEntity.getDisplayOrder());
            ps.setInt(82, productEntity.getPublished());
            ps.setInt(83, productEntity.getDeleted());
            ps.setString(84, productEntity.getCreatedOnUtc());
            ps.setString(85, productEntity.getUpdatedOnUtc());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProductEntity create() {
        ProductEntity productEntity = new FillProductModelEntity().fillRequiredFields();
        create(productEntity);
        return productEntity;
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