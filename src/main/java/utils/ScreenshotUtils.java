package utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ScreenshotUtils {
    public static void capture(Page page, String fileName) {

        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(
                                Paths.get(
                                        "screenshots/" + fileName + ".png")));
    }
}
