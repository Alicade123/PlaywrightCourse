package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckboxesPage {
    private Page page;
    private final String firstBox="#checkboxes input";
    public CheckboxesPage(Page page){
        this.page=page;
    }

    public Locator checkFirstBox(){
        page.locator(firstBox).first().check();
        return   page.locator(firstBox).first();
    }
    public Locator uncheckLastBox(){
        page.locator(firstBox).last().uncheck();
        return page.locator(firstBox).last();
    }

}
