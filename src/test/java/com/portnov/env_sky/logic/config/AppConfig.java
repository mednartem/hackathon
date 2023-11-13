package com.portnov.env_sky.logic.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:app.properties"
})
public interface AppConfig extends Config {

    @Key("baseUrl")
    String baseUrl();
}
