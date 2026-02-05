package firstSection.part1;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LunchBrowser {

    public static void main(String[] args) {
        Playwright playwright =Playwright.create();
//        Browser Options: webkit, firefox, chromium
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page= browser.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/");
        Locator myAccountElement = page.locator("//a[contains(.,'My account')][@role='button']");
        myAccountElement.hover();
        page.locator("//a[contains(.,'Login')]").click();
        assertThat(page).hasTitle("Account Login");
        page.getByPlaceholder("E-Mail Address").type("koushik350@gmail.com");
        page.getByPlaceholder("Password").type("Pass123$");
        page.locator("//input[@value='Login']").click();
        assertThat(page).hasTitle("My Account");
        page.close();
        browser.close();
        playwright.close();
    }
}
