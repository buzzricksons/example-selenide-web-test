package com.example.page.search;

import com.example.AbstractTests;
import com.example.page.search.yahoo.YahooResults;
import com.example.page.search.yahoo.YahooSearch;
import com.example.settings.SearchSettings;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 * Test for Yahoo.co.jp Search.
 *
 * @author HyungCheol Kim
 */
public class YahooPageTests extends AbstractTests {
    @Autowired
    private SearchSettings settings;

    /**
     * Test for keyword "selenide".
     */
    @Test
    @DisplayName("ヤフー検索テスト")
    public void yahooSearch() {
        YahooSearch searchPage = open(settings.getYahooPage(), YahooSearch.class);
        YahooResults resultsPage = searchPage.keywordSearchBy("selenide");

        resultsPage.firstResultSectionText().shouldBe(text("Selenide～Javaで超簡単・簡潔にUIテストを書く～ - Qiita"));
        resultsPage.getResult().shouldHave(sizeGreaterThan(0));
        resultsPage.getResult().shouldHaveSize(10);
    }
}
