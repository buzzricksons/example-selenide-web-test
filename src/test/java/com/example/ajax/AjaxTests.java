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
     * Test for Ajax Example.
     *
     */
    @Test
    public void testAjax() {
        AjaxSearch searchPage = open(settings.getAjaxExamplePage1(), AjaxSearch.class);
        AjaxResult resultPage = searchPage.searchBy(settings.getTime());

        resultPage.timeResult().shouldBe(appear);
        resultPage.timeResult().shouldBe(text("3 seconds later"));
        resultPage.inputTimeText().shouldBe(disappear);
    }
}
