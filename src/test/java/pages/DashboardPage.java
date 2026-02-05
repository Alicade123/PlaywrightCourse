package pages;

import com.microsoft.playwright.Page;

public class DashboardPage {
    private final Page page ;
    private final String headerField = "div.oxd-topbar-header-title h6";
    public DashboardPage(Page page){
        this.page = page;
    }
    public boolean verifyHeader(){
        System.out.println(page.locator(headerField).textContent());
        return page.locator(headerField).isVisible();
    }
}
