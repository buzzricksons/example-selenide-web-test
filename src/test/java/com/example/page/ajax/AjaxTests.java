package com.example.page.ajax;

import com.example.AbstractTests;
import com.example.page.ajax.AjaxResult;
import com.example.page.ajax.AjaxSearch;
import com.example.settings.AjaxSettings;
import com.example.settings.Settings;
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
    private AjaxSettings ajaxSettingssettings;

    /**
     * Test for Ajax Example.
     *
     */
    @Test
    public void testAjax() {
        AjaxSearch searchPage = open(ajaxSettingssettings.getExamplePage1(), AjaxSearch.class);
        AjaxResult resultPage = searchPage.searchBy(ajaxSettingssettings.getTime());

        resultPage.titleIs("Selenide Ajax example");
        resultPage.urlIs("http://localhost:11080/top");
        resultPage.timeResult().shouldBe(appear);
        resultPage.timeResult().shouldBe(text("3 seconds later"));
        resultPage.inputTimeText().shouldBe(disappear);
    }
}
