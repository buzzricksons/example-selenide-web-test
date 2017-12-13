package com.example.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

@SpringBootTest
@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class GooglePageTests {
    @Value("${setting.browser}")
    String browser;
    @Value("${setting.screenshot-folder}")
    String screenshotFolder;

    @Test
    public void testGoogleSearch() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");


        System.setProperty("selenide.browser", browser);
        System.setProperty("selenide.reportsFolder", screenshotFolder + now.format(formatter));


        GoogleSearchPage searchPage = open("http://google.com/", GoogleSearchPage.class);
        GoogleResultsPage resultsPage = searchPage.search("selenide");

        resultsPage.results().get(0).shouldHave(text("Selenide: concise UI tests in Java"));

//        Assert.assertEquals(10, resultsPage.results().size());//Default JUnit
        resultsPage.results().shouldHave(size(9));

    }
}
