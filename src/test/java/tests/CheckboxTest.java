package tests;

import base.BaseTest;

import org.testng.annotations.Test;
import pages.CheckboxesPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckboxTest extends BaseTest {
    @Test
    public void handleCheckbox(){
        CheckboxesPage checkboxesPage = new CheckboxesPage(page);
        page.navigate("https://the-internet.herokuapp.com/checkboxes");
        assertThat(checkboxesPage.checkFirstBox()).isChecked();
        System.out.println(checkboxesPage.checkFirstBox().inputValue());
        assertThat(checkboxesPage.uncheckLastBox()).not().isChecked();
        System.out.println(checkboxesPage.uncheckLastBox().inputValue());
    }
}
