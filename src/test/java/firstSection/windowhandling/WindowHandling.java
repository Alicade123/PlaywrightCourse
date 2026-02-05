package firstSection.windowhandling;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class WindowHandling {
    public static void main(String[] args) {
        //Todo : Handle one window
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.testmuai.com/selenium-playground/window-popup-modal-demo/");
        System.out.println("Main window title: " + page.title());
//        Page popupPage = page.waitForPopup(() -> {
//            page.getByText("Follow On Twitter").click();
//        });
//        popupPage.waitForLoadState();
////        assertThat(popupPage).hasTitle("Profile / X");
////        popupPage.getByText("Create account").click();
//        popupPage.close();

        //Todo : Handle multiple windows
//        Page multipleTabs= page.waitForPopup(
//                new Page.WaitForPopupOptions().setPredicate(e->e.context().pages().size()==3),
//                ()->{
//          page.getByText("Follow All").click();
//        });
        Page  multipleTabs = page.waitForPopup(
                () -> {
                    page.getByText("Follow All").click();
                });
        List<Page> tabsList = multipleTabs.context().pages();
        System.out.println(tabsList.size());
        tabsList.forEach(System.out::println);
        //Todo: another approach to wait
//        List<Page> pages = new ArrayList<>();
//        page.onPopup(pages::add);
//        page.locator("//a[text()='Follow All']").click();
// Wait until expected number of tabs open
//        page.waitForCondition(() -> page.context().pages().size() == 3);
//        List<Page> tabsList = page.context().pages();

//Todo: Separate pages

//        Page fbPage = null;
//        Page xPage = null;
//        for (Page p : page.context().pages()) {
//            p.waitForLoadState();
//            if (p.url().contains("facebook")) {
//                fbPage = p;
//            } else if (p.url().contains("x.com") || p.url().contains("twitter")) {
//                xPage = p;
//            }
//        }

        page.close();
        browser.close();
        playwright.close();
    }
}
