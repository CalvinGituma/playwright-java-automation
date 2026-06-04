package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLoginPage(String url) {

        page.navigate(url);
    }

    public void login(
            String username,
            String password) {

        page.locator("#username")
                .fill(username);

        page.locator("#password")
                .fill(password);

        page.locator("#submit")
                .click();
    }
}

