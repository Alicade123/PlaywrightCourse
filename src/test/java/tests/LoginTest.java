package tests;

import base.BaseTest;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {


    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage(page);
        DashboardPage dashboardPage = new DashboardPage(page);
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.addUsername("Admin");
        loginPage.addPassword("admin123");
        loginPage.clickLoginButton();
        if(dashboardPage.verifyHeader()) System.out.println("passed");
        else System.out.println("failed");

    }

}
