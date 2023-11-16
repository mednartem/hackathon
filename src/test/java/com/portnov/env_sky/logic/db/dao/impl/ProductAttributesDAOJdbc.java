package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.data.FillProductAttributeEntity;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.ProductAttributesDAO;
import com.portnov.env_sky.logic.db.model.ProductAttributesEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
        }
    }

    public ProductAttributesEntity create() {
        ProductAttributesEntity productAttributesEntity = new FillProductAttributeEntity().fillRequiredFields();
        create(productAttributesEntity);
        return productAttributesEntity;
    }

    @Override
    public void deleteAll(String patternName) {
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute("DELETE FROM ProductAttribute WHERE Name LIKE + '" + patternName + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}