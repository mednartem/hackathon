package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.data.FillProductAttributeModel;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.ProductAttributesDAO;
import com.portnov.env_sky.logic.db.model.ProductAttributesModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductAttributesDAOJdbc implements ProductAttributesDAO {

    private static SQLServerDataSource ds = ServiceDB.INSTANCE.getDataSource();

    @Override
    public void create(ProductAttributesModel productAttributesModel) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO ProductAttribute (Name, Description) VALUES (?, ?)")
        ) {
            ps.setString(1, productAttributesModel.getName());
            ps.setString(2, productAttributesModel.getDescription());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProductAttributesModel create() {
        ProductAttributesModel productAttributesModel = new FillProductAttributeModel().fillRequiredFields();
        create(productAttributesModel);
        return productAttributesModel;
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