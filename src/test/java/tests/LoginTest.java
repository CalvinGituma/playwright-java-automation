package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
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
    @Test
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
}
