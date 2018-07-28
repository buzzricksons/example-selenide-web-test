package com.example.page.search;

import com.example.AbstractTests;
import com.example.page.search.naver.NaverResults;
import com.example.page.search.naver.NaverSearch;
import com.example.settings.SearchSettings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @Autowired
    private SearchSettings settings;

    /**
     * Test for keyword "selenide".
     *
     */
    @Test
    @DisplayName("Naver検索👨🏻‍💻テスト")
    public void naverSearch() {
        NaverSearch searchPage = open(settings.getNaverPage(), NaverSearch.class);
        NaverResults resultsPage = searchPage.keywordSearchBy("selenide");

        resultsPage.firstResultSectionText().shouldHave(text("selenide 예문보기\n" +
                "셀렌화물(化物): 2가(價)의 셀렌과 그보다 전기적으로 양성인 원소 또는 원자단과의 화합..."));
    }
}
