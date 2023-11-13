package com.portnov.env_sky.logic.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browser.properties"
})
public interface BrowserConfig extends Config {

    @Key("name")
    String name();

    @Key("browserSize")
    String browserSize();

    @Key("isRemote")
    boolean isRemote();
}
