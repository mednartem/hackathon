package com.portnov.env_sky.logic.attachments;

import io.qameta.allure.restassured.AllureRestAssured;

public class AllureFilterApi {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

    private AllureFilterApi() {
    }

    public static AllureFilterApi filters() {
        return InitLogFilter.logFilter;
    }

    public AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");
        return FILTER;
    }

    private static class InitLogFilter {
        private static final AllureFilterApi logFilter = new AllureFilterApi();
    }
}
