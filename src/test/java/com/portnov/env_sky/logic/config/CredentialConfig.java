package com.portnov.env_sky.logic.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:credential.properties"
})
public interface CredentialConfig extends Config {

    @Key("adminEmail")
    String adminEmail();

    @Key("adminPassword")
    String adminPassword();
}
