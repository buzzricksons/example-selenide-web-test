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
        YahooSearchPage searchPage = open("http://yahoo.co.jp/", YahooSearchPage.class);
        YahooResultsPage resultsPage = searchPage.search("selenide");

        ElementsCollection result = resultsPage.results();

        result.get(0).shouldHave(text("Selenide～Javaで超簡単・簡潔にUIテストを書く～ - Qiita"));
        result.get(0).$$(".hd a").get(0).shouldHave(text("Selenide～Javaで超簡単・簡潔にUIテストを書く～ - Qiita"));
        result.shouldHave(size(10));

//        System.out.println("--------------------------------------------------------------------------------------");
//        System.out.println(result.get(1).innerHtml());
//        System.out.println("--------------------------------------------------------------------------------------");
//        System.out.println(result.find(By.className("rc")).innerHtml());

    }
}
