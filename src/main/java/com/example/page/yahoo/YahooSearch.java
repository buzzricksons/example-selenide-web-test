package com.example.page.yahoo;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Page Object for Yahoo.co.jp Search.
 *
 * @author HyungCheol Kim
 */
public class YahooSearch {
    public YahooResults keywordSearchBy(String searchKeyword) {
        $(By.name("p")).val(searchKeyword).pressEnter();
        return page(YahooResults.class);
    }
}
