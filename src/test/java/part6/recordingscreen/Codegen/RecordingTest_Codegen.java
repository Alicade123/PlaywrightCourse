package part6.recordingscreen.Codegen;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.io.File;
import java.util.*;

public class RecordingTest_Codegen {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setRecordVideoDir(new File("./snaps/videos/").toPath()).setRecordVideoSize(1270, 720)
            );
            Page page = context.newPage();
            page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("My account")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address")).fill("koushik350@gmail.com");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("Pass123$");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit your account")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name*")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name*")).fill("Ali");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
            Locator successMessage = page.getByText("Success: Your account has");
            assertThat(successMessage).isVisible();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
            Locator logoutSuccessfulMessage = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Account Logout"));
            assertThat(logoutSuccessfulMessage).isVisible();
        }
    }
}
