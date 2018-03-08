package com.example.page.naver;

import com.example.AbstractTests;
import com.example.Settings;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 * Test for Naver.com Search.
 *
 * @author HyungCheol Kim
 *
 */
public class NaverPageTests extends AbstractTests {
    /**
     * Test for keyword "selenide".
     *
     */
    @Test
    public void testNaverSearch() {
        NaverSearchPage searchPage = open(getSettings().getNaverPage(), NaverSearchPage.class);
        NaverResultsPage resultsPage = searchPage.keywordSearchBy("selenide");

        resultsPage.results().get(0).find(".dic_dsc").shouldHave(text("selenide 예문보기\n" +
                "셀렌화물(化物): 2가(價)의 셀렌과 그보다 전기적으로 양성인 원소 또는 원자단과의 화합..."));
    }
}
