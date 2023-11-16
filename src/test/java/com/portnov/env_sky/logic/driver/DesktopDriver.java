package com.portnov.env_sky.logic.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.portnov.env_sky.logic.config.ProjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class DesktopDriver {

    public static void configure() {
        Configuration.baseUrl = ProjectConfig.app.baseUrl();
        Configuration.browser = ProjectConfig.browser.name();
        Configuration.browserSize = ProjectConfig.browser.browserSize();
        Configuration.baseUrl = ProjectConfig.app.baseUrl();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");

        if (ProjectConfig.browser.isRemote()) {
            Configuration.timeout = 10000;
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";

            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
        }
        Configuration.browserCapabilities = capabilities;
    }
}
