package com.example.page;

import com.codeborne.selenide.ElementsCollection;
import com.example.AbstractTests;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 * Test for Google Search.
 *
 * @author HyungCheol Kim
 *
 */
public class GooglePageTests3 extends AbstractTests {
    /**
     * Test for keyword "selenide".
     *
     */
    @Test
    public void testGoogleSearch() {
        GoogleSearchPage searchPage = open("http://google.co.jp/", GoogleSearchPage.class);
        GoogleResultsPage resultsPage = searchPage.search("selenide");

        ElementsCollection result = resultsPage.results();

        result.get(0).shouldHave(text("Selenide: concise UI tests in Java"));
        result.get(1).shouldHave(text("Selenide入門 - Qiita"));
        result.get(1).$$(".rc a").get(0).shouldHave(text("Selenide入門 - Qiita"));
        result.shouldHave(size(10));

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(result.get(1).innerHtml());
        System.out.println("--------------------------------------------------------------------------------------");
//        System.out.println(result.find(By.className("rc")).innerHtml());

    }
}
