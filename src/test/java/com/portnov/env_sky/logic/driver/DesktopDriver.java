package com.portnov.env_sky.logic.driver;

import com.codeborne.selenide.Configuration;
import com.portnov.env_sky.logic.config.ProjectConfig;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class DesktopDriver {

    public static void configure() {
        Configuration.baseUrl = ProjectConfig.app.baseUrl();
        Configuration.browser = ProjectConfig.browser.name();
        Configuration.browserSize = ProjectConfig.browser.browserSize();
        Configuration.baseUrl = ProjectConfig.app.baseUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");

        String remoteUrl = System.getProperty("remoteUrl");
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
        }
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
