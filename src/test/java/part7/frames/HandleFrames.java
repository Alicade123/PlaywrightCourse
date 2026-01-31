package part7.frames;

import com.microsoft.playwright.*;

import java.util.List;

public class HandleFrames {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/iframe");
        FrameLocator frameLocator = page.frameLocator("#mce_0_ifr");
        Locator bodyLocatorInFrame = frameLocator.locator("#tinymce");
//        bodyLocatorInFrame.click();
//        bodyLocatorInFrame.fill("Hey, Here were in the frame can you try to type there?");
        String defaultText = bodyLocatorInFrame.textContent();
        System.out.println(defaultText);

        page.navigate("https://letcode.in/frame");
        FrameLocator firstFrameLocator  = page.frameLocator("#firstFr");
        Locator firstName = firstFrameLocator.locator("input[placeholder='Enter name']");
        Locator secondName = firstFrameLocator.locator("input[name='lname']");
        firstName.fill("Alicade Software Tester");
        secondName.fill("ABITURIJE Developer");
        FrameLocator innerFrameLocator = firstFrameLocator.frameLocator("iframe[src='innerframe']");
        innerFrameLocator.getByPlaceholder("Enter email").fill("abiturije@gmail.com");

        List<Frame> ourFrames = page.frames();
        System.out.println(ourFrames.size());
        ourFrames.forEach(e-> System.out.println(e.url()));
        page.close();
        browser.close();
        playwright.close();

    }
}
