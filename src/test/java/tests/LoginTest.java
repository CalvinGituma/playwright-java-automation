package tests;

import base.BaseTest;
import data.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
    ConfigReader config = new ConfigReader();

    @Test(priority=1)
    public void successfulLogin() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage(
                config.getProperty("base.url"));

        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password"));

        Assert.assertTrue(
                page.url()
                        .contains(
                                "logged-in-successfully"));
    }
    @Test(
            priority = 2,
            dataProvider = "invalidCredentials",
            dataProviderClass = LoginDataProvider.class
    )
    public void invalidLogin(
            String username,
            String password) {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage(
                config.getProperty("base.url"));

        loginPage.login(
                username,
                password);

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }
}
