package tests;

import base.BaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTestsUsingCodegenInspector extends BaseTest {
    @Test
      public void loginTest(){
          page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
          page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
          page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("Admin");
          page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("admin123");
          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
          assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dashboard"))).hasText("Dashboard");
      }
}
