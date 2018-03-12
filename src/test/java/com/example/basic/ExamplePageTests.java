package com.example.basic;

import com.example.AbstractTests;
import com.example.page.google.GoogleResults;
import com.example.page.google.GoogleSearch;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    @Test
    public void seleniumBasicPattern() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("selenide");
        element.submit();
        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

        Assert.assertEquals("Selenide: concise UI tests in Java", findElements.get(0).getText());
        Assert.assertEquals(10, findElements.size());

        driver.quit();
    }

    @Test
    public void selenideBasicPattern() {
        open("http://www.google.com");
        $(By.name("q")).val("selenide").pressEnter();

        $("#ires .g").shouldBe(text("Selenide: concise UI tests in Java"));
        $$("#ires .g").shouldHaveSize(10);
    }

    @Test
    public void selenidePageObjectModelPattern() {
        GoogleSearch searchPage = open("http://www.google.com", GoogleSearch.class);
        GoogleResults resultPage = searchPage.keywordSearchBy("selenide");

        resultPage.firstSectionText().shouldBe(text("Selenide: concise UI tests in Java"));
        resultPage.result().shouldHaveSize(10);
    }
}
