package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class SearchBox {

    public static void main (String[] args){

        String searchInput = "Locators";
        Playwright playwright = Playwright.create();
        BrowserType chrome = playwright.chromium();
        Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
        //Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://playwright.dev/");
        page.click("//a[@role='button']");
        page.click("text='Java'");
        String title =page.locator(".navbar__title.text--truncate").innerText();
        System.out.println(title);
        String expectedString = "Playwright for Java";
        if (title.equals(expectedString)){
            System.out.println("Navigated to Playwright for java");
            page.waitForTimeout(2000);
            page.locator("//button[@aria-label='Search']").click();
            //page.waitForTimeout(2000);
            //page.locator("//kbd[1]//*[name()='svg']").click();
            page.fill("#docsearch-input", searchInput);
            System.out.println();
            //page.locator("//a[@href='/java/docs/locators']//div[@class='DocSearch-Hit-Container']//div[@class='DocSearch-Hit-action']").click();
            page.locator("(//div[@class='DocSearch-Hit-action'])[1]").click();
            //Thread.sleep(10000);
            page.waitForTimeout(2000);
            String expectedHeader = page.locator("div[class='theme-doc-markdown markdown'] header h1").innerText();
            if (searchInput.equals(expectedHeader)){
                System.out.println(searchInput +" page has been opened");
            }
            page.close();
            playwright.close();
        }
        else {
            System.out.println("Unable to Navigate in Playwright for Java");
            page.close();
        }

    }

}
