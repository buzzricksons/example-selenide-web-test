package com.example.page.naver;

import com.example.page.yahoo.YahooResultsPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Page Object for Naver.com Search.
 *
 * @author HyungCheol Kim
 */
public class NaverSearchPage {
    public NaverResultsPage search(String searchKeyword) {
        $(By.name("query")).val(searchKeyword).pressEnter();
        return page(NaverResultsPage.class);
    }
}
