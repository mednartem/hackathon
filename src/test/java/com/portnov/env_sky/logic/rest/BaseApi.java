package com.portnov.env_sky.logic.rest;

import com.portnov.env_sky.logic.config.ProjectConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.Arrays;

import static com.portnov.env_sky.logic.attachments.AllureFilterApi.filters;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.in;

public class BaseApi {

    public static ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(is(in(Arrays.asList(HttpStatus.SC_CREATED, HttpStatus.SC_OK))))
                .build();
    }

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(ProjectConfig.app.baseUrl())
                .addFilter(filters().withCustomTemplates())
                .setContentType(ContentType.HTML)
                .build();
    }
}
