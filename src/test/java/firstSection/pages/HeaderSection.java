package firstSection.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HeaderSection {
    private  final Page page;
    public  HeaderSection(Page page){
        this.page=page;
    }
    private Locator getMyAccountElement(){
       return this.page.locator("//a[contains(.,'My account')][@role='button']");
    }
    public void clickLogin(){
        this.getMyAccountElement().hover();
        this.page.locator("//a[contains(.,'Login')]").click();
    }
    public void clickRegister(){
        this.getMyAccountElement().hover();
        this.page.locator("//a[contains(.,'Register')]").click();
    }
}
