package utils;

import com.microsoft.playwright.Page;

public class WaitUtils {
    public static void waitForPageLoad(Page page) {
        page.waitForLoadState();
    }
}
