package pages;

import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class JavaScriptAlertsPage {
    private final Page page;
    private final String JsAlert = "//button[text()='Click for JS Alert']";
    private final String JsAlertConfirm = "//button[text()='Click for JS Confirm']";
    private final String JsAlertPrompt= "//button[text()='Click for JS Prompt']";
    private final String statusMessage= "id=result";

    public JavaScriptAlertsPage (Page page){
    this.page = page;
    }
    public  String clickJSAlert(){
        AtomicReference<String> message = new AtomicReference<>("");
        page.onceDialog(alert-> {
            message.set(alert.message());
            alert.dismiss();
        });
        page.click(JsAlert);
        return  message.toString();
    }


    public String JsAlertConfirm(){
        page.onceDialog(alert-> {
            alert.accept();
        });
        page.click(JsAlertConfirm);
        return  page.locator(statusMessage).textContent();
    }

    public String[] clickAlertPrompt(){
        List<String> messages = new ArrayList<>();
        page.onceDialog(alert-> {
            messages.add(alert.message());
            messages.add(alert.defaultValue());
            alert.accept("Hey Here I'm alicade QA Tester");
        });
        page.click(JsAlertConfirm);
        return new String[] { page.locator(statusMessage).textContent(), messages.toString()};
    }
}
