package pages;

import com.microsoft.playwright.Page;

public class RegisterAccount {
    private Page page = null;

    public RegisterAccount(Page page) {
        this.page = page;
    }

    public void clickContinue() {
        page.locator("input[value='Continue']").click();
    }

    public boolean isWarningVisible() {
        return page.locator("div.alert.alert-danger").isVisible();
    }

    public int isMandatoryWarningMessageVisible() {
        return page.locator("div.text-danger").count();
    }

    public void registerUserAccount(String firstName, String lastName, String emial, String telephone,
                                    String password) {
        page.getByLabel("First Name").fill(firstName);
        page.getByLabel("Last Name").fill(lastName);
        page.getByLabel("E-Mail").fill(emial);
        page.getByLabel("Telephone").fill(telephone);
        page.getByLabel("Password",
                new Page.GetByLabelOptions().setExact(true)).fill(password);
        page.getByLabel("Password Confirm").fill(password);
        page.locator("label[for='input-agree']").click();
        this.clickContinue();
    }

    public String isRegisterSuccess() {
        return page.locator("div#content>h1").textContent().trim();
    }
}
