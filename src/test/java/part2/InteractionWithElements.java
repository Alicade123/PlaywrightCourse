package part2;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InteractionWithElements {
    public static void main(String[] args) {
        //Todo:1. Creating the reusable objects
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();

//        Todo:2. check entered text
        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo/");
        page.waitForSelector("#user-message");
        page.locator("input#user-message").type("Hey Alicade QA Engineer");
        page.locator("#showInput").click();
        assertThat(page.locator("#message")).hasText("Hey Alicade QA Engineer");
//        Todo:3. differentiate 'type' and 'fill'
      //  page.navigate("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo/");
//     //   page.locator("#textbox").type("TestSolutions Rwanda: Software quality assurance from Kigali with an experienced, ISTQB-certified team. Your partner for offshore software testing.");
        //page.locator("#textbox").fill("TestSolutions Rwanda: Software quality assurance from Kigali with an experienced, ISTQB-certified team. Your partner for offshore software testing.");
//        page.navigate("https://letcode.in/edit");
//        String inputText = page.locator("#clearMe").inputValue();
//        System.out.println(inputText);
//        String locatorValue = page.locator("#getMe").getAttribute("placeholder");
//        assertThat(page.locator("#getMe")).hasAttribute("placeholder","Enter ");
//        System.out.println(locatorValue);


        //    Todo:4. check and click
          page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo/");
        Locator checkbox1 = page.getByLabel("Click on check box");
        assertThat(checkbox1).isChecked();
        checkbox1.check();
        assertThat(checkbox1).isChecked();

        //Todo:5. Closing all instances
        page.close();
        browser.close();
        playwright.close();

    }
}
