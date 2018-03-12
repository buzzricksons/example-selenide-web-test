package com.example.page.yahoo;

import com.codeborne.selenide.ElementsCollection;
import com.example.AbstractTests;
import org.junit.Test;

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
    /**
     * Test for keyword "selenide".
     *
     */
    @Test
    public void testYahooSearch() {
        YahooSearchPage searchPage = open(getSettings().getYahooPage(), YahooSearchPage.class);
        YahooResultsPage resultsPage = searchPage.keywordSearchBy("selenide");

        resultsPage.firstResultSectionText().shouldBe(text("Selenide～Javaで超簡単・簡潔にUIテストを書く～ - Qiita"));
        resultsPage.result().shouldHaveSize(10);
    }
}
