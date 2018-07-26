package com.example.page.ajax;

import com.codeborne.selenide.SelenideElement;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Page Object for Ajax Search Result.
 *
 * @author HyungCheol Kim
 */
public class AjaxResult {
    @Getter
    private final SelenideElement results = $(".result1");

    public SelenideElement textResult() {
        return results.$("#result-text");
    }

    public SelenideElement inputTimeText() {
        return results.$(By.name("time"));
    }

    public void titleIs(String title) {
        Assertions.assertEquals(title, title());
    }

    public void urlIs(String url) {
        Assertions.assertEquals(url, url());
    }
}
