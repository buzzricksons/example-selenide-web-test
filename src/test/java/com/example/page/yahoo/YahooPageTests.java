package com.example.page.yahoo;

import com.codeborne.selenide.ElementsCollection;
import com.example.AbstractTests;
import com.example.Settings;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 * Test for Yahoo.co.jp Search.
 *
 * @author HyungCheol Kim
 *
 */
public class YahooPageTests extends AbstractTests {
    @Autowired
    private Settings settings;

    /**
     * Test for keyword "selenide".
     *
     */
    @Test
    public void testYahooSearch() {
        YahooSearchPage searchPage = open(settings.getYahooPage(), YahooSearchPage.class);
        YahooResultsPage resultsPage = searchPage.search("selenide");

        ElementsCollection result = resultsPage.results();

        result.get(0).shouldHave(text("Selenide～Javaで超簡単・簡潔にUIテストを書く～ - Qiita"));
        result.get(0).$(".hd a").shouldHave(text("Selenide～Javaで超簡単・簡潔にUIテストを書く～ - Qiita"));
        result.shouldHave(size(10));
    }
}
