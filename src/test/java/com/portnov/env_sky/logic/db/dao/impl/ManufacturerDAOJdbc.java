package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.ManufacturerDAO;
import com.portnov.env_sky.logic.db.model.ManufacturerEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManufacturerDAOJdbc implements ManufacturerDAO {

    private static SQLServerDataSource ds = ServiceDB.INSTANCE.getDataSource();

    @Override
    public void create(ManufacturerEntity categoryModel) {
        String sql = "INSERT INTO Manufacturer (" +
                "Name," +
                "Description," +
                "PageSizeOptions," +
                "ManufacturerTemplateId," +
                "PictureId," +
                "PageSize," +
                "AllowCustomersToSelectPageSize," +
                "SubjectToAcl," +
                "LimitedToStores," +
                "Published," +
                "Deleted," +
                "DisplayOrder," +
                "CreatedOnUtc," +
                "UpdatedOnUtc," +
                "PriceRangeFiltering," +
                "PriceFrom," +
                "PriceTo," +
                "ManuallyPriceRange" +
                ")" +
                "VALUES (" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                "?, ?, ?, ?, ?, ?, ?, ?" +
                ")";

        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, categoryModel.getName());
            ps.setString(2, categoryModel.getDescription());
            ps.setString(3, categoryModel.getPageSizeOptions());
            ps.setInt(4, categoryModel.getManufacturerTemplateId());
            ps.setInt(5, categoryModel.getPictureId());
            ps.setInt(6, categoryModel.getPageSize());
            ps.setInt(7, categoryModel.getAllowCustomersToSelectPageSize());
            ps.setInt(8, categoryModel.getSubjectToAcl());
            ps.setInt(9, categoryModel.getLimitedToStores());
            ps.setInt(10, categoryModel.getPublished());
            ps.setInt(11, categoryModel.getDeleted());
            ps.setInt(12, categoryModel.getDisplayOrder());
            ps.setString(13, categoryModel.getCreatedOnUtc());
            ps.setString(14, categoryModel.getUpdatedOnUtc());
            ps.setInt(15, categoryModel.getPriceRangeFiltering());
            ps.setDouble(16, categoryModel.getPriceFrom());
            ps.setDouble(17, categoryModel.getPriceTo());
            ps.setInt(18, categoryModel.getManuallyPriceRange());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating the manufacturer: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll(String patternName) {
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Manufacturer WHERE Name LIKE ?")) {

            statement.setString(1, "%" + patternName + "%");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error removing the manufactures by pattern: " + patternName + ";\n" + e.getMessage());
        }
    }
}