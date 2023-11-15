package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.ManufacturerDAO;
import com.portnov.env_sky.logic.data.FillManufacturerModel;
import com.portnov.env_sky.logic.db.model.ManufacturerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ManufacturerDAOJdbc implements ManufacturerDAO {

    private static SQLServerDataSource ds = ServiceDB.INSTANCE.getDataSource();

    @Override
    public void create(ManufacturerModel categoryModel) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO Manufacturer (" +
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
                     ")")
        ) {
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
        }
    }

    public ManufacturerModel create() {
        ManufacturerModel manufacturerModel = new FillManufacturerModel().fillRequiredFields();
        create(manufacturerModel);
        return manufacturerModel;
    }

    @Override
    public void deleteAll(String patternName) {
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute("DELETE FROM Manufacturer WHERE Name LIKE + '" + patternName + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}