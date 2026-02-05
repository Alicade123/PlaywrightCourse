package firstSection.browserContext;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LearnBrowserContext {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/");
        Locator myAccountElement = page.locator("//a[contains(.,'My account')][@role='button']");
        myAccountElement.hover();
        page.locator("//a[contains(.,'Login')]").click();
        assertThat(page).hasTitle("Account Login");
        page.getByPlaceholder("E-Mail Address").type("koushik350@gmail.com");
        page.getByPlaceholder("Password").type("Pass123$");
        page.locator("//input[@value='Login']").click();
        assertThat(page).hasTitle("My Account");

        Page newTab = browserContext.newPage();
        newTab.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
        assertThat(page).hasTitle("My Account");

        BrowserContext browserContext1 = browser.newContext();
        Page page1 = browserContext1.newPage();
        page1.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");

        playwright
                .firefox()
                .launch(
                        new BrowserType.LaunchOptions().setHeadless(false))
                .newContext()
                .newPage()
                .navigate("https://ecommerce-playground.lambdatest.io/");
//        playwright
//                .webkit()
//                .launch(
//                        new BrowserType.LaunchOptions().setHeadless(false))
//                .newContext()
//                .newPage()
//                .navigate("https://ecommerce-playground.lambdatest.io/");
        page.close();
        page1.close();
        browserContext.close();
        browserContext1.close();
        browser.close();
        playwright.close();
    }
}

