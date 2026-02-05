package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class FirstTests extends BaseTest {

    @Test
    public void verifyPageTitle() {
        page.navigate("https://google.com/ncr");
        if (page.isVisible("button:has-text('Accept all')")) page.click("button:has-text('Accept all')");
        System.out.println(page.title());
    }
}
