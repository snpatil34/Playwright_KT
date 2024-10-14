package Pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.Assert;

import java.nio.file.Paths;

public class SearchEngine {
    protected static Playwright playwright = Playwright.create();
    protected static BrowserType chrome = playwright.chromium();
    protected static Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
    protected static Page page = browser.newPage();
    static String expectedString = "Playwright for Java";

    public static void launchApp(){
        page.navigate("https://playwright.dev/");
    }
    public static void dropdownClick(){
        page.click("//a[@role='button']");
        page.click("text='Java'");
        String title =page.locator(".navbar__title.text--truncate").innerText();
        if (title.equals(expectedString)) {
            System.out.println("Navigated to Playwright for java");
        }
    }
    public static void clickOnSearch(String searchInput){
        page.waitForTimeout(2000);
        page.locator("//button[@aria-label='Search']").click();
        page.fill("#docsearch-input", searchInput);
    }

    public static void displayExpectedTopic(String header){
        page.waitForTimeout(2000);
        page.locator("(//div[@class='DocSearch-Hit-action'])[1]").click();
        String expectedHeader = page.locator("div[class='theme-doc-markdown markdown'] header h1").innerText();
       Assert.assertTrue("unable to open " +header +" page",expectedHeader.contains(header));
       page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")).setFullPage(true));

    }

}
