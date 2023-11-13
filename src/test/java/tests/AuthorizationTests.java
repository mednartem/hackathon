package tests;

import logic.config.ProjectConfig;
import logic.jupiter.WebTest;
import logic.steps.AuthSteps;
import logic.steps.BaseSteps;
import org.junit.jupiter.api.Test;

@WebTest
public class AuthorizationTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AuthSteps authSteps = new AuthSteps();

    @Test
    void test01Auth() {
        baseSteps
                .iOpenBasePage();
        authSteps
                .iClickLoginBtnInTheHeader()
                .iTypeEmail(ProjectConfig.credential.adminEmail())
                .iTypePassword(ProjectConfig.credential.adminPassword())
                .iClickLoginBtn()
                .iCheckAccountLinkIsVisible();
    }

    @Test
    void test02Logout() {
        baseSteps
                .iOpenBasePage()
                .iAddCookieToBrowserAndRefreshPage(ProjectConfig.credential.adminEmail(), ProjectConfig.credential.adminPassword());
        authSteps
                .iClickLogoutBtnInTheHeader()
                .loginBtnShouldBeVisibleInTheHeader();
    }
}
