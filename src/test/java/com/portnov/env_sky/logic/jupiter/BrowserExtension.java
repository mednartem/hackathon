package com.portnov.env_sky.logic.jupiter;

import com.codeborne.selenide.WebDriverRunner;
import com.portnov.env_sky.logic.attachments.AttachmentHelpers;
import com.portnov.env_sky.logic.db.dao.impl.CategoryDAOJdbc;
import com.portnov.env_sky.logic.db.dao.impl.ProductDAOJdbc;
import com.portnov.env_sky.logic.driver.DesktopDriver;
import org.junit.jupiter.api.extension.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class BrowserExtension implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback,
        ExtensionContext.Store.CloseableResource, TestExecutionExceptionHandler {

    private static boolean started = false;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;
            // Your "before all tests" startup logic goes here
            // The following line registers a callback hook when the root test context is shut down
            context.getRoot().getStore(GLOBAL).put("Started", this);
        }
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        DesktopDriver.configure();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            closeWebDriver();
        }
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (WebDriverRunner.hasWebDriverStarted()) {
            AttachmentHelpers.attachScreenshot("Screenshot");
            AttachmentHelpers.attachAsText("Current url", WebDriverRunner.getWebDriver().getCurrentUrl());
            AttachmentHelpers.attachAsText("Browser console logs", AttachmentHelpers.getConsoleLogs());
        }
        throw throwable;
    }

    @Override
    public void close() {
        String pattern = "autotest%";

        new CategoryDAOJdbc().deleteAll(pattern);
        new ProductDAOJdbc().deleteAll(pattern);
    }
}
