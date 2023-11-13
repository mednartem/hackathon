package logic.steps;

import com.codeborne.selenide.Selenide;
import logic.dictionary.Cookie;
import logic.rest.AuthorizationApi;

public class BaseSteps {

    public BaseSteps iOpenBasePage() {
        Selenide.open("/");
        return this;
    }

    public void iAddCookieToBrowserAndRefreshPage(String email, String password) {
        String nopAuthToken = new AuthorizationApi().getNopAuthentication(email, password);
        Selenide.executeJavaScript(
                String.format("document.cookie = '%s = %s';", Cookie.NOP_AUTHENTICATION.getName(), nopAuthToken)
        );
        Selenide.refresh();
    }
}
