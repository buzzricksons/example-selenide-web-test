package com.example.page.search;

import com.example.AbstractTests;
import com.example.page.search.google.GoogleResults;
import com.example.page.search.google.GoogleSearch;
import com.example.settings.SearchSettings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 * Test for Google Search.
 *
 * @author HyungCheol Kim
 *
 */
public class GooglePageTests extends AbstractTests {
    @Autowired
    private SearchSettings settings;

    /**
     * Test for keyword "selenide".
     *
     */
    @Test
    @DisplayName("グーグル検索テスト")
    public void googleSearch() {
        GoogleSearch searchPage = open(settings.getGooglePage(), GoogleSearch.class);
        GoogleResults resultPage = searchPage.keywordSearchBy("selenide");

        resultPage.firstSectionTitle().shouldBe(text("Selenide: concise UI tests in Java"));
        resultPage.getResult().shouldHave(sizeGreaterThan(0));
        resultPage.getResult().shouldHaveSize(10);
    }
}
