package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {
    @Test(priority=1)
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage(page);

        DashboardPage dashboardPage =
                new DashboardPage(page);

        loginPage.navigateToLoginPage(
                config.getProperty("base.url"));

        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password"));

//        Assert.assertTrue(
//                dashboardPage.isDashboardDisplayed());

        System.out.println(dashboardPage.getSuccessMessage());
        Assert.assertTrue(
                dashboardPage.getSuccessMessage().contains("Congratulations student. You successfully logged in!"));
    }
    @Test(priority=2)
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(page);
        DashboardPage dashboardPage = new DashboardPage(page);

        loginPage.navigateToLoginPage(
                config.getProperty("base.url"));

        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password"));

        dashboardPage.clickLogout();

        Assert.assertTrue(
                page.url().contains("practice-test-login"));
    }


}
