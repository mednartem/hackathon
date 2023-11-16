package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.ProductAttributesDAO;
import com.portnov.env_sky.logic.db.model.ProductAttributesEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductAttributesDAOJdbc implements ProductAttributesDAO {

    private static SQLServerDataSource ds = ServiceDB.INSTANCE.getDataSource();

    @Override
    public void create(ProductAttributesEntity productAttributesEntity) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO ProductAttribute (Name, Description) VALUES (?, ?)")
        ) {
            ps.setString(1, productAttributesEntity.getName());
            ps.setString(2, productAttributesEntity.getDescription());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating the product attribute: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll(String patternName) {
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM ProductAttribute WHERE Name LIKE ?")) {

            statement.setString(1, "%" + patternName + "%");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error removing the product attributes by pattern: " + patternName + ";\n" + e.getMessage());
        }
    }
}