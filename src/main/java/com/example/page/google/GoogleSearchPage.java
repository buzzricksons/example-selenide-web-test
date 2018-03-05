package com.example.page.google;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
/**
 * Page Object for Google Search.
 *
 * @author HyungCheol Kim
 */
public class GoogleSearchPage {
    public GoogleResultsPage keywordSearchBy(String keyword) {
        $(By.name("q")).val(keyword).pressEnter();
        return page(GoogleResultsPage.class);
    }
}
