package com.example.ajax;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;

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

    public SelenideElement timeResult() {
        return results.$("#result-time");
    }

    public SelenideElement inputTimeText() {
        return results.$(By.name("time"));
    }

    public void titleIs(String title) {
        Assert.assertEquals(title, title());
    }

    public void urlIs(String url) {
        Assert.assertEquals(url, url());
    }
}
