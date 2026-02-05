package firstSection.alerts;

import com.microsoft.playwright.*;


public class HandleJsAlerts_Dialogs {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setHttpCredentials("admin", "admin")
        );
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        //Todo: confirm alert
        System.out.println("\nConfirm alert");
        page.onceDialog(alert-> {
            System.out.println(alert.message());
            alert.accept();
        });

        //Todo: dismiss alert
        System.out.println("\nDismiss alert");
        page.locator("//button [text()='Click for JS Alert']").click();
        System.out.println(page.locator("#result").textContent());
        page.onceDialog(alert-> {
            System.out.println(alert.message());
            alert.dismiss();
        });
        page.locator("//button [text()='Click for JS Confirm']").click();
        System.out.println(page.locator("#result").textContent());

        //Todo: type in prompt
        System.out.println("\nType in prompt");
        page.onceDialog(alert-> {
            System.out.println(alert.message());
            System.out.println(alert.defaultValue());
            alert.accept("I'm Alicade Software Developer");
        });
        page.locator("//button [text()='Click for JS Prompt']").click();
        System.out.println(page.locator("#result").textContent());

       Page newPage = context.newPage();
       newPage.navigate("https://the-internet.herokuapp.com/basic_auth");
        System.out.println(newPage.locator("div.example p").textContent()); // "Basic Auth"
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
