package com.example.ajax;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AjaxResult {
    private final SelenideElement results = $(".result1");
    public SelenideElement results() {
        return results;
    }

    public SelenideElement timeResult() {
        return results.$("#result-time");
    }

    public SelenideElement inputTimeText() {
        return results.$(By.name("time"));
    }
}
