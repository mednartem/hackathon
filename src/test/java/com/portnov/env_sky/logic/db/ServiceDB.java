package com.portnov.env_sky.logic.db;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.portnov.env_sky.logic.config.ProjectConfig;

public enum ServiceDB {
    INSTANCE;

    public SQLServerDataSource getDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(ProjectConfig.db.user());
        ds.setPassword(ProjectConfig.db.password());
        ds.setServerName(ProjectConfig.db.server());
        ds.setPortNumber(ProjectConfig.db.port());
        ds.setDatabaseName(ProjectConfig.db.databaseName());
        ds.setEncrypt("true");
        ds.setTrustServerCertificate(true);

        return ds;
    }
}
