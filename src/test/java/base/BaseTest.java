package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ConfigReader config;

    @BeforeMethod
    public void setup() {

        playwright = Playwright.create();
        config = new ConfigReader();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));

        page = browser.newPage();
    }

    @AfterMethod
    public void tearDown() {

        browser.close();
        playwright.close();
    }
}

