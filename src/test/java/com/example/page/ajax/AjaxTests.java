package com.example.page.ajax;

import com.example.AbstractTests;
import com.example.settings.AjaxSettings;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

/**
 * Test for Ajax.
 *
 * @author HyungCheol Kim
 *
 */
public class AjaxTests extends AbstractTests {
    @Autowired
    private AjaxSettings settings;

    /**
     * Test for Ajax Example.
     *
     */
    @Test
    public void testAjax() {
        AjaxSearch searchPage = open(settings.getAjaxPage(), AjaxSearch.class);
        AjaxResult resultPage = searchPage.searchBy(settings.getTime());

        resultPage.titleIs("Selenide Ajax example");
        resultPage.urlIs(settings.getAjaxPage());
        resultPage.textResult().shouldBe(appear);
        resultPage.textResult().shouldBe(text("Hello World!"));
        resultPage.inputTimeText().shouldBe(disappear);
    }
}
