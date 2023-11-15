package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.CategoryDAO;
import com.portnov.env_sky.logic.db.model.CategoryModel;
import com.portnov.env_sky.logic.data.FillCategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryDAOJdbc implements CategoryDAO {

    private static SQLServerDataSource ds = ServiceDB.INSTANCE.getDataSource();

    @Override
    public void create(CategoryModel categoryModel) {
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
            ps.setString(1, categoryModel.getName());
            ps.setString(2, categoryModel.getDescription());
            ps.setInt(3, categoryModel.getParentCategoryId());
            ps.setInt(4, categoryModel.getPictureId());
            ps.setInt(5, categoryModel.getCategoryTemplateId());
            ps.setInt(6, categoryModel.getManuallyPriceRange());
            ps.setInt(7, categoryModel.getPageSize());
            ps.setString(8, categoryModel.getPageSizeOptions());
            ps.setInt(9, categoryModel.getAllowCustomersToSelectPageSize());
            ps.setInt(10, categoryModel.getShowOnHomepage());
            ps.setInt(11, categoryModel.getIncludeInTopMenu());
            ps.setInt(12, categoryModel.getSubjectToAcl());
            ps.setInt(13, categoryModel.getLimitedToStores());
            ps.setInt(14, categoryModel.getPublished());
            ps.setInt(15, categoryModel.getDeleted());
            ps.setInt(16, categoryModel.getDisplayOrder());
            ps.setString(17, categoryModel.getCreatedOnUtc());
            ps.setString(18, categoryModel.getUpdatedOnUtc());
            ps.setInt(19, categoryModel.getPriceRangeFiltering());
            ps.setInt(20, categoryModel.getPriceFrom());
            ps.setInt(21, categoryModel.getPriceTo());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CategoryModel create() {
        CategoryModel categoryModel = new FillCategoryModel().fillRequiredFields();
        create(categoryModel);
        return categoryModel;
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