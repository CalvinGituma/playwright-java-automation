package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test(priority=1)
    public void successfulLogin() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage();

        loginPage.login(
                "student",
                "Password123");

        Assert.assertTrue(
                page.url()
                        .contains(
                                "logged-in-successfully"));
    }
    @Test(priority=2)
    public void invalidPassword() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage();

        loginPage.login(
                "student",
                "wrongpassword");

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }
    @Test(priority=3)
    public void invalidUsername() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage();

        loginPage.login(
                "wrongusername",
                "Password123");

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }
    @Test(priority=4)
    public void emptyUsername() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage();

        loginPage.login(
                "",
                "Password123");

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }
    @Test(priority=5)
    public void emptyPassword() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage();

        loginPage.login(
                "student",
                "");

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }
    @Test(priority=6)
    public void emptyUsernameAndPassword() {

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.navigateToLoginPage();

        loginPage.login(
                "",
                "");

        Assert.assertTrue(
                page.locator("#error")
                        .isVisible());
    }

}
