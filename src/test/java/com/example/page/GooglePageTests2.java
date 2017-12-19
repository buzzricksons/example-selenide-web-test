package com.example.page;

import com.example.AbstractTests;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GooglePageTests2 extends AbstractTests {
    @Test
    public void testGoogleSearch() {
        GoogleSearchPage searchPage = open("http://google.com/", GoogleSearchPage.class);
        GoogleResultsPage resultsPage = searchPage.search("selenide");

        resultsPage.results().get(0).shouldHave(text("Selenide: concise UI tests in Java"));

//        Assert.assertEquals(10, resultsPage.results().size());//If Default JUnit
        resultsPage.results().shouldHave(size(10));

    }
}
