package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;

import java.util.Arrays;

public class JavaScriptAlertsTest extends BaseTest {
    @Test
    public  void testJavaScriptAlerts(){
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(page);
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        String actualResults =  javaScriptAlertsPage.clickJSAlert();
        System.out.println(actualResults);
    }

    @Test
    public  void testJavaScriptConfirm(){
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(page);
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        String actualResults =  javaScriptAlertsPage.JsAlertConfirm();
        System.out.println(actualResults);
    }

    @Test
    public  void testJavaScriptPrompt(){
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(page);
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        String [] actualResults  =  javaScriptAlertsPage.clickAlertPrompt();
        Arrays.stream(actualResults).forEach(System.out::println);
    }
}
