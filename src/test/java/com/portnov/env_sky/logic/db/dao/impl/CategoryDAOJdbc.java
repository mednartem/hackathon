package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.CategoryDAO;
import com.portnov.env_sky.logic.db.model.CategoryEntity;
import com.portnov.env_sky.logic.data.FillCategoryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryDAOJdbc implements CategoryDAO {

    private static SQLServerDataSource ds = ServiceDB.INSTANCE.getDataSource();

    @Override
    public void create(CategoryEntity categoryEntity) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO Category (" +
                     "Name," +
                     "Description," +
                     "ParentCategoryId," +
                     "PictureId," +
                     "CategoryTemplateId," +
                     "ManuallyPriceRange," +
                     "PageSize," +
                     "PageSizeOptions," +
                     "AllowCustomersToSelectPageSize," +
                     "ShowOnHomepage," +
                     "IncludeInTopMenu," +
                     "SubjectToAcl," +
                     "LimitedToStores," +
                     "Published," +
                     "Deleted," +
                     "DisplayOrder," +
                     "CreatedOnUtc," +
                     "UpdatedOnUtc," +
                     "PriceRangeFiltering," +
                     "PriceFrom," +
                     "PriceTo" +
                     ")" +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
        ) {
            ps.setString(1, categoryEntity.getName());
            ps.setString(2, categoryEntity.getDescription());
            ps.setInt(3, categoryEntity.getParentCategoryId());
            ps.setInt(4, categoryEntity.getPictureId());
            ps.setInt(5, categoryEntity.getCategoryTemplateId());
            ps.setInt(6, categoryEntity.getManuallyPriceRange());
            ps.setInt(7, categoryEntity.getPageSize());
            ps.setString(8, categoryEntity.getPageSizeOptions());
            ps.setInt(9, categoryEntity.getAllowCustomersToSelectPageSize());
            ps.setInt(10, categoryEntity.getShowOnHomepage());
            ps.setInt(11, categoryEntity.getIncludeInTopMenu());
            ps.setInt(12, categoryEntity.getSubjectToAcl());
            ps.setInt(13, categoryEntity.getLimitedToStores());
            ps.setInt(14, categoryEntity.getPublished());
            ps.setInt(15, categoryEntity.getDeleted());
            ps.setInt(16, categoryEntity.getDisplayOrder());
            ps.setString(17, categoryEntity.getCreatedOnUtc());
            ps.setString(18, categoryEntity.getUpdatedOnUtc());
            ps.setInt(19, categoryEntity.getPriceRangeFiltering());
            ps.setInt(20, categoryEntity.getPriceFrom());
            ps.setInt(21, categoryEntity.getPriceTo());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CategoryEntity create() {
        CategoryEntity categoryEntity = new FillCategoryEntity().fillRequiredFields();
        create(categoryEntity);
        return categoryEntity;
    }

    @Override
    public void deleteAll(String patternName) {
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute("DELETE FROM Category WHERE Name LIKE + '" + patternName + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}