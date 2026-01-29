package part5.screenshot;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenshotCaret;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class TakingScreenshot {
    public static void main(String[] args) {
        LocalDateTime tm = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
        String formattedTime = formatter.format(tm);
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        //Todo 1:Taking usual screenshot
        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo/");
        Page.ScreenshotOptions screenshotOption = new Page.ScreenshotOptions();
        page.screenshot(screenshotOption.setPath(new File("./snaps/screenshot/img"+formattedTime+"_.png").toPath()));

        //Todo 2: Taking full page screenshot
        page.screenshot(screenshotOption.setFullPage(true).setPath(new File("./snaps/screenshot/fullImg"+formattedTime+"_.jpg").toPath()));

        //Todo 3: Taking screenshot for specific locator/element
        Locator locatorDemoBtn = page.locator("//button[text()='Book a Demo']");
        locatorDemoBtn.screenshot(new Locator.ScreenshotOptions().setPath(new File("./snaps/screenshot/elementImg"+formattedTime+"_.jpg").toPath()));

        //Todo 4: Taking screenshot for specific region
        Locator locatorHead = page.locator("div.chfw-header_items");
        locatorHead.screenshot(new Locator.ScreenshotOptions().setPath(new File("./snaps/screenshot/regionImg"+formattedTime+"_.jpg").toPath()));
        //Todo 4: Taking screenshot but masking input
//        Locator inputLocator = page.locator("input#user-message");
//        inputLocator.type("something secret");
//        page.screenshot(screenshotOption.setFullPage(false).setMask(Arrays.asList(inputLocator)).setPath(new File("./snaps/screenshot/elementMaskingImg"+formattedTime+"_.jpg").toPath()));

        //Todo 5: Taking screenshot with caret
        Locator locatorInput = page.locator("input#user-message");
        locatorInput.click();
        locatorInput.scrollIntoViewIfNeeded();
        page.screenshot(screenshotOption.setCaret(ScreenshotCaret.HIDE).setPath(Paths.get("./snaps/screenshot/caretHIDEImg"+formattedTime+"_.png")));
        locatorInput.click();
        locatorInput.scrollIntoViewIfNeeded();
        page.screenshot(screenshotOption.setCaret(ScreenshotCaret.INITIAL).setPath(Paths.get("./snaps/screenshot/caretInitialImg"+formattedTime+"_.png")));

        System.out.println(page.title());
        browser.close();
        playwright.close();
    }
}
