package tests;

import base.BaseTest;
import org.testng.Assert;
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
    @Test(priority=2)
    public void invalidPassword() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage(
                config.getProperty("base.url"));
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("wrongPassword"));

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }
    @Test(priority=3)
    public void invalidUsername() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage(
                config.getProperty("base.url"));

        loginPage.login(
                config.getProperty("wrongUsername"),
                config.getProperty("password"));

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }
    @Test(priority=4)
    public void emptyUsername() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage(
                config.getProperty("base.url"));
        loginPage.login(
                config.getProperty("emptyUsername"),
                config.getProperty("password"));

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }
    @Test(priority=5)
    public void emptyPassword() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage(
                config.getProperty("base.url"));

        loginPage.login(
                config.getProperty("username"),
                config.getProperty("emptyPassword"));

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }
    @Test(priority=6)
    public void emptyUsernameAndPassword() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage(
                config.getProperty("base.url"));
        loginPage.login(
                config.getProperty("emptyUsername"),
                config.getProperty("emptyPassword"));

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }

}
