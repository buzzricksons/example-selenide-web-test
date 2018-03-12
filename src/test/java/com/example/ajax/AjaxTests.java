package com.example.ajax;

import com.example.AbstractTests;
import com.example.Settings;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class AjaxTests extends AbstractTests {
    @Autowired
    private Settings settings;

    /**
     * Test for Ajax.
     *
     */
    @Test
    public void testAjax() {
        AjaxSearchPage searchPage = open(settings.getAjaxExamplePage1(), AjaxSearchPage.class);
        AjaxResultPage resultPage = searchPage.searchBy(settings.getTime());

        resultPage.timeText().shouldBe(appear);
        resultPage.timeText().shouldBe(text("3 seconds later"));
        resultPage.inputTimeText().shouldBe(disappear);
    }
}
