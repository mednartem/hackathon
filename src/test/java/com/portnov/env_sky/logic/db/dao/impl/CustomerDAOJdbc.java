package com.portnov.env_sky.logic.db.dao.impl;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.db.ServiceDB;
import com.portnov.env_sky.logic.db.dao.CustomerDAO;
import com.portnov.env_sky.logic.db.model.CustomerEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAOJdbc implements CustomerDAO {

    private static SQLServerDataSource ds = ServiceDB.INSTANCE.getDataSource();

    @Override
    public void create(CustomerEntity customerEntity) {
        String sql = "INSERT INTO Customer (" +
                "Email," +
                "Username," +
                "CustomerGuid," +
                "IsTaxExempt," +
                "AffiliateId," +
                "VendorId," +
                "HasShoppingCartItems," +
                "RequireReLogin," +
                "FailedLoginAttempts," +
                "Active," +
                "Deleted," +
                "IsSystemAccount," +
                "CreatedOnUtc," +
                "LastActivityDateUtc," +
                "RegisteredInStoreId" +
                ")" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, customerEntity.getEmail());
            ps.setString(2, customerEntity.getUsername());
            ps.setString(3, customerEntity.getCustomerGuid().toString());
            ps.setInt(4, customerEntity.getIsTaxExempt());
            ps.setInt(5, customerEntity.getAffiliateId());
            ps.setInt(6, customerEntity.getVendorId());
            ps.setInt(7, customerEntity.getHasShoppingCartItems());
            ps.setInt(8, customerEntity.getRequireReLogin());
            ps.setInt(9, customerEntity.getFailedLoginAttempts());
            ps.setInt(10, customerEntity.getActive());
            ps.setInt(11, customerEntity.getDeleted());
            ps.setInt(12, customerEntity.getIsSystemAccount());
            ps.setString(13, customerEntity.getCreatedOnUtc());
            ps.setString(14, customerEntity.getLastActivityDateUtc());
            ps.setInt(15, customerEntity.getRegisteredInStoreId());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating the customer: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll(String patternEmail) {
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Customer WHERE Email LIKE ?")) {

            statement.setString(1, "%" + patternEmail + "%");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error removing the customer by pattern: " + patternEmail + ";\n" + e.getMessage());
        }
    }
}