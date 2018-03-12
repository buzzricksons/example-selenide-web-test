package com.example.page.naver;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Page Object for Naver.com Search.
 *
 * @author HyungCheol Kim
 */
public class NaverSearch {
    public NaverResults keywordSearchBy(String searchKeyword) {
        $(By.name("query")).val(searchKeyword).pressEnter();
        return page(NaverResults.class);
    }
}
