package logic.rest;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import logic.dictionary.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class AuthorizationApi extends BaseApi {

    public String getNopAuthentication(String email, String password) {
        ValidatableResponse body = getRequestVerificationToken();
        String verificationToken = getRequestVerificationTokenFromHtml(body.extract().asString());
        String cookieAntiforgery = body.extract().cookie(Cookie.NOP_ANTIFORGERY.getName());
        return getNopAuthentication(email, password, verificationToken, cookieAntiforgery);
    }

    private String getRequestVerificationTokenFromHtml(String html) {
        Document document = Jsoup.parse(html);
        Element tokenInput = document.select("input[name=__RequestVerificationToken]").first();
        return Objects.requireNonNull(tokenInput).attr("value");
    }

    private ValidatableResponse getRequestVerificationToken() {
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
                    put("Email", email);
                    put("Password", password);
                    put("__RequestVerificationToken", requestVerificationToken);
                }})
                .redirects().follow(false)
                .post("/login")
                .then()
                .assertThat().statusCode(302)
                .extract().cookie(Cookie.NOP_AUTHENTICATION.getName());

        return Objects.requireNonNull(cookie);
    }
}
