package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage {

        private Page page;

        private Locator pageHeading;
        private Locator successMessage;
        private Locator logoutButton;

        public DashboardPage(Page page) {

            this.page = page;

            pageHeading = page.locator("h1");
            successMessage = page.locator(".post-content");
            logoutButton = page.locator(".wp-block-button__link");
        }

        public boolean isDashboardDisplayed() {

            return pageHeading.isVisible();
        }
        public String getSuccessMessage() {

            return successMessage.textContent();
        }

        public void clickLogout() {

            logoutButton.click();
        }
    }

