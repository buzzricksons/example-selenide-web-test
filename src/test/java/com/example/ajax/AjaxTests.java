package com.example.ajax;

import com.example.AbstractTests;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AjaxTests extends AbstractTests {
    /**
     * Test for Ajax.
     *
     */
    @Test
    public void testAjax() {
        open(getSettings().getAjaxExamplePage1());
        $(By.name("time")).setValue("3");
        $("#button1").click();

        $("#test1").shouldHave(text("3 seconds later"));


    }
}
