package com.example.ajax;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AjaxResultPage {
    private final SelenideElement results = $(".result1");
    public SelenideElement results() {
        return results;
    }

    public SelenideElement timeText() {
        return results.$("#result-time");
    }

    public SelenideElement inputTimeText() {
        return results.$(By.name("time"));
    }
}
