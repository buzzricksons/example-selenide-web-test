package com.example.page.google;

import com.example.AbstractTests;
import com.example.Settings;
import org.junit.Test;
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
    private Settings settings;

    /**
     * Test for keyword "selenide".
     *
     */
    @Test
    public void testGoogleSearch() {
        GoogleSearch searchPage = open(settings.getGooglePage(), GoogleSearch.class);
        GoogleResults resultPage = searchPage.keywordSearchBy("selenide");

        resultPage.firstSectionText().shouldBe(text("Selenide: concise UI tests in Java"));
        resultPage.getResult().shouldHave(sizeGreaterThan(0));
        resultPage.getResult().shouldHaveSize(10);
    }
}
