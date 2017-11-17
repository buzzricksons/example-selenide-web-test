package com.example.page;

import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GooglePageTests {
    @Test
    public void testGoogleSearch() {
        System.setProperty("selenide.browser", "Chrome");
        GoogleSearchPage searchPage = open("http://google.com/", GoogleSearchPage.class);

        GoogleResultsPage resultsPage = searchPage.search("selenide");

        resultsPage.results().shouldHave(size(10));
        resultsPage.results().get(0).shouldHave(text("Selenide: concise UI tests in Java"));

    }
}
