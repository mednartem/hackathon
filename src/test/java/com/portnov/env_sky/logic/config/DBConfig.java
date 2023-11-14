package com.portnov.env_sky.logic.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:db.properties"
})
public interface DBConfig extends Config {

    @Key("databaseName")
    String databaseName();

    @Key("server")
    String server();

    @Key("user")
    String user();

    @Key("password")
    String password();

    @Key("port")
    int port();
}
