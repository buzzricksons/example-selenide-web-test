package com.example.page.search.google;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
/**
 * Page Object for Google Search.
 *
 * @author HyungCheol Kim
 */
public class GoogleSearch {
    public GoogleResults keywordSearchBy(String keyword) {
        $(By.name("q")).val(keyword).pressEnter();
        return page(GoogleResults.class);
    }
}
