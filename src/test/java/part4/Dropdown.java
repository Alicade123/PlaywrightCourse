package part4;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Dropdown {
    public static void main(String[] args) {
        String dropdownUrl = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo/";
        String dropdownUrlJQuery = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo/";
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
        page.navigate(dropdownUrl);
        Locator dayLocator = page.locator("#select-demo");
        dayLocator.selectOption(new SelectOption().setLabel("Wednesday"));
        assertThat(page.locator("#select-demo option:checked"))
                .hasText("Wednesday");
        System.out.println(dayLocator.inputValue());
//        assertThat(page.locator("p.selected-value")).containsText("Wednesday");
//        System.out.println(page.locator("p.selected-value").textContent());
    }
}
