package com.portnov.env_sky.logic.rest;

import com.portnov.env_sky.logic.dictionary.api.Cookie;
import com.portnov.env_sky.logic.dictionary.api.EndpointsApi;
import com.portnov.env_sky.logic.dictionary.api.Params;
import com.portnov.env_sky.logic.rest.model.PersonModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class AuthorizationApi extends BaseApi {

    @Step("I get nop authentication")
    public PersonModel getNopAuthentication(String email, String password) {
        PersonModel personModel = new PersonModel();
        ValidatableResponse body = getBaseUrl();
        String verificationToken = getRequestVerificationTokenFromHtml(body.extract().asString());
        String cookieAntiforgery = body.extract().cookie(Cookie.NOP_ANTIFORGERY.getName());
        String cookieNopAuthentication = getNopAuthentication(email, password, verificationToken, cookieAntiforgery);

        personModel.setEmail(email);
        personModel.setPassword(password);
        personModel.setVerificationToken(verificationToken);
        personModel.setCookieNopAntiforgery(cookieAntiforgery);
        personModel.setCookieNopAuthentication(cookieNopAuthentication);

        return personModel;
    }

    private String getRequestVerificationTokenFromHtml(String html) {
        Document document = Jsoup.parse(html);
        Element tokenInput = document.select("input[name=" + Params.REQUEST_VERIFICATION_TOKEN + "]").first();
        return Objects.requireNonNull(tokenInput).attr("value");
    }

    private ValidatableResponse getBaseUrl() {
        return given()
                .spec(getRequestSpecification())
                .get()
                .then()
                .spec(getResponseSpecification());
    }

    private String getNopAuthentication(String email, String password, String requestVerificationToken, String cookieAntiforgery) {
        String cookie = given()
                .spec(getRequestSpecification())
                .accept(ContentType.HTML)
                .contentType(ContentType.URLENC)
                .cookie(Cookie.NOP_ANTIFORGERY.getName(), cookieAntiforgery)
                .formParams(new HashMap<>() {{
                    put(Params.EMAIL, email);
                    put(Params.PASSWORD, password);
                    put(Params.REQUEST_VERIFICATION_TOKEN, requestVerificationToken);
                }})
                .redirects().follow(false)
                .post(EndpointsApi.LOGIN)
                .then()
                .assertThat().statusCode(HttpStatus.SC_MOVED_TEMPORARILY)
                .extract().cookie(Cookie.NOP_AUTHENTICATION.getName());

        return Objects.requireNonNull(cookie);
    }
}
