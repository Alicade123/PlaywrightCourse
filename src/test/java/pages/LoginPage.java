package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final String loginUsernameField = "input[name='username']";
    private final String loginPasswordField = "input[name='password']";
    private final String loginBtn = "button[type='submit']";
    public LoginPage(Page page){
        this.page = page;
    }
    public void addUsername(String username){
        page.fill(loginUsernameField, username);
    }
    public void addPassword(String passcode){
        page.fill(loginPasswordField, passcode);
    }
    public void clickLoginButton(){
        page.click(loginBtn);
    }

}
