package logic.config;

import org.aeonbits.owner.ConfigFactory;

public class ProjectConfig {

    public static CredentialConfig credential = ConfigFactory.create(CredentialConfig.class);

    public static AppConfig app = ConfigFactory.create(AppConfig.class, System.getProperties());
    public static BrowserConfig browser = ConfigFactory.create(BrowserConfig.class, System.getProperties());
}
