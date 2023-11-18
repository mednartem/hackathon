package com.portnov.env_sky.logic.attachments;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;

import static org.openqa.selenium.logging.LogType.BROWSER;

public class AttachmentHelpers {

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}
