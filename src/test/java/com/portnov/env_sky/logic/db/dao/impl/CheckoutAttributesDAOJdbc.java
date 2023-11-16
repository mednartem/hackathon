package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.CheckoutAttributesDAO;
import com.portnov.env_sky.logic.db.model.CheckoutAttributesEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckoutAttributesDAOJdbc implements CheckoutAttributesDAO {

    private static SQLServerDataSource ds = ServiceDB.INSTANCE.getDataSource();

    @Override
    public void create(CheckoutAttributesEntity checkoutAttributesEntity) {
        String sql = """
                INSERT INTO CheckoutAttribute (
                Name,
                TextPrompt,
                IsRequired,
                ShippableProductRequired,
                IsTaxExempt,
                TaxCategoryId,
                AttributeControlTypeId,
                DisplayOrder,
                LimitedToStores
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)""";
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, checkoutAttributesEntity.getName());
            ps.setString(2, checkoutAttributesEntity.getTextPrompt());
            ps.setInt(3, checkoutAttributesEntity.getIsRequired());
            ps.setInt(4, checkoutAttributesEntity.getShippableProductRequired());
            ps.setInt(5, checkoutAttributesEntity.getIsTaxExempt());
            ps.setInt(6, checkoutAttributesEntity.getTaxCategoryId());
            ps.setInt(7, checkoutAttributesEntity.getAttributeControlTypeId());
            ps.setInt(8, checkoutAttributesEntity.getDisplayOrder());
            ps.setInt(9, checkoutAttributesEntity.getLimitedToStores());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating the checkout attribute: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll(String patternName) {
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM CheckoutAttribute WHERE Name LIKE ?")) {

            statement.setString(1, "%" + patternName + "%");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error removing the checkout attributes by pattern: " + patternName + ";\n" + e.getMessage());
        }
    }
}