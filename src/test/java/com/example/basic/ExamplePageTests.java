package com.example.basic;

import com.example.AbstractTests;
import com.example.page.google.GoogleResultsPage;
import com.example.page.google.GoogleSearchPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * Test for Example Google Search by selenium and selenide.
 *
 * @author HyungCheol Kim
 *
 */
public class ExamplePageTests extends AbstractTests {
    /**
     * Test for keyword "selenide" by Selenium Basic pattern.
     *
     */
    @Test
    public void seleniumBasicPattern() {
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("/path/to/google-chrome-stable");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");

        final DesiredCapabilities dc = new DesiredCapabilities();
        dc.setJavascriptEnabled(true);
        dc.setCapability(
                ChromeOptions.CAPABILITY, chromeOptions
        );


//        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        WebDriver driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("http://www.google.co.jp");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("selenide");
        element.submit();
        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

        Assert.assertEquals("Selenide～Javaで超簡単・簡潔にUIテストを書く～ - Qiita", findElements.get(0).getText());
        Assert.assertEquals(10, findElements.size());

        driver.quit();
    }

    /**
     * Test for keyword "selenide" by Selenide Basic pattern.
     *
     */
    @Test
    public void selenideBasicPattern() {
        open("http://www.google.co.jp");
        $(By.name("q")).val("selenide").pressEnter();

        $("#ires .g").shouldBe(text("Selenide～Javaで超簡単・簡潔にUIテストを書く～ - Qiita"));
        $$("#ires .g").shouldHaveSize(10);
    }

    /**
     * Test for keyword "selenide" by Selenide Page Object Model pattern.
     *
     */
    @Test
    public void selenidePageObjectModelPattern() {
        GoogleSearchPage searchPage = open("http://www.google.co.jp", GoogleSearchPage.class);
        GoogleResultsPage resultsPage = searchPage.keywordSearchBy("selenide");

        resultsPage.firstSectionText().shouldBe(text("Selenide～Javaで超簡単・簡潔にUIテストを書く～ - Qiita"));
        resultsPage.result().shouldHaveSize(10);
    }
}
