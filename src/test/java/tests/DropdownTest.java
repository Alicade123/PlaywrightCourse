package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DropdownPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DropdownTest extends BaseTest {
    @Test
    public void testDropdownFieldByValue() {
        String value = "2";
        String label = "Option 2";
        DropdownPage dropdownPage = new DropdownPage(page);
        page.navigate("https://the-internet.herokuapp.com/dropdown");
        dropdownPage.handleDropdownByValue(value);
        assertThat(dropdownPage.selectedOption()).hasText(label);
        System.out.println(dropdownPage.selectedOption().textContent());
    }

    @Test
    public void testDropdownFieldByValue2() {
        String value = "2";
        String label = "Option 2";
        DropdownPage dropdownPage = new DropdownPage(page);
        page.navigate("https://the-internet.herokuapp.com/dropdown");
        dropdownPage.handleDropdownByValue2(value);
        assertThat(dropdownPage.selectedOption()).hasText(label);
        System.out.println(dropdownPage.selectedOption().textContent());
    }

    @Test
    public void testDropdownFieldByIndex() {
        int index = 1;
        String label = "Option 1";
        DropdownPage dropdownPage = new DropdownPage(page);
        page.navigate("https://the-internet.herokuapp.com/dropdown");
        dropdownPage.handleDropdownByIndex(index);
        assertThat(dropdownPage.selectedOption()).hasText(label);
        System.out.println(dropdownPage.selectedOption().textContent());
    }


    @Test
    public void testDropdownFieldByLabel() {
        String label = "Option 1";
        DropdownPage dropdownPage = new DropdownPage(page);
        page.navigate("https://the-internet.herokuapp.com/dropdown");
        dropdownPage.handleDropdownByLabel(label);
        assertThat(dropdownPage.selectedOption()).hasText(label);
        System.out.println(dropdownPage.selectedOption().textContent());
    }
}
