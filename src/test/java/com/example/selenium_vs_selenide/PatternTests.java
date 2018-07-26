package com.example.selenium_vs_selenide;

import com.example.AbstractTests;
import com.example.page.search.google.GoogleResults;
import com.example.page.search.google.GoogleSearch;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * Test for Example Pattern Tests by selenium and selenide.
 *
 * @author HyungCheol Kim
 *
 */
public class PatternTests extends AbstractTests {
    @Test
    @Disabled
    public void seleniumBasicPattern() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver_mac");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("http://www.google.co.jp");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("selenide");
        element.submit();
        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

        Assert.assertEquals("Selenide～Javaで超簡単・簡潔にUIテストを書く～ - Qiita", findElements.get(0).getText());
        Assert.assertTrue(findElements.size() > 0);
        Assert.assertEquals(10, findElements.size());

        driver.quit();
    }

    @Test
    @Disabled
    public void selenideBasicPattern() {
        open("http://www.google.com");
        $(By.name("q")).val("selenide").pressEnter();

        $("#ires .g").shouldBe(text("Selenide: concise UI tests in Java"));
        $$("#ires .g").shouldHave(sizeGreaterThan(0));
        $$("#ires .g").shouldHaveSize(10);
    }

    @Test
//    @Disabled
    public void selenidePageObjectModelPattern() {
        GoogleSearch searchPage = open("http://www.google.com", GoogleSearch.class);
        GoogleResults resultPage = searchPage.keywordSearchBy("selenide");

        resultPage.firstSectionTitle().shouldBe(text("Selenide: concise UI tests in Java"));
        resultPage.getResult().shouldHave(sizeGreaterThan(0));
        resultPage.getResult().shouldHaveSize(10);
    }
}
