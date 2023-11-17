package com.portnov.env_sky.logic.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:selenoid.properties",
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
