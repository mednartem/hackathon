package com.portnov.env_sky.logic.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:selenoid.properties",
        "system:properties"
})
public interface SelenoidConfig extends Config {

    @Key("isRemote")
    boolean isRemote();

    @Key("url")
    String url();

    @Key("username")
    String username();

    @Key("password")
    String password();
}
