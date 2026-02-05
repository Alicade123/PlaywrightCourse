package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class DropdownPage {
    private Page page;
    private final String dropdownField = "id=dropdown";
    private final String dropdownFieldChecked = "id=dropdown option:checked";

    public DropdownPage(Page page) {
        this.page = page;
    }

    public void handleDropdownByValue(String value) {
        Locator dropdown = page.locator(dropdownField);
        List<String> selected =  dropdown.selectOption(value);

    }

    public void handleDropdownByValue2(String value) {
        Locator dropdown = page.locator(dropdownField);
        dropdown.selectOption(new SelectOption().setValue(value));
    }
    public void handleDropdownByIndex(int index) {
        Locator dropdown = page.locator(dropdownField);
  dropdown.selectOption(new SelectOption().setIndex(index));
    }


    public void handleDropdownByLabel(String label) {
        Locator dropdown = page.locator(dropdownField);
       dropdown.selectOption(new SelectOption().setLabel(label));
    }

    public Locator selectedOption() {
        return page.locator("#dropdown option:checked");
    }
}
