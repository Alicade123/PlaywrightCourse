package part4;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Dropdown {
    public static void main(String[] args) {
        String dropdownUrl = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo/";
        String dropdownUrlJQuery = "https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo/";
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
        //Todo: Usual dropdown
//        page.navigate(dropdownUrl);
//        Locator dayLocator = page.locator("#select-demo");
//
//        // By value
//        dayLocator.selectOption("Wednesday");
//        dayLocator.selectOption(new SelectOption().setValue("Wednesday"));
//        //By label
//        dayLocator.selectOption(new SelectOption().setLabel("Wednesday"));
//        //By index
//        dayLocator.selectOption(new SelectOption().setIndex(2));
//        //By
////        assertThat(page.locator("#select-demo option:checked"))
////                .hasText("Wednesday");
////        System.out.println(dayLocator.inputValue());
////        assertThat(page.locator("p.selected-value")).containsText("Wednesday");
////        System.out.println(page.locator("p.selected-value").textContent());
//
//        Locator states = page.locator("#multi-select");
//        states.selectOption(new String[]{"New Jersey","Pennsylvania"});
//
//        Locator options = states.locator("options");
//        System.out.println(options.count());
//        List<String> allStates = options.allInnerTexts();
//        allStates.forEach(e-> System.out.println(e));
        //Todo: JQuery dropdown
        page.navigate(dropdownUrlJQuery);
        Locator countries = page.locator("span.select2-selection").first();
        countries.click();
        Locator list = page.locator("span.select2-results ul li",new Page.LocatorOptions().setHasText("Hong Kong"));
        list.click();

        Locator files = page.locator("select[name=files]");
        files.selectOption("Ruby");
    }
}
