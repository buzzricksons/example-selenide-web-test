package com.example.page.ajax;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Page Object for Ajax Search.
 *
 * @author HyungCheol Kim
 */
public class AjaxSearch {
    public AjaxResult searchBy(String time) {
        $(By.name("time")).setValue(time);
        $("#button1").click();
        return page(AjaxResult.class);
    }
}
